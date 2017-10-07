package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	/**
	 * 保存客户
	 */
	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}
	/**
	 * 获取分页数据
	 */
	@Override
	public List<Customer> findPageList(DetachedCriteria dc,int start, int pageSize) {
		// 清空之前设置查询总行的信息
		dc.setProjection(null);
		  List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(dc, start, pageSize);
		return list;
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int findAllCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		 List<Long> find = (List<Long>) hibernateTemplate.findByCriteria(dc);
		return find.get(0).intValue();
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Customer> findCustomerList() {
		List<Customer> list = (List<Customer>) hibernateTemplate.find("from Customer");
	 for (Customer customer : list) {
		System.out.println(customer);
	}
		return list;
	}
	@Override
	public Customer findById(Long cust_id) {
		 Customer customer = hibernateTemplate.get(Customer.class, cust_id);
			return customer;
	}
	/**
	 * 修改信息
	 */
	@Override
	public void updateCustomer(Customer customer) {
		hibernateTemplate.update(customer);
		
	}
	/**
	 * 删除用户
	 */
	@Override
	public void deleteCustomer(Customer c) {
		hibernateTemplate.delete(c);
		
	}

}

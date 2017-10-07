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
	 * ����ͻ�
	 */
	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}
	/**
	 * ��ȡ��ҳ����
	 */
	@Override
	public List<Customer> findPageList(DetachedCriteria dc,int start, int pageSize) {
		// ���֮ǰ���ò�ѯ���е���Ϣ
		dc.setProjection(null);
		  List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(dc, start, pageSize);
		return list;
	}
	/**
	 * ��ѯ������
	 */
	@Override
	public int findAllCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		 List<Long> find = (List<Long>) hibernateTemplate.findByCriteria(dc);
		return find.get(0).intValue();
	}
	
	/**
	 * ��ѯ����
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
	 * �޸���Ϣ
	 */
	@Override
	public void updateCustomer(Customer customer) {
		hibernateTemplate.update(customer);
		
	}
	/**
	 * ɾ���û�
	 */
	@Override
	public void deleteCustomer(Customer c) {
		hibernateTemplate.delete(c);
		
	}

}

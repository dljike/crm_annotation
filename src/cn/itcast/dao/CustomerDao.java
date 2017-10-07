package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	/**
	 * 保存
	 * @param customer
	 */
	void save(Customer customer);
	/**
	 * 获取分页数据
	 * @param dc 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Customer> findPageList(DetachedCriteria dc, int start, int pageSize);
	/**
	 * 查询总条数
	 * @return
	 */
	int findAllCount(DetachedCriteria dc);
	
	
	List<Customer> findCustomerList();
	Customer findById(Long cust_id);
	void updateCustomer(Customer oldCustomer);
	void deleteCustomer(Customer c);

}

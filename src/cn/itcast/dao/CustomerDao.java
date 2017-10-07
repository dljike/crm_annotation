package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	/**
	 * ����
	 * @param customer
	 */
	void save(Customer customer);
	/**
	 * ��ȡ��ҳ����
	 * @param dc 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Customer> findPageList(DetachedCriteria dc, int start, int pageSize);
	/**
	 * ��ѯ������
	 * @return
	 */
	int findAllCount(DetachedCriteria dc);
	
	
	List<Customer> findCustomerList();
	Customer findById(Long cust_id);
	void updateCustomer(Customer oldCustomer);
	void deleteCustomer(Customer c);

}

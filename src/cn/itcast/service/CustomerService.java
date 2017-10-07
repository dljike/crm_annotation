package cn.itcast.service;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerService {
	/**
	 * ��ӿͻ�
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
	 * @param dc 
	 * @return
	 */
	int findAllCount(DetachedCriteria dc);
	List<Customer> findCustomerList();
	Customer findCustomerById(Long cust_id);
	void updateCustomer(Customer customer, File upload, String uploadFileName);
	void deleteCustomer(Long cust_id);

}

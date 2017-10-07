package cn.itcast.service;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerService {
	/**
	 * 添加客户
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
	 * @param dc 
	 * @return
	 */
	int findAllCount(DetachedCriteria dc);
	List<Customer> findCustomerList();
	Customer findCustomerById(Long cust_id);
	void updateCustomer(Customer customer, File upload, String uploadFileName);
	void deleteCustomer(Long cust_id);

}

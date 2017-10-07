package cn.itcast.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;
import cn.itcast.utils.SystemConstants;
import cn.itcast.utils.UploadUtils;
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/customer")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
 
	private static final long serialVersionUID = 1L;
	
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	@Autowired
	private CustomerService customerService;
	
	private int page; // ��ȡҳ�淢�͵ĵ�ǰҳ ����Ҫ�ṩset����
	private int pageSize; //���յ�ǰ�ǵڼ�ҳ���ṩset����
	private PageBean<Customer> pblist; // ��ҳ��pagebeanҪ�ṩget��������Ϊҳ��Ҫ��ȡ

	// �����ļ��ϴ����
	private File upload; // ��ʾ�ϴ��ļ�������Ҫ��ҳ����file��nameһ��  ��ȡҳ������ �ṩset����
	private String uploadContentType; // ��ʾ�ϴ��ļ����� �ṩset����   
	private String uploadFileName; // �ϴ��ļ������� �ṩset����
	
	private Customer customerView; // ���޸�ҳ�洫����Ϣ
	

	private List<Customer> customers; // ajax ��ȡ�����û� �ṩget
	
	public Customer getCustomerView() {
		return customerView;
	}
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public PageBean<Customer> getPblist() {
		return pblist;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Action(value="save",results={@Result(name="success",type="redirectAction",location="findPageList")})
	public String save(){
		if (StringUtils.isBlank(customer.getBaseDictIndustry().getDict_id())) {
			customer.setBaseDictIndustry(null);
		}
		if (StringUtils.isBlank(customer.getBaseDictLevel().getDict_id())) {
			customer.setBaseDictLevel(null);
		}
		if (StringUtils.isBlank(customer.getBaseDictSource().getDict_id())) {
			customer.setBaseDictSource(null);
		}
		if (upload != null) {
			// ��������ļ���
			String randomFileName = UploadUtils.generateRandonFileName(uploadFileName);
			// �����������Ŀ¼
			String randomDir = UploadUtils.generateRandomDir(randomFileName);
			// ͼƬ���浽ָ��·��
			try {
				FileUtils.copyFile(upload, new File(SystemConstants.baseDir+randomDir+"/"+randomFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// �������ݿ�ͼƬ����·��
			customer.setCust_image(randomDir+"/"+randomFileName);
			// �������ݿ�ͼƬ��ʵ����
			customer.setCust_filename(uploadFileName);
		}
		
		customerService.save(customer);
		return SUCCESS;
	}
	
	@Action(value="findPageList",results={@Result(name="success",location="/jsp/customer/list.jsp")})
	public String findPageList(){
		pblist = new PageBean<Customer>();
		if (pageSize != 0) {
			pblist.setPageSize(pageSize);
		}
		if (page != 0) {
			pblist.setCuurentPage(page);
		}
		
		// �������߲�ѯ����
				DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
				// ƴ������
				if (StringUtils.isNotBlank(customer.getCust_name())) {
						dc.add(Restrictions.eq("cust_name", customer.getCust_name()));
				}
				if(customer.getBaseDictIndustry() != null){
					if (StringUtils.isNotBlank(customer.getBaseDictIndustry().getDict_id())) {
						dc.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
					}
				}
				if(customer.getBaseDictSource() != null){
					if (StringUtils.isNotBlank(customer.getBaseDictSource().getDict_id())) {
						dc.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
					}
				}
				if(customer.getBaseDictLevel() != null){
					if (StringUtils.isNotBlank(customer.getBaseDictLevel().getDict_id())) {
						dc.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
					}
				}
 
		
		// ��ѯ������
		int count = customerService.findAllCount(dc);
		pblist.setTotal(count);
		List<Customer> clist = customerService.findPageList(dc,pblist.getStart(),pblist.getPageSize());
		pblist.setDatas(clist);
		
		return SUCCESS;
	}
	
	/**
	 * ������ϵ�˻�ȡ�ͻ��б�
	 * @return
	 */
	@Action(value="findCustomerList",results={@Result(type="json",params={"root","customers"})})
	public String findCustomerList(){
		customers = customerService.findCustomerList();
		return SUCCESS;
	}
	
	@Action(value="findCustomerById",results={@Result(name="success",location="/jsp/customer/edit.jsp")})
	public String findCustomerById(){
		customerView = customerService.findCustomerById(customer.getCust_id());
		return SUCCESS;
	}
	/**
	 * �޸���Ϣ
	 * @return
	 */
	@Action(value="updateCustomer",results={@Result(name="success",type="redirectAction",location="findPageList")})
	public String updateCustomer(){
		customerService.updateCustomer(customer,upload,uploadFileName);
		return SUCCESS;
	}
	@Action(value="deleteCustomer",results={@Result(name="success",type="redirectAction",location="findPageList")})
	public String deleteCustomer(){
		customerService.deleteCustomer(customer.getCust_id());
		return SUCCESS;
	}

}

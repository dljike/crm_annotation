package cn.itcast.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="cst_linkman")
public class LinkMan implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long lkm_id;   // ��ϵ�˱��
	private String lkm_name; // ��ϵ������
	private String lkm_gender; // ��ϵ���Ա�
	private String lkm_phone; // ��ϵ�˰칫�绰
	private String lkm_mobile; // ��ϵ���ֻ�
	private String lkm_email; // ��ϵ������
	private String lkm_position; // ��ϵ��ְλ
	private String lkm_memo; // ��ϵ�˱�ע
	//�����ϵ������ͬһ�ͻ�: ���һ
	@ManyToOne
	@JoinColumn(name="lkm_cust_id")
	private Customer cust;
	
	public Long getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Long lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	public String getLkm_mobile() {
		return lkm_mobile;
	}
	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}
	public String getLkm_email() {
		return lkm_email;
	}
	public void setLkm_email(String lkm_email) {
		this.lkm_email = lkm_email;
	}
	public String getLkm_position() {
		return lkm_position;
	}
	public void setLkm_position(String lkm_position) {
		this.lkm_position = lkm_position;
	}
	public String getLkm_memo() {
		return lkm_memo;
	}
	public void setLkm_memo(String lkm_memo) {
		this.lkm_memo = lkm_memo;
	}
	public Customer getCustomer() {
		return cust;
	}
	public void setCustomer(Customer customer) {
		this.cust = customer;
	}

	@Override
	public String toString() {
		return "LinkMan [lkm_id=" + lkm_id + ", lkm_name=" + lkm_name + ", lkm_gender=" + lkm_gender + ", lkm_phone="
				+ lkm_phone + ", lkm_mobile=" + lkm_mobile + ", lkm_email=" + lkm_email + ", lkm_position="
				+ lkm_position + ", lkm_memo=" + lkm_memo + ", customer="  + "]";
	}
	
 
  
	
	

}

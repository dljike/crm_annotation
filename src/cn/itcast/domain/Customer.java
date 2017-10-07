package cn.itcast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="cst_customer")
public class Customer implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cust_id; // 客户编号
	private String cust_name; // 客户公司名称
	private String cust_phone; // 固定电话
	private String cust_address; // 客户联系地址
	private String cust_image; // 图片保存路径
	private String cust_filename; // 图片真实的名字
	
	@ManyToOne
	@JoinColumn(name="cust_source") // 设置外键
	private BaseDict baseDictSource; //客户所属行业
	@ManyToOne
	@JoinColumn(name="cust_industry")// 设置外键
	private BaseDict baseDictIndustry; //客户级别
	@ManyToOne
	@JoinColumn(name="cust_level")// 设置外键
	private BaseDict baseDictLevel; //客户级别
	
	@OneToMany(mappedBy="cust")
	private Set<LinkMan> linkMans = new HashSet<LinkMan>();
	
	
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	public String getCust_image() {
		return cust_image;
	}
	public void setCust_image(String cust_image) {
		this.cust_image = cust_image;
	}
	public String getCust_filename() {
		return cust_filename;
	}
	public void setCust_filename(String cust_filename) {
		this.cust_filename = cust_filename;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_phone=" + cust_phone
				+ ", cust_address=" + cust_address + ", cust_image=" + cust_image + ", cust_filename=" + cust_filename
				+ ", baseDictSource=" + baseDictSource + ", baseDictIndustry=" + baseDictIndustry + ", baseDictLevel="
				+ baseDictLevel + ", linkMans="  + "]";
	}

 	
	
}

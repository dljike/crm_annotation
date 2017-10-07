package cn.itcast.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.PageBean;
@Controller("linkManAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/linkman")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
 
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LinkManService linkManService;
	
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	private int pageSize; // 接收当前页数，提供set方法
	private int page; // 接收当前是第几页，提供set方法
	
	private PageBean<LinkMan> pb; // 分页的pagebean要提供get方法，因为页面要获取
 
	public PageBean<LinkMan> getPb() {
		return pb;
	}
 
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
 
	public void setPage(int page) {
		this.page = page;
	}

//	@Action(value="save",results={@Result(name="success",type="redirectAction" ,location="findLinkManList")})
//	public String save(){
//		if (linkMan.getCustomer().getCust_id() == null) {
//			this.addActionError("所属客户不能为空");
//			return "fail";
//		}
//		linkManService.save(linkMan);
//		return SUCCESS;
//	}
	/**
	 * 获取列表数据
	 * @return
	 */
	@Action(value="findLinkManList",results={@Result(name="success" ,location="/jsp/linkman/list.jsp")})
	public String findLinkManList(){
		
		pb = new PageBean<LinkMan>();
		if (page != 0) {
			pb.setCuurentPage(page);
		}
		if (pageSize != 0) {
			pb.setPageSize(pageSize);
		}
		// 构造离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// 查询表里总记录数
		int total = linkManService.findCount(dc);
		pb.setTotal(total);
		List<LinkMan> list = linkManService.findPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setDatas(list);
		
		return SUCCESS;
	}
	
	
}

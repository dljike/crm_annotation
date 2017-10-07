package cn.itcast.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;
@Controller("baseDictAction")
@Scope("prototype")
@Namespace("/baseDict")
@ParentPackage("json-default")
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
 
	private static final long serialVersionUID = 1L;
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	@Autowired
	private BaseDictService baseDictService;
	
	private List<BaseDict> dicList;
	
	public List<BaseDict> getDicList() {
		return dicList;
	}
	
	/**
	 * ²éÕÒ×Öµä
	 * @return
	 */
	@Action(value="findDict",results={@Result(type="json",params={"root","dicList"})})
	public String findDict(){
		dicList = baseDictService.findDictByTypeCode(baseDict);
		return SUCCESS;
	}
	
	

}

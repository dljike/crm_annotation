package cn.itcast.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@Controller("userAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/user")
public class UserAction extends ActionSupport implements ModelDriven<User>{
 
	private static final long serialVersionUID = 1L;

	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 用户注册
	 * @return
	 */
	@Action(value="regist",results={@Result(name="success",location="/login.jsp")})
	public String regist(){
		userService.regist(user);
		return SUCCESS;
	}
	@Action(value="login",results={
			@Result(name="success",location="/index.jsp"),
			@Result(name="login",location="/login.jsp")
	})
	public String login(){
		System.out.println(user);
		User uu = userService.login(user);
		if (uu == null) {
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}
		return SUCCESS;
	}
	
	

}

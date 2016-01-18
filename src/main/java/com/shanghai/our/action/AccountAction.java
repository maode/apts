package com.shanghai.our.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.Admin;
import com.shanghai.our.service.IAdminService;


@ParentPackage("basePackage")
@Namespace("/")
public class AccountAction extends BaseAction<Admin>{

	
	
	/**
	 * delete key after push test
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAdminService  adminService;
	
	/**
	 * 用户接口注入
	 */
	private Admin admin;
	/**
	 * 跳转到登陆界面
	 * @return
	 */
	@Action(value = "login", results = { @Result(name = "login", location = "/login.jsp") })
	public String login(){
		return "login";
	}
	@Action(value="loginDo")
	public void loginDo(){
		try{
		admin=this.adminService.getByUserName(admin.getUsername(), admin.getPassword());
		if(admin!=null){
		 ServletActionContext.getRequest().getSession().setAttribute(ConstantOur.SESSION_USERINFO, admin);
		responseStr("success");
		}else{
			responseStr("用户名或密码错误！");
		}
		}catch(Exception e){
			e.printStackTrace();
			responseStr("服务器出现错误");
		}
	}

	
	@Action(value = "index", results = { @Result(name = "index", location = "/index.jsp") })
	public String  index(){
		
		return "index";
	}
	
	@Action(value = "logout", results = { @Result(name = "logout",type="redirectAction", location = "login.action") })
	public String  logout(){
		getRequest().getSession().invalidate();
		return "logout";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
	
	
	
}

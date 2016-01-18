package com.shanghai.our.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.UserInfo;
import com.shanghai.our.service.IUserInfoService;
import com.shanghai.our.utils.MD5Util;

@ParentPackage("basePackage")
@Namespace("/")
public class UserInfoAction extends BaseAction<UserInfo>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserInfo userInfo;
	private Integer status;
	@Autowired
	private  IUserInfoService userInfoService;

	/**
	 * 待审核列表--废弃
	 * @return
	 */
	@Action(value="userInfoAppList", results = { @Result(name = "userInfoAppList", location = "/userinfo/userInfoAppList.jsp") })
	public String userInfoAppList(){
		Map<String,Object> map=new HashMap<String,Object>();
		if(userInfo==null)
			userInfo=new UserInfo();
		userInfo.setStatus(1);
		userInfo.setDelFlag(1);
		map.put("userInfo.realname", userInfo.getRealname());
		map.put("userInfo.email", userInfo.getEmail());
		map.put("userInfo.telephone", userInfo.getTelephone());
		initPage(map);
		Long total=this.userInfoService.findAllCount(userInfo);
		this.pager.setTotalRecords(total);
		List<UserInfo> list=this.userInfoService.findAll(this.pager.getFirstResult(), this.pager.getMaxResult(), userInfo);
		this.pager.setRecords(list);
		ServletActionContext.getContext().put("list",list);
		return "userInfoAppList";
	}
	
	/**
	 * 用户管理查看列表
	 * @return
	 */
	@Action(value="userInfoList", results = { @Result(name = "userInfoList", location = "/userinfo/userInfoList.jsp") })
	public String  userInfoList(){
		Map<String,Object> map=new HashMap<String,Object>();
		if(userInfo==null)
			userInfo=new UserInfo();
		userInfo.setStatus(2);
		userInfo.setDelFlag(1);
		map.put("userInfo.realname", userInfo.getRealname());
		map.put("userInfo.email", userInfo.getEmail());
		map.put("userInfo.telephone", userInfo.getTelephone());
		initPage(map);
		Long total=this.userInfoService.findAllCount(userInfo);
		this.pager.setTotalRecords(total);
		List<UserInfo> list=this.userInfoService.findAll(this.pager.getFirstResult(), this.pager.getMaxResult(), userInfo);
		this.pager.setRecords(list);
		return "userInfoList";
	}
	
	/**
	 * 执行审核操作--废弃
	 */
	@Action(value="approveDo")
	public void  approveDo(){
		JSONObject obj=new JSONObject();
		try{
		UserInfo nuserInfo=this.userInfoService.getId(id);
		nuserInfo.setStatus(status);
		this.userInfoService.editUserInfo(nuserInfo);
		obj.put("code","success");
		obj.put("msg","审批成功");
		}catch(Exception e){
			obj.put("code","faile");
			obj.put("msg","审批失败");
		}
		responseStr(obj.toString());
	}
	
	
	@Action(value="view", results = { @Result(name = "view", location = "/userinfo/view.jsp") })
	public String  view(){
		userInfo=this.userInfoService.getId(id);
		return "view";
	}
	@Action(value="resetPassword")
	public void resetPassword(){
		JSONObject obj=new JSONObject();
		try{
		UserInfo nuserInfo=this.userInfoService.getId(id);
		nuserInfo.setPassword(MD5Util.getPassByMD5(ConstantOur.DEFAULT_PASSWORD));
		this.userInfoService.editUserInfo(nuserInfo);
		obj.put("code","success");
		obj.put("msg","密码重新设置为初始密码成功");
		}catch(Exception e){
			obj.put("code","faile");
			obj.put("msg","重设密码失败");
		}
		responseStr(obj.toString());
	}
	@Action(value="delUserInfo")
	public void delUserInfo(){
		JSONObject obj=new JSONObject();
		try{
				this.userInfoService.delUserInfo(id);
		obj.put("code","success");
		obj.put("msg","删除用户成功");
		}catch(Exception e){
			obj.put("code","faile");
			obj.put("msg","删除用户失败");
		}
		responseStr(obj.toString());
		
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

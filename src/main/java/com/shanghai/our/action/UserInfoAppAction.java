package com.shanghai.our.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.UserInfo;
import com.shanghai.our.service.IUserInfoService;
import com.shanghai.our.utils.DateUtil;
import com.shanghai.our.utils.MD5Util;

@ParentPackage("appPackage")
@Namespace("/userInfo")
public class UserInfoAppAction extends AppBaseAction<UserInfo>{

	
	private String loginName;
	private String password;
	
	private String  name;
	private String firstName;
	private String birth;
	
	@Autowired
	private IUserInfoService  userInfoService;
	
	/**
	 * 登陆app接口
	 */
	@Action(value="login")
	public void  login(){
		try{
			UserInfo userInfo=this.userInfoService.getByEmail(loginName);
			 password= MD5Util.getPassByMD5(password);
			 if(userInfo!=null&&password.equals(userInfo.getPassword())){
				 if(userInfo.getStatus()==2)
				 super.successResponse(userInfo.getId());
				 else
				 super.faileResponse("该用户尚未被审核通过");
			 }else{
				 super.faileResponse("用户名或者密码错误");
			 }
			
		}catch(Exception  e){
			 super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
		 
	}

	/**
	 * 注册用户app接口
	 */
	@Action(value="register")
	public void  register(){
		
		if(loginName==null||"".equals(loginName)||password==null||"".equals(password)
				||name==null||"".equals(name)||firstName==null||"".equals(firstName)
				||birth==null||"".equals(birth)||file==null)
		{
			 super.faileResponse("服务器验证不通过");
			 return;
		}
		try{
			UserInfo u=this.userInfoService.getByEmail(loginName);
			if(u!=null){
				super.faileResponse("该邮箱已被注册，请改用其他邮箱！");
				return;
			}
			UserInfo userInfo=new UserInfo();
			userInfo.setEmail(loginName);
			userInfo.setPassword(MD5Util.getPassByMD5(password));
			userInfo.setBirthday(birth);
			userInfo.setRealname(firstName+name);
			userInfo.setFileName(fileFileName);
			super.uploadtypedir=ConstantOur.IDCARD_IMG;
			super.uploadImg(loginName,"IDCARD_MSG");
			userInfo.setIdcardPath(super.filePath);
			userInfo.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			userInfo.setStatus(1);
			userInfo.setDelFlag(1);
			super.successResponse(this.userInfoService.saveUserInfo(userInfo));
		}catch(Exception e){
			 super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
}

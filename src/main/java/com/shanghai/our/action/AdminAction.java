package com.shanghai.our.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.Admin;
import com.shanghai.our.service.IAdminService;
import com.shanghai.our.utils.DateUtil;
import com.shanghai.our.utils.MD5Util;

@ParentPackage("basePackage")
@Namespace("/")
public class AdminAction extends BaseAction<Admin>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 业务接口注入
	 */
	@Autowired
	private IAdminService  adminService;
	private  Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	/**
	 * 获取所有用户列表
	 * @return
	 */
	@Action(value = "adminList", results = { @Result(name = "adminList", location = "/admin/adminList.jsp") })
	public  String   adminList(){
		Map<String,Object> map=new HashMap<String,Object>();
		if(admin!=null){
		map.put("admin.realname", admin.getRealname());
		map.put("admin.tel", admin.getTel());
		map.put("admin.username", admin.getUsername());
		}
		initPage(map);
		Long total=this.adminService.findAllCount(admin);
		this.pager.setTotalRecords(total);
		List<Admin> list=this.adminService.findAll(this.pager.getFirstResult(), this.pager.getMaxResult(), admin);
		this.pager.setRecords(list);
		return "adminList";
	}

	/**
	 * 跳转到增加用户列表
	 * @return
	 */
	@Action(value = "addAdmin", results = { @Result(name = "addAdmin", location = "/admin/addAdmin.jsp") })
	public String  addAdmin(){
		return "addAdmin";
	}
	
	/**
	 * 执行增加用户操作
	 */
	@Action(value="addAdminDo")
	public void  addAdminDo(){
		try{
			Admin  nadmin=this.adminService.getByUserName(admin.getUsername());
			if(nadmin!=null){
				responseStr(responseJson("error","用户名已经存在！！"));
				return;
			}
			admin.setCreateTime(DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
			admin.setDelFlag(1);
			admin.setPassword(MD5Util.getPassByMD5(ConstantOur.DEFAULT_PASSWORD));
			this.adminService.saveAdmin(admin);
			responseStr(responseJson("success","增加成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","增加失败！"));
		}
	}
	
	/**
	 * 跳转到编辑管理员用户操作
	 * @return
	 */
	@Action(value = "editAdmin", results = { @Result(name = "editAdmin", location = "/admin/editAdmin.jsp") })
	public  String  editAdmin(){
		this.admin=this.adminService.getId(id);
		return "editAdmin";
	}
	
	/**
	 * 执行编辑管理员信息操作
	 */
	@Action(value="editAdminDo")
	public void editAdminDo(){
		try{
			Admin nadmin=this.adminService.getId(admin.getId());
			nadmin.setEmail(admin.getEmail());
			nadmin.setMemo(admin.getMemo());
			nadmin.setRealname(admin.getRealname());
			nadmin.setTel(admin.getTel());
			if(nadmin.getCreateTime()==null||"".equals(nadmin.getCreateTime()))
				nadmin.setCreateTime(DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
			this.adminService.saveAdmin(nadmin);
			responseStr(responseJson("success","修改成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","修改失败！"));
		}
	}
	
	/**
	 * 删除管理员
	 */
	@Action(value="delAdmin")
	public void delAdmin(){
		try{
			this.adminService.delAdmin(id);
			responseStr(responseJson("success","删除成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","删除失败！"));
		}
	}
}

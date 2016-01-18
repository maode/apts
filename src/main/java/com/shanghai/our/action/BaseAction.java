package com.shanghai.our.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.common.SelectItem;
import com.shanghai.our.model.Admin;
import com.shanghai.our.model.Pager;
public class BaseAction<T> extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//传递参数
	protected String params;
	protected Integer id;
	protected String ids;
	protected Pager<T> pager=new Pager<T>();
	
	protected  Integer typeId;
	
	{//初始化分页页面显示条数[为照顾app接口默认值设为了MAX_VALUE,所以此处针对后台分页再次进行初始化]
		pager.setPageSize(3);
	}
	
	/**
	 * 成功返回共同方法[默认code为success]
	 * @param result
	 */
	public void  successResponse(String  result){
		responseJsonStr("success", result);
	}
	
	/**
	 * 请求服务器失败返回共同方法[默认code为error]
	 * @param result
	 */
	public void  faileResponse(String  result){
		responseJsonStr("error", result);
	}	
	
	/**
	 * 将处理后的mod压入栈顶
	 * @param mod
	 */
	public void pushModToRoot(T mod){
		ActionContext.getContext().getValueStack().getRoot().push(mod);
	}
	
	public HttpServletResponse  getResponse(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		return response;
	}
	public HttpServletRequest getRequest(){
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}
	public  Admin getSessionUserInfo(){
		Admin user=(Admin)getRequest().getSession().getAttribute(ConstantOur.SESSION_USERINFO);
		return user;
	}
	
	
	
	@Action(value="getpic")
	public void getPic(){
		InputStream  stram=null;
		OutputStream os =null;
		try {
			File file=new File(ConstantOur.FILE_PATH+params);
			if(file.exists()&&file.isFile())
			stram=new FileInputStream(ConstantOur.FILE_PATH+params);
			else
				stram=new FileInputStream(ServletActionContext.getServletContext().getRealPath("/")+"/assets/images/default.jpg");
			HttpServletResponse response=ServletActionContext.getResponse();
			response.reset();
			response.resetBuffer();
			response.setContentType("image/pjpeg");
			 os=response.getOutputStream();
			int i=0;
			while((i=stram.read())!=-1){
				os.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
				try {
					if(stram!=null)
					stram.close();
					if(os!=null)
						os.close();
						
				} catch (IOException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
		}
	}
	@Action(value="getDownFile")
	public void getDownFile(){
		try{
			File file = new File(ConstantOur.FILE_PATH+params);// path是根据日志路径和文件名拼接出来的
		    String filename = file.getName();// 获取日志文件名称
		    InputStream fis = new BufferedInputStream(new FileInputStream(file));
		    byte[] buffer = new byte[fis.available()];
		    fis.read(buffer);
		    fis.close();
		    getResponse().reset();
		    // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
		    getResponse().addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
		    getResponse().addHeader("Content-Length", "" + file.length());
		    OutputStream os = new BufferedOutputStream(getResponse().getOutputStream());
		    getResponse().setContentType("application/octet-stream");
		    os.write(buffer);// 输出文件
		    os.flush();
		    os.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	
	protected  void   responseStr(String str){
		try {
			getResponse().getWriter().write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected  void   responseJsonStr(String code,String msg){
		try {
			getResponse().getWriter().write(responseJson(code,msg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String  responseJson(String code,String msg){
		JSONObject obj=new JSONObject();
		obj.put("code",code);
		obj.put("msg",msg);
		return obj.toString();
	}
	
	
	protected  void initPage(Map<String,Object> map){
		List<SelectItem> list=new ArrayList<SelectItem>();
		for(String str:map.keySet())
		{
			SelectItem  sl=new SelectItem();
			sl.setKey(str);
			sl.setVal(map.get(str));
			list.add(sl);
		}
			ServletActionContext.getContext().put("paramslist",list);
		
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * @return the pager
	 */
	public Pager<T> getPager() {
		return pager;
	}
	/**
	 * @param pager the pager to set
	 */
	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}




	
	
}

package com.shanghai.our.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.Pager;
import com.shanghai.our.utils.TipImageUtils;

import net.sf.json.JSONObject;

public class AppBaseAction<T> {
	
	protected File  file;
	protected String  fileFileName;
	protected String  fileContentType;
	
	protected  File[] files;
	protected  String[] filesFileName;
	protected  String[]  filesContentType;
	protected String uploadtypedir;
	protected String filePath;
	
	
	protected Pager<T> pager=new Pager<T>();

	/**
	 * 成功返回共同方法
	 * @param resultObj
	 */
	public void  successResponse(Object  resultObj){
		JSONObject obj=new JSONObject();
		obj.put("code","OK");
		obj.put("result", resultObj);
		try {
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 请求服务器失败返回共同方法
	 * @param resultObj
	 */
	public void  faileResponse(Object  resultObj){
		JSONObject obj=new JSONObject();
		obj.put("code","AB");
		obj.put("result", resultObj);
		try {
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 上传图片共同方法
	 * @param userId
	 * @return
	 */
	public  boolean   uploadImg(String userId,String type){
		String path = ConstantOur.FILE_PATH+uploadtypedir;
    	String dirpath=type+"/"+userId+"/";
    	 if(!TipImageUtils.isImg(fileFileName)){
    		return false;
    	 }
         String fileName=TipImageUtils.reNameImg(fileFileName);
         File filedir=new File(path+dirpath);
        try {
           if(!filedir.exists())filedir.mkdirs();
           filePath=uploadtypedir+dirpath+fileName;
          FileUtils.copyFile(file, new File(filedir+File.separator+fileName));
        	 return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return false;
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}

	public String getUploadtypedir() {
		return uploadtypedir;
	}

	public void setUploadtypedir(String uploadtypedir) {
		this.uploadtypedir = uploadtypedir;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Pager<T> getPager() {
		return pager;
	}

	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}

	
	
	
}

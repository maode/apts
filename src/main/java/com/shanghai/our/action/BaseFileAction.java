package com.shanghai.our.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.service.IPictureService;
import com.shanghai.our.utils.TipImageUtils;
public class BaseFileAction<T> extends BaseAction<T>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected File file;
	protected String fileFileName;
	protected String uploadtypedir;
	protected  File[] files;
	protected  String[] filesFileName;
	protected  String[]  filesContentType;
	protected String filePath;
	
	protected String  imgpath;
	@Autowired
	protected IPictureService pictureService;
	
	public String getUploadtypedir() {
		return uploadtypedir;
	}
	public void setUploadtypedir(String uploadtypedir) {
		this.uploadtypedir = uploadtypedir;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	/**
	 * 上传文件
	 * @return
	 */
	public  boolean   uploadImg(Integer userId){
		String path = ConstantOur.FILE_PATH+uploadtypedir;
    	String dirpath="IDCARD_IMG"+userId;
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
	/**
	 * 上传压缩图片
	 * @return
	 */
	public  boolean   uploadImgPress(Integer userId,Integer width,Integer height){
		String path = ConstantOur.FILE_PATH+uploadtypedir;
    	String dirpath="IDCARD_IMG"+userId;
    	 if(!TipImageUtils.isImg(fileFileName)){
    		return false;
    	 }
         String fileName=TipImageUtils.reNameImg(fileFileName);
         File filedir=new File(path+dirpath);
        try {
           if(!filedir.exists())filedir.mkdirs();
          filePath=uploadtypedir+dirpath+fileName;
          TipImageUtils.compressPic(file, filedir+File.separator+fileName, width, height, false,0, 40, 190);
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	
	
}

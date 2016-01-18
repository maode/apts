package com.shanghai.our.utils;

import java.io.File;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.shanghai.our.common.ConstantOur;
public class MyImgUtils {
	
	public static String  copyFile(String filepath){
		File file=new File(ConstantOur.FILE_PATH+filepath);
		String distFilePath=filepath.replace("temp", "image");
		File distFile=new File(ConstantOur.FILE_PATH+distFilePath);
		try{
			if(file.exists()){
				if(!distFile.getParentFile().exists())
					distFile.getParentFile().mkdirs();
				FileUtil.copyFile(file, distFile);
				file.delete();
				return distFilePath;
			}
		}catch(Exception e){
			if(distFile.exists())
				distFile.delete();
		}
		return null;
	}
	
	 public static JSONObject uploadCressImg(int userid,File file,String fileFileName,String patdir,Integer width,Integer height){
		 JSONObject obj=new JSONObject();
	    	String path = ConstantOur.FILE_PATH+patdir;
	    	String dirpath=getImgPath(userid);
	    	 if(!TipImageUtils.isImg(fileFileName)){
	      	   obj.put("code","error");
	      	   obj.put("msg","请选择图片进行上传");
	      	   obj.put("filepath","");
	      	   return obj;
	    	 }
	         String fileName=TipImageUtils.reNameImg(fileFileName);
	         File filedir=new File(path+dirpath);
	        try {
	           if(!filedir.exists())filedir.mkdirs();
	           if(TipImageUtils.compressPic(file, path+dirpath+fileName, width, height, false,0, 40, 190)){
	        	  String filepath=patdir+dirpath+fileName;
	        	  obj.put("code","success");
		      	   obj.put("msg","成功");
		      	   obj.put("filepath",filepath);
		      	   return obj;
	           }
	        	 
	        } catch (Exception e) {
	        	 if(filedir.isDirectory()){
	           	  for(File f :filedir.listFiles())
	           		 f.getAbsoluteFile().delete();
	             }
	            e.printStackTrace();
	        }
	        obj.put("code","error");
	      	   obj.put("msg","上传图片失败");
	      	   obj.put("filepath","");
	      	   return obj;
	    }
	 
	 private static String getImgPath(int userid){
	        String  serverIp=ServletActionContext.getRequest().getServerName();
	        String dirpath=userid+"/"+serverIp+"/images/";
	    	return dirpath;
	    }
}

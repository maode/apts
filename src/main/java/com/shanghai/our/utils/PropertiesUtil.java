package com.shanghai.our.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	 static private String serverhost = null;
	 static private String serverport = null;
	 static private String username=null;
	 static private String password=null;
	 static private String xihaianip;
	 static private String xihaianport;
	 static{
	  loads();
	 }
	 synchronized static public void loads(){
	  if(serverhost == null || serverhost == null||username==null||password==null)
	  {
	   InputStream is = PropertiesUtil.class.getResourceAsStream("/javamail.properties");
	   Properties dbProps = new Properties();
	     try {
	        dbProps.load(is);
	        serverhost = dbProps.getProperty("serverhost");
	        serverport = dbProps.getProperty("serverport");
	        username = dbProps.getProperty("username");
	        password = dbProps.getProperty("password");
	        xihaianip=dbProps.getProperty("xihaianip");
	        xihaianport=dbProps.getProperty("xihaianport");
	      }
	      catch (Exception e) {
	        System.err.println("不能读取属性文件. " +
	       "请确保db.properties在CLASSPATH指定的路径中");
	      }
	  }
	 }
	 
	 public static String getServerhost(){
		 if(serverhost==null)
			 loads();
		 return serverhost;
	 }
	 public static String getServerport(){
		 if(serverport==null)
			 loads();
		 return serverhost;
	 }
	 
	 public static String getUsername(){
		 if(username==null)
			 loads();
		 return username;
	 }
	 
	 public static String getPassword(){
		 if(password==null)
			 loads();
		 return password;
	 }
	 
	 public static String getXihaianip(){
		 if(xihaianip==null)
			 loads();
		 return xihaianip;
	 }
	 public static String getXihaianPort(){
		 if(xihaianport==null)
			 loads();
		 return xihaianport;
	 }
	}



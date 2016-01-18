package com.shanghai.our.utils;

	import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
	  
	/******************************************************************************* 
	 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法 
	 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true)) 
	 */  
	 public class TipImageUtils {   
	       
	     /*  
	      * 获得图片大小  
	      * 传入参数 String path ：图片路径  
	      */   
	     public long getPicSize(String path) {   
	       File  file = new File(path);   
	         return file.length();   
	     }  
	       
	     /**
	      * 
	      * @param file//图片文件
	      * @param outputPath//输出路径
	      * @param width//压缩大小
	      * @param height//压缩高度
	      * @param gp//是否按比例压缩
	      * @param degree//旋转角度
	      * @param positonx//水印位置x坐标
	      * @param positiony//水印位置y坐标
	      * @return
	      */
	     public static boolean compressPic(File file, String outputPath, int width, int height, boolean gp,int degree,int positonx,int positiony ) {   
	         try {   
	             Image img = ImageIO.read(file);   
	             // 判断图片格式是否正确   
	             if (img.getWidth(null) == -1) {  
	                 System.out.println(" can't read,retry!" + "<BR>");   
	                 return false;   
	             } else {   
	                 int newWidth; int newHeight;   
	                 // 判断是否是等比缩放   
	                 if (gp) {   
	                     // 为等比缩放计算输出的图片宽度及高度   
	                     double rate1 = ((double) img.getWidth(null)) / (double) width + 0.1;   
	                     double rate2 = ((double) img.getHeight(null)) / (double) height + 0.1;   
	                     // 根据缩放比率大的进行缩放控制   
	                     double rate = rate1 > rate2 ? rate1 : rate2;   
	                     newWidth = (int) (((double) img.getWidth(null)) / rate);   
	                     newHeight = (int) (((double) img.getHeight(null)) / rate);   
	                 } else {   
	                     newWidth = width; // 输出的图片宽度   
	                     newHeight = height; // 输出的图片高度   
	                 }   
	                BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);   
	                  
	                /* 
	                 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
	                 * 优先级比速度高 生成的图片质量比较好 但速度慢 
	                 */   
	            	Graphics2D  g = tag.createGraphics();
	                g.drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);  
	                if (0 != degree) {   
	                    // 设置水印旋转   
	                    g.rotate(Math.toRadians(degree),   
	                            (double) tag.getWidth() / 2, (double) tag   
	                                    .getHeight() / 2);   
	                }   
	                float alpha = 0.5f; // 透明度   
	                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,   
	                        alpha));   
	                g.setColor(Color.RED);
	                int fontSize=20;
	            	g.setFont(new Font("微软雅黑", Font.BOLD, fontSize));
	            	//g.drawString(pressText, x, y);
	            	g.drawString("",  positonx,  positiony);
	            	g.dispose();
	                FileOutputStream out = new FileOutputStream(outputPath);  
	                // JPEGImageEncoder可适用于其他图片类型的转换   
	                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
	                encoder.encode(tag);   
	                out.close();   
	             }   
	         } catch (IOException ex) {   
	             ex.printStackTrace();   
	         }   
	         return true;   
	    }   
	     
	     public static boolean  isImg(String fileName){
	    	String []  typess={"BMP","JPG","JPEG","PNG","GIF","SVG"};
	    	try{
	    	 String [] str=fileName.split("\\.");
	    	 String s=str[str.length-1];
	    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
	    		 return true;
	    	 }
	    	 else 
	    		 return false;
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		return false;
	    	}
	     };
	     
	     public static boolean  isFlv(String fileName){
		    	String []  typess={"SWF","FLV"};
		    	try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
		    		 return true;
		    	 }
		    	 else 
		    		 return false;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
		     };
	     public static boolean  isDoc(String fileName){
	    	 String []  typess={"DOC","PDF","XLS","XLSX","DOCX","PNG","JPG","BMP","JPEG","GIF"};
		    	try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
		    		 return true;
		    	 }
		    	 else 
		    		 return false;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
	     }
	     
	     public static boolean  isEXCEL(String fileName){
	    	 String []  typess={"XLS"};
		    	try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
		    		 return true;
		    	 }
		    	 else 
		    		 return false;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
	     }
	     public static  String  reNameImg(String fileName){
	    	 try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 String  names=DateUtil.DateToString(new Date(),"yyyyMMddHHmmssSSS")+"."+s;
		    	 return names;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
	    	 return null;
	     }
	     public static boolean  isAPK(String fileName){
	    	 String []  typess={"APK"};
		    	try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
		    		 return true;
		    	 }
		    	 else 
		    		 return false;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
	     }
	     
	     public static boolean  isCSS(String fileName){
	    	 String []  typess={"CSS"};
		    	try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
		    		 return true;
		    	 }
		    	 else 
		    		 return false;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
	     }
	     public static boolean  isJS(String fileName){
	    	 String []  typess={"JS"};
		    	try{
		    	 String [] str=fileName.split("\\.");
		    	 String s=str[str.length-1];
		    	 if(Arrays.asList(typess).contains(s.toUpperCase())){
		    		 return true;
		    	 }
		    	 else 
		    		 return false;
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
	     }
	 }  

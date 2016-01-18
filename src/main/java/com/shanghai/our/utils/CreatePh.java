package com.shanghai.our.utils;

import java.io.File;
import java.util.List;

import com.shanghai.our.common.ConstantOur;
public class CreatePh {  
     public static boolean processImg(String veido_path) {  
    File file = new File(veido_path);  
    if (!file.exists()) {  
    System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");  
    return false;  
    }  
    String ffmpeg_path=ConstantOur.FFEXPATH+"ffmpeg.exe";
    List<String> commands = new java.util.ArrayList<String>();  
    commands.add(ffmpeg_path);  
    commands.add("-i");  
    commands.add(veido_path);  
    commands.add("-y");  
    commands.add("-f");  
    commands.add("image2");  
    commands.add("-ss");  
    commands.add("15");//这个参数是设置截取视频多少秒时的画面  
    //commands.add("-t");  
    //commands.add("0.001");  
    commands.add("-s");  
    commands.add("930x570");  
    commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");  
    try {  
    ProcessBuilder builder = new ProcessBuilder();  
    builder.command(commands);  
    builder.start();  
    System.out.println("截取成功");  
    return true;  
    } catch (Exception e) {  
    e.printStackTrace();  
    return false;  
    }  
    }  

}  
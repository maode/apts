package com.shanghai.our.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImgMarkUtil {

	/**
	* 把图片印刷到图片上
	* @param pressImg -- 水印文件
	* @param targetImg -- 目标文件
	* @param x
	* @param y
	*/
	public final static void pressImage(String pressImg, String targetImg, int x, int y) {
	try {
	File _file = new File(targetImg);
	Image src = ImageIO.read(_file);
	int wideth = src.getWidth(null);
	int height = src.getHeight(null);
	BufferedImage image = new BufferedImage(wideth, height,
	BufferedImage.TYPE_INT_RGB);
	Graphics g = image.createGraphics();
	g.drawImage(src, 0, 0, wideth, height, null);
	// 水印文件
	File _filebiao = new File(pressImg);
	Image src_biao = ImageIO.read(_filebiao);
	int wideth_biao = src_biao.getWidth(null);
	int height_biao = src_biao.getHeight(null);
	g.drawImage(src_biao, wideth - wideth_biao - x, height - height_biao -y, wideth_biao,
	height_biao, null);
	// /
	g.dispose();
	FileOutputStream out = new FileOutputStream(targetImg);
	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	encoder.encode(image);
	out.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	/**
	* 打印文字水印图片
	* @param pressText --文字
	* @param targetImg -- 目标图片
	* @param fontName -- 字体名
	* @param fontStyle -- 字体样式
	* @param color -- 字体颜色
	* @param fontSize -- 字体大小
	* @param x -- 偏移量
	* @param y
	*/
	public static void pressText(String pressText, String targetImg, String fontName,int fontStyle, int fontSize, int x, int y,Integer degree) {
	try {
	File _file = new File(targetImg);
	Image src = ImageIO.read(_file);
	int wideth = src.getWidth(null);
	int height = src.getHeight(null);
	BufferedImage image = new BufferedImage(wideth, height,
	BufferedImage.TYPE_INT_RGB);
	Graphics2D  g = image.createGraphics();
	// 设置对线段的锯齿状边缘处理   
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,   
            RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
    g.drawImage(src.getScaledInstance(src.getWidth(null), src   
            .getHeight(null), Image.SCALE_SMOOTH), 0, 0, null); 
    if (null != degree) {   
        // 设置水印旋转   
        g.rotate(Math.toRadians(degree),   
                (double) image.getWidth() / 2, (double) image   
                        .getHeight() / 2);   
    }   
    float alpha = 0.5f; // 透明度   
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,   
            alpha));   
	//g.drawImage(src, 0, 0, wideth, height, null);
	// String s="www.qhd.com.cn";
	g.setColor(Color.RED);
	g.setFont(new Font(fontName, fontStyle, fontSize));
	//g.drawString(pressText, x, y);
	g.drawString(pressText, wideth - fontSize - x, height - fontSize/2 - y);
	g.dispose();
	FileOutputStream out = new FileOutputStream(targetImg);
	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	encoder.encode(image);
	out.close();
	} catch (Exception e) {
	System.out.println(e);
	}
	}
	
}

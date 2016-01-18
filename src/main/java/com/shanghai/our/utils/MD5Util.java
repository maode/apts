package com.shanghai.our.utils;
import java.security.MessageDigest;

/**   
 * @create date 2012-08-24
 * @author 耿文强
 * @class description 对密码进行加密和验证  
 */
public class MD5Util {

	
	public static void main(String args[]){
		System.out.println(MD5Util.getPassByMD5("test").length());
	}
	
	
	/**
	 * 16进制下的映射数组
	 */
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 将密码进行加密
	 * @param password
	 * @return 加密后的字符串
	 */
	public static String getPassByMD5(String password) {
		return stringByMD5(password);
	}

	/**  
	 * 验证登录密码是否正确  
	 * @param password    加密后的密码  
	 * @param loginPassword    登录的密碼 
	 * @return    验证结果，TRUE:正确 FALSE:错误  
	 */
	public static boolean validatePassword(String password, String loginPassword) {
		if (password.equals(stringByMD5(loginPassword))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 对字符串进行加密处理
	 * @param strString
	 * @return 加密后的字符串
	 */
	private static String stringByMD5(String strString) {
		if (strString != null) {
			try {
				//创建MD5算法的信息 
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(strString.getBytes());
				
				//将得到的字节数组变成字符串返回
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**   
	 * 转换字节数组为十六进制字符串  
	 * @param     字节数组  
	 * @return    十六进制字符串
	 */
	private static String byteArrayToHexString(byte[] results) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < results.length; i++) {
			resultSb.append(byteToHexString(results[i]));
		}
		return resultSb.toString();
	}
    
	/**
	 * 将一个字节转化成十六进制形式的字符串
	 * @param b
	 * @return 十六进制形式的字串
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	
}

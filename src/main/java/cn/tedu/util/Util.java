package cn.tedu.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {
	
	public static String getMd5(String password){
		String salt="Œ“ «º”√‹—Œ";
		String pwd=DigestUtils.md5Hex(password+salt);
		return pwd;
	}
}

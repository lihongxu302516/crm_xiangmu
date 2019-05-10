package com.crm.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;
@Component
public class DigestUtil {
	public String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		for (int i = 0; i < md5Bytes.length; i++) {
			md5Bytes[i] = (byte) ((((int) md5Bytes[i] - 88) * 9 + 66) / 4);
		}
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("5");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	private String convertMD5(String inStr, char c) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ c);
		}
		String s = new String(a);
		return s;
	}

	private String miyan(String m, int i) {
		String m1 = null;
		String m2 = null;
		String m3 = null;
		String m4 = null;
		String m5 = null;
		if (i < 10) {
			m1 = convertMD5(m, '=');
			m2 = convertMD5(m1, 'g');
			m3 = convertMD5(m2, 'M');
			m4 = convertMD5(m3, '9');
			m5 = convertMD5(m4, 'ìá');
		}else if(i<15) {
			m1 = convertMD5(m, '-');
			m2 = convertMD5(m1, 'v');
			m3 = convertMD5(m2, 'a');
			m4 = convertMD5(m3, 'M');
			m5 = convertMD5(m4, 'ŠU');
		}else if(i<100) {
			m1 = convertMD5(m, 'a');
			m2 = convertMD5(m1, 'a');
			m3 = convertMD5(m2, 'L');
			m4 = convertMD5(m3, 'T');
			m5 = convertMD5(m4, '5');
		}else if(i<998) {
			m1 = convertMD5(m, 'šG');
			m2 = convertMD5(m1, '3');
			m3 = convertMD5(m2, 's');
			m4 = convertMD5(m3, '°É');
			m5 = convertMD5(m4, 'S');
		}else {
			m1 = convertMD5(m, '@');
			m2 = convertMD5(m1, '*');
			m3 = convertMD5(m2, 'M');
			m4 = convertMD5(m3, 'x');
			m5 = convertMD5(m4, '7');
		}
		return m5;
	}

	public String jami(String m) {
		return miyan(m, m.length());
	}

	public String jiemi(String m) {
		return miyan(m, m.length());
	}
}

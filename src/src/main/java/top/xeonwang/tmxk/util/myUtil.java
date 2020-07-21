package top.xeonwang.tmxk.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class myUtil {
	/**
	 * 读入json text数据
	 * @param request
	 * @return
	 */
	public static String readData(HttpServletRequest request) {
		byte[] temp=new byte[1000];
		try {
			request.getInputStream().read(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(temp);
	}
}

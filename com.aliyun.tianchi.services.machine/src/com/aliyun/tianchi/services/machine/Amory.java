package com.aliyun.tianchi.services.machine;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class Amory {
	static HttpClient client = new DefaultHttpClient();
	private static String caculateKey() {
		SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
		String content = "tianchi_user" + SIMPLE_DATE_FORMAT.format(new Date())
				+ "cDQlkgTOvp5GxEJ23iMU0A==";
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		char str[] = new char[16 * 2];
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(content.getBytes());
			byte tmp[] = md.digest();
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new String(str);

	}
	public static String retriveMachineDeviceInfo(String id){
		String responseData = null;
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("a.alibaba-inc.com").setPath("/page/api/free/opsfreeInterface/search.htm")
	    .setParameter("q", "sn=="+id)
	    .setParameter("select", "*")
	    .setParameter("from", "device")
	    .setParameter("_username", "tianchi_user");
		URI uri = null;
		try {
			uri = builder.build();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpGet httpget = new HttpGet(uri);
//		HttpGet getMethod = new HttpGet("http://a.alibaba-inc.com/page/api/free/opsfreeInterface/search.htm");
		
		try {
			HttpResponse response = client.execute(httpget);
			responseData = EntityUtils.toString(response.getEntity());
			System.out.println(responseData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseData;
	}
	
	public static String retriveMachineOsInfo(String id){
		String responseData = null;
//		HttpMethod getMethod = new GetMethod("http://a.alibaba-inc.com/page/api/srmpInterface/getInstallInfoByServiceTag.htm");
//		List<NameValuePair> parameters = new ArrayList();
//		parameters.add(new NameValuePair("serviceTag", id));
//		parameters.add(new NameValuePair("key", caculateKey()));
//		parameters.add(new NameValuePair("_username", "tianchi_user"));
//		getMethod.setQueryString(parameters.toArray(new NameValuePair[]{}));
//		try {
//			client.executeMethod(getMethod);
//			responseData = getMethod.getResponseBodyAsString();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return responseData;
	}
	
	public static void main(String arg[]){
		System.out.println(Amory.retriveMachineOsInfo("21"));
	}
	
	
}

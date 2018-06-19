package com.yfei.transxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import com.yfei.transxml.bean.JsTicket;
import com.yfei.transxml.bean.Log;
import com.yfei.transxml.bean.LogEntity;
import com.yfei.transxml.bean.Params;
import com.yfei.transxml.bean.Session;
import com.yfei.transxml.bean.SysInfo;
import com.yfei.transxml.bean.User;

public class Trans {

	private final static String BASE_URL = "http://121.43.187.241/logs/";

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("程序运行需要目录参数，请以参数方式提供日志目录");
			return;
		}
		List<File> fileList = new ArrayList<File>();
		for (String arg : args) {
			System.out.println("Trans.main()->arg:" + arg);
			fileList.addAll(getFolderFiles(arg));
		}

		Result result = new Result();
		if(fileList.size()==0) {
			System.err.println("找不到7天内的数据文件");
		}
		for (File file : fileList) {
			System.out.println("Trans.main()->file:" + file.getName());
			LogEntity fileEntity = transFile(file);
			// 对日志进行过滤
			for (Log log : fileEntity.getLogList()) {
				result.filterUserInfo(log);
				result.filterUrl(log);
				result.filterDevice(log);
			}
		}
		String json = result.jsonStr();
		System.out.println("Trans.main()->json:" + json);

	}

	private static List<File> getFolderFiles(String path) {
		List<File> retList = new ArrayList<File>();
		File dir = new File(path);
		File[] files = dir.listFiles();
		for (File file : files) {
			String fname = file.getName();
			System.out.println("Trans.getFolderFiles()->fname:" + fname);
			// 匹配文件名并且从文件名判断是七天内的数据
			if (fname.matches("^reqlog_[0-9_]+.xml$") && DateUtils.xmlFilein7days(fname)) {
				retList.add(file);
			}
		}
		return retList;
	}

	/**
	 * 从网络中获得文件名列表，filelist中保存xml文件信息，从此文件读取
	 */
	public static void getFileName() {
		try {
			// 创建一个url实例
			URL url = new URL(BASE_URL + "filelist");
			// 通过url的openStream获取url对象所表示资源的字节输入流
			InputStream is = url.openStream();
			// 将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// 为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			String res = "";
			String line = "";
			// 读取数据
			while ((line = br.readLine()) != null) {
				res += line;
				res += "\n";
			}
			br.close();
			isr.close();
			is.close();
			System.out.println(res);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main2(String[] args) {
		long startTime = System.currentTimeMillis();
		// String file = "d:/temp/reqlog.xml";
		String file = "R:/reqLogs/reqlog_2018_06_03_20_52_33_682.xml";
		File xmlFile = new File(file);
		LogEntity fileEntity = transFile(xmlFile);
		Result result = new Result();
		// 对日志进行过滤
		for (Log log : fileEntity.getLogList()) {
			result.filterUserInfo(log);
			result.filterUrl(log);
			result.filterDevice(log);
		}
		String json = result.jsonStr();
		System.out.println("Trans.main()->json:" + json);

		long endTime = System.currentTimeMillis();
		System.out.println("所用时间：" + (endTime - startTime));

	}

	/**
	 * 对文件进行转换
	 * 
	 * @param xmlFile
	 *            传入的文件对象
	 * @return 返回转换后的对象
	 */
	private static LogEntity transFile(File xmlFile) {
		LogEntity logEntity = null;
		Digester digester = new Digester();
		// 指定它不要用DTD验证XML文档的合法性——这是因为我们没有为XML文档定义DTD
		digester.setValidating(false);
		// 从library标签开始解析,并新建一个Library对象做为根对象
		digester.addObjectCreate("xml", LogEntity.class);
		// 根据library标签属性值设置对象的属性,一次可以设置多个属性
		digester.addSetProperties("xml");
		// 也可以用下面的方法，指定propertyName
		// digester.addSetProperties("library", "name", "name");

		// -----第1层元素开始
		digester.addObjectCreate("xml/log", Log.class);
		digester.addSetProperties("xml/log");
		digester.addBeanPropertySetter("xml/log/reqUrl");
		digester.addBeanPropertySetter("xml/log/method");
		// digester.addBeanPropertySetter("xml/log/params");
		digester.addBeanPropertySetter("xml/log/ipandport", "ipAndPort");
		digester.addBeanPropertySetter("xml/log/reqTime/timestramp", "timestamp");
		digester.addBeanPropertySetter("xml/log/reqTime/timeAndDate");
		// digester.addBeanPropertySetter("xml/log/session");
		// digester.addSetProperties("xml/log/sysInfo");
		digester.addObjectCreate("xml/log/session", Session.class);
		digester.addObjectCreate("xml/log/session/jsTicket", JsTicket.class);
		digester.addBeanPropertySetter("xml/log/session/jsTicket/url");
		digester.addBeanPropertySetter("xml/log/session/jsTicket/timestamp");
		digester.addBeanPropertySetter("xml/log/session/jsTicket/upto");
		digester.addBeanPropertySetter("xml/log/session/jsTicket/nonce");
		digester.addBeanPropertySetter("xml/log/session/jsTicket/signature");
		digester.addBeanPropertySetter("xml/log/session/jsTicket/ticket");
		digester.addSetNext("xml/log/session/jsTicket", "setJsTicket");

		digester.addObjectCreate("xml/log/session/user", User.class);
		digester.addBeanPropertySetter("xml/log/session/user/id");
		digester.addBeanPropertySetter("xml/log/session/user/realName");
		digester.addBeanPropertySetter("xml/log/session/user/authorityInfo");
		digester.addBeanPropertySetter("xml/log/session/user/email");
		digester.addBeanPropertySetter("xml/log/session/user/frozen");
		digester.addBeanPropertySetter("xml/log/session/user/phonenumber");
		digester.addBeanPropertySetter("xml/log/session/user/password");
		digester.addBeanPropertySetter("xml/log/session/user/qq");
		digester.addBeanPropertySetter("xml/log/session/user/name");
		digester.addBeanPropertySetter("xml/log/session/user/openid");
		digester.addBeanPropertySetter("xml/log/session/user/headImg");
		digester.addBeanPropertySetter("xml/log/session/user/role_id", "roleId");
		digester.addBeanPropertySetter("xml/log/session/user/roleName");
		digester.addBeanPropertySetter("xml/log/session/user/organization_id", "organizationId");
		digester.addBeanPropertySetter("xml/log/session/user/region_id", "regionId");
		digester.addSetNext("xml/log/session/user", "setUser");
		digester.addSetNext("xml/log/session", "setSession");

		digester.addObjectCreate("xml/log/params", Params.class);
		digester.addBeanPropertySetter("xml/log/params/facId");
		digester.addBeanPropertySetter("xml/log/params/facDesc");
		digester.addBeanPropertySetter("xml/log/params/latitude");
		digester.addBeanPropertySetter("xml/log/params/longitude");
		digester.addBeanPropertySetter("xml/log/params/devCode");
		digester.addBeanPropertySetter("xml/log/params/eventDevstu");
		digester.addBeanPropertySetter("xml/log/params/eventDoorstu");
		digester.addBeanPropertySetter("xml/log/params/keepThis");
		digester.addBeanPropertySetter("xml/log/params/operate");
		digester.addBeanPropertySetter("xml/log/params/accuracy");
		digester.addBeanPropertySetter("xml/log/params/eventId");
		digester.addBeanPropertySetter("xml/log/params/modId");
		digester.addBeanPropertySetter("xml/log/params/resultStr");
		digester.addSetNext("xml/log/params", "setParams");

		digester.addObjectCreate("xml/log/sysInfo", SysInfo.class);
		digester.addBeanPropertySetter("xml/log/sysInfo/mess");
		digester.addBeanPropertySetter("xml/log/sysInfo/d_time", "dtime");
		digester.addBeanPropertySetter("xml/log/sysInfo/cache-control", "cacheControl");
		digester.addBeanPropertySetter("xml/log/sysInfo/pragma");
		digester.addBeanPropertySetter("xml/log/sysInfo/user-agent", "userAgent");
		digester.addBeanPropertySetter("xml/log/sysInfo/host");
		digester.addBeanPropertySetter("xml/log/sysInfo/origin");
		digester.addBeanPropertySetter("xml/log/sysInfo/accept");
		digester.addBeanPropertySetter("xml/log/sysInfo/accept-encoding", "acceptEncoding");
		digester.addBeanPropertySetter("xml/log/sysInfo/accept-language", "acceptLanguage");
		digester.addBeanPropertySetter("xml/log/sysInfo/referer");
		digester.addBeanPropertySetter("xml/log/sysInfo/cookie");
		digester.addBeanPropertySetter("xml/log/sysInfo/connection");
		digester.addBeanPropertySetter("xml/log/sysInfo/content-length", "contentLength");
		digester.addBeanPropertySetter("xml/log/sysInfo/content-type", "contentType");
		digester.addSetNext("xml/log/sysInfo", "setSysInfo");

		digester.addSetNext("xml/log", "addLog");

		try {
			logEntity = (LogEntity) digester.parse(xmlFile);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return logEntity;

	}

}

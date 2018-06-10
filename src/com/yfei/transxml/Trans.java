package com.yfei.transxml;

import java.io.File;
import java.io.IOException;

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

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		String file = "d:/temp/reqlog.xml";
		String file = "K:/transXML/reqLogs/reqlog_2018_06_03_20_52_33_682.xml";
		File xmlFile = new File(file);
		LogEntity fileEntity = transFile(xmlFile);
		Result result = new Result();
		//对日志进行过滤
		for(Log log : fileEntity.getLogList()){
			result.filterUserInfo(log);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("所用时间：" + (endTime-startTime));

	}

	/**
	 * 对文件进行转换
	 * @param xmlFile 传入的文件对象
	 * @return 返回转换后的对象
	 */
	private static LogEntity transFile(File xmlFile) {
		LogEntity logEntity = null;
		Digester digester = new Digester();  
        //指定它不要用DTD验证XML文档的合法性——这是因为我们没有为XML文档定义DTD  
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
        //digester.addBeanPropertySetter("xml/log/params");
        digester.addBeanPropertySetter("xml/log/ipandport","ipAndPort");
        digester.addBeanPropertySetter("xml/log/reqTime/timestramp","timestamp");
        digester.addBeanPropertySetter("xml/log/reqTime/timeAndDate");
        //digester.addBeanPropertySetter("xml/log/session");
        //digester.addSetProperties("xml/log/sysInfo");
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
        digester.addBeanPropertySetter("xml/log/session/user/role_id","roleId");
        digester.addBeanPropertySetter("xml/log/session/user/roleName");
        digester.addBeanPropertySetter("xml/log/session/user/organization_id","organizationId");
        digester.addBeanPropertySetter("xml/log/session/user/region_id","regionId");
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
        digester.addBeanPropertySetter("xml/log/sysInfo/d_time","dtime");
        digester.addBeanPropertySetter("xml/log/sysInfo/cache-control","cacheControl");
        digester.addBeanPropertySetter("xml/log/sysInfo/pragma");
        digester.addBeanPropertySetter("xml/log/sysInfo/user-agent","userAgent");
        digester.addBeanPropertySetter("xml/log/sysInfo/host");
        digester.addBeanPropertySetter("xml/log/sysInfo/origin");
        digester.addBeanPropertySetter("xml/log/sysInfo/accept");
        digester.addBeanPropertySetter("xml/log/sysInfo/accept-encoding","acceptEncoding");
        digester.addBeanPropertySetter("xml/log/sysInfo/accept-language","acceptLanguage");
        digester.addBeanPropertySetter("xml/log/sysInfo/referer");
        digester.addBeanPropertySetter("xml/log/sysInfo/cookie");
        digester.addBeanPropertySetter("xml/log/sysInfo/connection");
        digester.addBeanPropertySetter("xml/log/sysInfo/content-length","contentLength");
        digester.addBeanPropertySetter("xml/log/sysInfo/content-type","contentType");
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

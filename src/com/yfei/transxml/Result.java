package com.yfei.transxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yfei.transxml.bean.Log;
import com.yfei.transxml.bean.Session;
import com.yfei.transxml.bean.SysInfo;
import com.yfei.transxml.bean.User;
import com.yfei.transxml.jsonbean.Device;
import com.yfei.transxml.jsonbean.UseUrl;
import com.yfei.transxml.jsonbean.UserInfo;

/**
 * 处理结果的一个类
 * @author zhouf
 */
public class Result {

	Gson gson;
	private Map<String,UserInfo> userMap;
	private Map<String,UseUrl> urlMap;
	private Map<String,Device> devMap;
	public Result() {
		super();
		userMap = new HashMap<String,UserInfo>();
		urlMap = new HashMap<String,UseUrl>();
		devMap = new HashMap<String,Device>();
		//gson = new Gson();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	/**
	 * 从日志中提取用户信息
	 * @param log
	 */
	public void filterUserInfo(Log log){
		Session session = log.getSession();
		if(session==null) return;
		User user = session.getUser();
		if(user==null) return;
		
		String userid = user.getId();//Map<key>
		String name = user.getName();
		String duty = user.getRoleName();
		String tel = user.getPhonenumber();
		
		SysInfo sysInfo = log.getSysInfo();
		String agent = (sysInfo!=null? sysInfo.getUserAgent() : "");
		String type = parseType(agent);
		String os = parseOs(agent);
		String logtime = log.getTimestamp();//<timestramp>1527469064229</timestramp>
		
		if(userMap.containsKey(userid)){
			//提取已存在的对象
			UserInfo userInfo = userMap.get(userid);
			userInfo.addAccessTool(type, os, logtime);
		}else{
			//生成新对象并放入
			UserInfo userInfo = new UserInfo(name,duty,tel);
			userInfo.addAccessTool(type, os, logtime);
			userMap.put(userid, userInfo);
		}
	}

	/**
	 * 返回userInfo对象的json字串
	 * @return
	 */
	public String jsonUserInfos(){
		if(userMap!=null && userMap.size()>0){
			List<UserInfo> userList = new ArrayList<UserInfo>();
			for(String userid : userMap.keySet()){
				userList.add(userMap.get(userid));
			}
			UserClass userInfos = new UserClass();
			userInfos.setUserInfos(userList);
			return gson.toJson(userInfos);
		}
		return "";
	}

	
	/**
	 * 从日志中过滤出url信息
	 * @param log
	 */
	public void filterUrl(Log log){
		String url = log.getReqUrl();
		String logtime = log.getTimestamp();
		String ipandport = log.getIpAndPort();
		String ip = ipandport;
		if(ipandport!=null && ipandport.contains(":")){
			ip = ipandport.split(":")[0];
		}
		
		if(DateUtils.in7days(logtime)){
			//如果是七天内的数据
			if(urlMap.containsKey(url)){
				//已存在url
				UseUrl useUrl = urlMap.get(url);
				useUrl.setUseRate(useUrl.getUseRate() + 1);
				useUrl.addIp(ip);
			}else{
				UseUrl useUrl = new UseUrl(url);
				useUrl.setUseRate(1);
				useUrl.addIp(ip);
				
				urlMap.put(url, useUrl);
			}
		}
		
	}
	
	/**
	 * 返回useUrl对象的json信息
	 * @return
	 */
	public String jsonUseUrls(){
		if(urlMap!=null && urlMap.size()>0){
			List<UseUrl> urlList = new ArrayList<UseUrl>();
			for(String userid : urlMap.keySet()){
				urlList.add(urlMap.get(userid));
			}
			UserClass urlInfos = new UserClass();
			urlInfos.setUseUrl(urlList);
			return gson.toJson(urlInfos);
		}
		return "";
	}
	
	/**
	 * 返回所有的json
	 * @return
	 */
	public String jsonStr(){
		UserClass userInfos = new UserClass();
		if(userMap!=null && userMap.size()>0){
			List<UserInfo> userList = new ArrayList<UserInfo>();
			for(String userid : userMap.keySet()){
				userList.add(userMap.get(userid));
			}
			userInfos.setUserInfos(userList);
		}
		if(urlMap!=null && urlMap.size()>0){
			List<UseUrl> urlList = new ArrayList<UseUrl>();
			for(String userid : urlMap.keySet()){
				urlList.add(urlMap.get(userid));
			}
			userInfos.setUseUrl(urlList);
		}
		return gson.toJson(userInfos);
	}
	

	/**
	 * 从Agent中提取type类型
	 * @param userAgent
	 * @return 访问工具类型，pc/iphone/mac/android
	 */
	private String parseType(String userAgent) {
		// FIXME 粗略分类，待完善
		if(userAgent==null) return "";
		if(userAgent.contains("Windows NT")){
			return "PC";
		}else if(userAgent.contains("Android")){
			return "Android";
		}else if(userAgent.contains("iPhone")){
			return "iPhone";
		}
		return "other";
	}

	/**
	 * 从Agent中提取OS类型
	 * @param userAgent
	 * @return 操作系统标记
	 */
	private String parseOs(String userAgent) {
		// FIXME 待完善
		if(userAgent==null) return "";
		if(userAgent.contains("Windows NT")){
			return "Windows";
		}else if(userAgent.contains("Mac OS")){
			return "MacOS";
		}else if(userAgent.contains("Linux")){
			return "Linux";
		}
		return userAgent;
	}
	
	class UserClass{
		private List<UserInfo> userInfos;
		private List<UseUrl> useUrl;

		public List<UserInfo> getUserInfos() {
			return userInfos;
		}

		public void setUserInfos(List<UserInfo> userInfos) {
			this.userInfos = userInfos;
		}

		public List<UseUrl> getUseUrl() {
			return useUrl;
		}

		public void setUseUrl(List<UseUrl> useUrl) {
			this.useUrl = useUrl;
		}
	}
}

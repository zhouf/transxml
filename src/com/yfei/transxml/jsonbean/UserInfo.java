package com.yfei.transxml.jsonbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 用户信息实体
 * @author zhouf
 */
public class UserInfo {
	private String id;
	private String name;
	private String tel;
	private List<AccessTool> accessTool;
	
	
	public UserInfo(String id, String name, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		accessTool = new ArrayList<AccessTool>();
	}
	
	/**
	 * 向accessTool中加入记录数据
	 * @param type 工具类型
	 * @param os 操作系统
	 * @param logtime 记录时间字串
	 */
	public synchronized void addAccessTool(String type,String os,String logtime){
		//为空不记录
		if(type!=null && os!=null && logtime!=null && type.length()>0 && os.length()>0 && logtime.length()>0){
			if(in7days(logtime)) {
				System.out.println("UserInfo.addAccessTool()->type:" + type+os+logtime);
			
				boolean found = false;
				
				//遍历list，累加计数
				for(AccessTool tool : accessTool) {
					System.out.println("UserInfo.addAccessTool tool=" + tool);
					if(type.equals(tool.getType()) && os.equals(tool.getOs())) {
						//如果找到符合条件，则添加计数
						System.out.println("UserInfo.addAccessTool 找到" + type + os);
						tool.setUseRate(tool.getUseRate()+1);
						System.out.println("UserInfo.addAccessTool tool.getUseRate()=" + tool.getUseRate());
						found = true;
						break;
					}
				}
				if(!found) {
					//新增列表记录
					System.out.println("UserInfo.addAccessTool 新增记录" + type + os);
					accessTool.add(new AccessTool(type, os, 1));
				}
			}
		}
	}
	
	/**
	 * 检查是否是七天内的数据
	 * @param logtime 传入的日期long类型字串
	 * @return 如果是当前日期七天内的数据返回true
	 */
	private boolean in7days(String logtime) {
		if(logtime!=null && logtime.length()>0) {
			long day = Long.parseLong(logtime);
			
			Calendar markdayCal = Calendar.getInstance();
			markdayCal.add(Calendar.DATE, -7);
			Calendar logday = Calendar.getInstance();
			logday.setTimeInMillis(day);
			
			return (markdayCal.before(logday));
		}else {
			return false;
		}
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<AccessTool> getAccessTool() {
		return accessTool;
	}
	public void setAccessTool(List<AccessTool> accessTool) {
		this.accessTool = accessTool;
	}
}

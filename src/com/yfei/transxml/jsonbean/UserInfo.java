package com.yfei.transxml.jsonbean;

import java.util.ArrayList;
import java.util.List;

import com.yfei.transxml.DateUtils;

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
			if(DateUtils.in7days(logtime)) {
			
				boolean found = false;
				
				//遍历list，累加计数
				for(AccessTool tool : accessTool) {
					if(type.equals(tool.getType()) && os.equals(tool.getOs())) {
						//如果找到符合条件，则添加计数
						tool.setUseRate(tool.getUseRate()+1);
						found = true;
						break;
					}
				}
				if(!found) {
					//新增列表记录
					accessTool.add(new AccessTool(type, os, 1));
				}
			}
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

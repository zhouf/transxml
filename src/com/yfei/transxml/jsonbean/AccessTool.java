package com.yfei.transxml.jsonbean;

public class AccessTool {
	private String type;
	private String os;
	private String logtimestr;//保留计算使用频率
	
	public AccessTool(String type, String os, String logtimestr) {
		super();
		this.type = type;
		this.os = os;
		this.logtimestr = logtimestr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getLogtimestr() {
		return logtimestr;
	}
	public void setLogtimestr(String logtimestr) {
		this.logtimestr = logtimestr;
	}

}

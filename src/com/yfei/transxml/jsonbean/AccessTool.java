package com.yfei.transxml.jsonbean;

public class AccessTool {
	private String type;
	private String os;
	private int useRate;//保留计算使用频率
	
	public AccessTool(String type, String os, int useRate) {
		super();
		this.type = type;
		this.os = os;
		this.useRate = useRate;
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
	public int getUseRate() {
		return useRate;
	}
	public void setUseRate(int useRate) {
		this.useRate = useRate;
	}
	
	@Override
	public String toString() {
		return "AccessTool [type=" + type + ", os=" + os + ", useRate=" + useRate + "]";
	}

}

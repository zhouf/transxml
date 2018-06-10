package com.yfei.transxml.bean;

public class Log {
	private String reqUrl;
	private String method;
	//private String params;
	private String ipAndPort;
	private String timestamp;
	private String timeAndDate;
	private Session session;
	private SysInfo sysInfo;
	private Params params;
	public String getReqUrl() {
		return reqUrl;
	}
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Params getParams() {
		return params;
	}
	public void setParams(Params params) {
		this.params = params;
	}
	public String getIpAndPort() {
		return ipAndPort;
	}
	public void setIpAndPort(String ipAndPort) {
		this.ipAndPort = ipAndPort;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(String timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public SysInfo getSysInfo() {
		return sysInfo;
	}
	public void setSysInfo(SysInfo sysInfo) {
		this.sysInfo = sysInfo;
	}
	@Override
	public String toString() {
		return "Log [reqUrl=" + reqUrl + ", method=" + method + ", params=" + params + ", ipAndPort=" + ipAndPort
				+ ", timestamp=" + timestamp + ", timeAndDate=" + timeAndDate + ", session=" + session + ", sysInfo="
				+ sysInfo + "]";
	}
	
	
}

package com.yfei.transxml.jsonbean;

import java.util.List;

public class Device {

	private String deviceid;
	private String deviceType;
	private List<String> logtime;
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public List<String> getLogtime() {
		return logtime;
	}
	public void setLogtime(List<String> logtime) {
		this.logtime = logtime;
	}
}

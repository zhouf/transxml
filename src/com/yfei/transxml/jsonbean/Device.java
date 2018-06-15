package com.yfei.transxml.jsonbean;

public class Device {

	private String deviceType;
	private Integer useRate;
	
	public Device(String deviceType, Integer useRate) {
		super();
		this.deviceType = deviceType;
		this.useRate = useRate;
	}
	public String getDeviceid() {
		return deviceType;
	}
	public void setDeviceid(String type) {
		this.deviceType = type;
	}
	public Integer getUseRate() {
		return useRate;
	}
	public void setUseRate(Integer useRate) {
		this.useRate = useRate;
	}
}

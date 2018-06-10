package com.yfei.transxml.bean;

public class Params {
	private String operate;
	private String mcid;
	private String facId;
	private String facDesc;
	private String latitude;
	private String longitude;
	private String accuracy;
	private String devCode;
	private String eventId;
	private String modId;
	private String eventDevstu;
	private String eventDoorstu;
	private String keepThis;
	private String resultStr;
	
	
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getModId() {
		return modId;
	}
	public void setModId(String modId) {
		this.modId = modId;
	}
	public String getResultStr() {
		return resultStr;
	}
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	public String getFacId() {
		return facId;
	}
	public void setFacId(String facId) {
		this.facId = facId;
	}
	public String getFacDesc() {
		return facDesc;
	}
	public void setFacDesc(String facDesc) {
		this.facDesc = facDesc;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getEventDevstu() {
		return eventDevstu;
	}
	public void setEventDevstu(String eventDevstu) {
		this.eventDevstu = eventDevstu;
	}
	public String getEventDoorstu() {
		return eventDoorstu;
	}
	public void setEventDoorstu(String eventDoorstu) {
		this.eventDoorstu = eventDoorstu;
	}
	public String getKeepThis() {
		return keepThis;
	}
	public void setKeepThis(String keepThis) {
		this.keepThis = keepThis;
	}
	public String getMcid() {
		return mcid;
	}
	public void setMcid(String mcid) {
		this.mcid = mcid;
	}
	@Override
	public String toString() {
		return "Params [operate=" + operate + ", mcid=" + mcid + ", facId=" + facId + ", facDesc=" + facDesc
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", accuracy=" + accuracy + ", devCode="
				+ devCode + ", eventId=" + eventId + ", modId=" + modId + ", eventDevstu=" + eventDevstu
				+ ", eventDoorstu=" + eventDoorstu + ", keepThis=" + keepThis + ", resultStr=" + resultStr + "]";
	}
	
}

package com.yfei.transxml.jsonbean;

import java.util.List;

public class UseUrl {
	private String url;
	private List<String> logtime;//保留计算周访问量
	private Position accessPosition;

	class Position{
		private String ip;
		private String region;
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public List<String> getLogtime() {
		return logtime;
	}




	public void setLogtime(List<String> logtime) {
		this.logtime = logtime;
	}




	public Position getAccessPosition() {
		return accessPosition;
	}




	public void setAccessPosition(Position accessPosition) {
		this.accessPosition = accessPosition;
	}
}

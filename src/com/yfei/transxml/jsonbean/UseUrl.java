package com.yfei.transxml.jsonbean;

import java.util.ArrayList;
import java.util.List;

public class UseUrl {
	private String url;
	private int useRate;
	private int avt;// 平均停留时间
	
	
	public UseUrl(String url) {
		this.url = url;
		accessPosition = new ArrayList<Position>();
	}

	public int getUseRate() {
		return useRate;
	}

	public void setUseRate(int useRate) {
		this.useRate = useRate;
	}

	public int getAvt() {
		return avt;
	}

	public void setAvt(int avt) {
		this.avt = avt;
	}

	private List<Position> accessPosition;

	class Position {
		private String ip;
		private String region;
		
		public Position(String ip, String region) {
			super();
			this.ip = ip;
			this.region = region;
		}

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

	public List<Position> getAccessPosition() {
		return accessPosition;
	}

	public void setAccessPosition(List<Position> accessPosition) {
		this.accessPosition = accessPosition;
	}

	/**
	 * 添加ip信息
	 * @param ip
	 */
	public void addIp(String ip) {
		//过滤列表，如果有，则不加入
		boolean found = false;
		for(Position p : accessPosition){
			if(p.getIp().equals(ip)){
				found = true;
				break;
			}
		}
		if(!found){
			String region = convertRegion(ip);
			accessPosition.add(new Position(ip, region));
		}
	}

	
	/**
	 * 将ip地址转换为region的一个方法
	 * @param ip
	 * @return 得到地区信息
	 */
	private String convertRegion(String ip) {
		// FIXME 待完成
		return ip;
	}

	
}

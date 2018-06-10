package com.yfei.transxml.bean;

import java.util.ArrayList;
import java.util.List;

public class LogEntity {
	private List<Log> logList = new ArrayList<Log>();

	public List<Log> getLogList() {
		return logList;
	}

	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}
	
	public void addLog(Log log) {
		logList.add(log);
	}

}

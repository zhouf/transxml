package com.yfei.transxml.bean;

public class Session {
	private JsTicket jsTicket;
	private User user;
	public JsTicket getJsTicket() {
		return jsTicket;
	}
	public void setJsTicket(JsTicket jsTicket) {
		this.jsTicket = jsTicket;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Session [jsTicket=" + jsTicket + ", user=" + user + "]";
	}

}

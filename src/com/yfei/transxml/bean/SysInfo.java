package com.yfei.transxml.bean;

public class SysInfo {
	private String mess;
	private String dtime;
	private String contentLength;
	private String contentType;
	private String cacheControl;
	private String origin;
	private String pragma;
	private String userAgent;
	private String host;
	private String accept;
	private String acceptEncoding;
	private String acceptLanguage;
	private String referer;
	private String cookie;
	
	public String getContentLength() {
		return contentLength;
	}
	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getAcceptEncoding() {
		return acceptEncoding;
	}
	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}
	public String getAcceptLanguage() {
		return acceptLanguage;
	}
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	private String connection;
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getCacheControl() {
		return cacheControl;
	}
	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}
	public String getPragma() {
		return pragma;
	}
	public void setPragma(String pragma) {
		this.pragma = pragma;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	@Override
	public String toString() {
		return "SysInfo [mess=" + mess + ", dtime=" + dtime + ", contentLength=" + contentLength + ", contentType="
				+ contentType + ", cacheControl=" + cacheControl + ", origin=" + origin + ", pragma=" + pragma
				+ ", userAgent=" + userAgent + ", host=" + host + ", accept=" + accept + ", acceptEncoding="
				+ acceptEncoding + ", acceptLanguage=" + acceptLanguage + ", referer=" + referer + ", cookie=" + cookie
				+ ", connection=" + connection + "]";
	}

}

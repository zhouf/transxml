package com.yfei.transxml.bean;

public class JsTicket {
	private String url;
	private String timestamp;
	private String upto;
	private String nonce;
	private String signature;
	private String ticket;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUpto() {
		return upto;
	}
	public void setUpto(String upto) {
		this.upto = upto;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "JsTicket [url=" + url + ", timestamp=" + timestamp + ", upto=" + upto + ", nonce=" + nonce
				+ ", signature=" + signature + ", ticket=" + ticket + "]";
	}

}

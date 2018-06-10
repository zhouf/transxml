package com.yfei.transxml.bean;

public class User {

	private String id;
	private String realName;
	private String authorityInfo;
	private String email;
	private String frozen;
	private String phonenumber;
	private String password;
	private String qq;
	private String name;
	private String openid;
	private String headImg;
	private String roleId;
	private String roleName;
	private String organizationId;
	private String regionId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAuthorityInfo() {
		return authorityInfo;
	}
	public void setAuthorityInfo(String authorityInfo) {
		this.authorityInfo = authorityInfo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFrozen() {
		return frozen;
	}
	public void setFrozen(String frozen) {
		this.frozen = frozen;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", realName=" + realName + ", authorityInfo=" + authorityInfo + ", email=" + email
				+ ", frozen=" + frozen + ", phonenumber=" + phonenumber + ", password=" + password + ", qq=" + qq
				+ ", name=" + name + ", openid=" + openid + ", headImg=" + headImg + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", organizationId=" + organizationId + ", regionId=" + regionId + "]";
	}

}

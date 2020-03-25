package com.thyu.bean;

public class Owner {
	private Integer ownerId;
	private String ownerName;
	private String ownerIdNo;
	private String ownerSex;
	public Owner() {
		super();
	}
	public Owner(Integer ownerId, String ownerName, String ownerIdNo, String ownerSex) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerIdNo = ownerIdNo;
		this.ownerSex = ownerSex;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerIdNo() {
		return ownerIdNo;
	}
	public void setOwnerIdNo(String ownerIdNo) {
		this.ownerIdNo = ownerIdNo;
	}
	public String getOwnerSex() {
		return ownerSex;
	}
	public void setOwnerSex(String ownerSex) {
		this.ownerSex = ownerSex;
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerIdNo=" + ownerIdNo + ", ownerSex="
				+ ownerSex + "]";
	}
	
}

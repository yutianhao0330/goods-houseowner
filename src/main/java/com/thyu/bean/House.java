package com.thyu.bean;

import java.math.BigDecimal;
import java.util.List;

public class House {
	private Integer houseId;
	private String houseAddress;
	private String houseUse;
	private BigDecimal houseArea;
	private String housePic;
	private List<Owner> owners;
	public House() {
		super();
	}
	public House(Integer houseId, String houseAddress, String houseUse, BigDecimal houseArea, String housePic) {
		super();
		this.houseId = houseId;
		this.houseAddress = houseAddress;
		this.houseUse = houseUse;
		this.houseArea = houseArea;
		this.housePic = housePic;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getHouseUse() {
		return houseUse;
	}
	public void setHouseUse(String houseUse) {
		this.houseUse = houseUse;
	}
	public BigDecimal getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}
	public String getHousePic() {
		return housePic;
	}
	public void setHousePic(String housePic) {
		this.housePic = housePic;
	}
	public List<Owner> getOwners() {
		return owners;
	}
	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}
	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", houseAddress=" + houseAddress + ", houseUse=" + houseUse
				+ ", houseArea=" + houseArea + ", housePic=" + housePic + ", owners=" + owners + "]";
	}
	
}

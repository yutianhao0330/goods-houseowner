package com.thyu.dao;

import org.apache.ibatis.annotations.Param;

public interface HouseOwnerDao {

	int addHouseOwner(@Param("houseId")int houseId, @Param("oids")Integer[] oids);
	
	int deleteByHouseId(int houseId);

}

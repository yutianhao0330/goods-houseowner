package com.thyu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thyu.bean.House;

public interface HouseDao {
	List<Map<String, Object>> getHouseList(@Param("houseAddress")String houseAddress,@Param("ownerName")String ownerName);

	int addHouse(House house);
	
	House getHouseById(int houseId);

	int updateHouse(House house);
}

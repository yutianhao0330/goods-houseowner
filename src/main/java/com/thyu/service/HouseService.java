package com.thyu.service;

import java.util.Map;

import com.thyu.bean.House;

public interface HouseService {
	Map<String,Object> getHouseList(int pageNum,String houseAddress,String ownerName);

	boolean addHouse(House house, Integer[] oids);

	House getHouseById(int houseId);

	boolean updateHouse(House house, Integer[] oids);
}

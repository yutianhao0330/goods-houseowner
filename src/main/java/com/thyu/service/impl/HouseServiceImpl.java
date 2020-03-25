package com.thyu.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thyu.bean.House;
import com.thyu.bean.Owner;
import com.thyu.dao.HouseDao;
import com.thyu.dao.HouseOwnerDao;
import com.thyu.service.HouseService;
@Service
public class HouseServiceImpl implements HouseService{
	@Autowired
	private HouseDao houseDao;
	@Autowired
	private HouseOwnerDao houseOwnerDao;
	@Override
	public Map<String,Object> getHouseList(int pageNum, String houseAddress, String ownerName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<House> houseList = new ArrayList<House>();
		PageHelper.startPage(pageNum, 3);
		List<Map<String, Object>> mapInfo = houseDao.getHouseList(houseAddress, ownerName);
		PageInfo<Map<String, Object>> page = new PageInfo<>(mapInfo);
		if(!page.isHasNextPage()){
			page.setNextPage(page.getPages());
		}
		map.put("page", page);
		for (Map<String, Object> houseMap : mapInfo) {
			House house = new House();
			house.setHouseId((Integer)(houseMap.get("id")));
			house.setHouseAddress((String)(houseMap.get("address")));
			house.setHouseUse((String)(houseMap.get("houseUse")));
			house.setHouseArea((BigDecimal)(houseMap.get("areas")));
			List<Owner> owners = new ArrayList<>();
			String[] ownerInfo = ((String)(houseMap.get("owners"))).split(",");
			for (String ownername : ownerInfo) {
				Owner owner = new Owner();
				owner.setOwnerName(ownername);
				owners.add(owner);
			}
			house.setOwners(owners);
			houseList.add(house);
		}
		map.put("houseList", houseList);
		return map;
	}

	@Override
	public boolean addHouse(House house, Integer[] oids) {
		// TODO Auto-generated method stub
		houseDao.addHouse(house);
		int houseId = house.getHouseId();
		if(null!=oids && oids.length>0){
			houseOwnerDao.addHouseOwner(houseId,oids);
		}
		return true;
	}

	@Override
	public House getHouseById(int houseId) {
		// TODO Auto-generated method stub
		return houseDao.getHouseById(houseId);
	}

	@Override
	public boolean updateHouse(House house, Integer[] oids) {
		// TODO Auto-generated method stub
		houseDao.updateHouse(house);
		int houseId = house.getHouseId();
		houseOwnerDao.deleteByHouseId(houseId);
		//制造异常，测试事务是否能够回滚
		//int i=2/0;
		if(null!=oids && oids.length>0){
			houseOwnerDao.addHouseOwner(houseId,oids);
		}
		return true;
	}
	
}

package com.thyu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thyu.bean.House;
import com.thyu.service.HouseService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class HouseServiceImplTest {
	@Resource
	private HouseService houseService;
	@Test
	public void testGetHouseList() {
		Map<String, Object> map = houseService.getHouseList(1, "", "");
		List<House> houseList = (List<House>)(map.get("houseList"));
		for (House house : houseList) {
			System.out.println(house);
		}
	}

}

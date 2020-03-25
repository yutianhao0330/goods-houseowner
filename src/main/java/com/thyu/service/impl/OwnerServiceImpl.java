package com.thyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thyu.bean.Owner;
import com.thyu.dao.OwnerDao;
import com.thyu.service.OwnerService;
@Service
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private OwnerDao ownerDao;

	@Override
	public List<Owner> getOwnerList() {
		// TODO Auto-generated method stub
		return ownerDao.getOwnerList();
	}
	
}

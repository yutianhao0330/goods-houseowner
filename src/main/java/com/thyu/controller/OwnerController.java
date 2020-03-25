package com.thyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thyu.bean.Owner;
import com.thyu.service.OwnerService;

@Controller
@RequestMapping("owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	@RequestMapping("list")
	@ResponseBody
	public List<Owner> list(){
		return ownerService.getOwnerList();
	}
}

package com.thyu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.thyu.bean.House;
import com.thyu.service.HouseService;

@Controller
@RequestMapping("house")
@SuppressWarnings("unchecked")
public class HouseController {
	@Autowired
	private HouseService houseService;
	@RequestMapping("list")
	public String list(Model model,@RequestParam(defaultValue="1")int pageNum,String houseAddress,String ownerName){
		Map<String, Object> houseMap = houseService.getHouseList(pageNum, houseAddress, ownerName);
		model.addAttribute("houseAddress", houseAddress);
		model.addAttribute("ownerName", ownerName);
		model.addAttribute("page", (PageInfo<Map<String, Object>>)(houseMap.get("page")));
		model.addAttribute("houseList", (List<House>)(houseMap.get("houseList")));
		return "list";
	}
	@RequestMapping("add")
	public String toAdd(){
		return "add";
	}
	@RequestMapping("addHouse")
	public String add(Model model,House house,MultipartFile myFile,Integer[] oids,HttpServletRequest request) throws IllegalStateException, IOException{
		if(!myFile.isEmpty()){
			String realPath = "E:/upload/";
			String oldFile = myFile.getOriginalFilename();
			String fileName = UUID.randomUUID().toString()+oldFile.substring(oldFile.lastIndexOf("."));
			myFile.transferTo(new File(realPath, fileName));
			house.setHousePic(fileName);
		}
		houseService.addHouse(house,oids);
		return "redirect:list";
	}
	@RequestMapping("update")
	public String toUpdate(Model model,int houseId){
		model.addAttribute("houseId", houseId);
		return "update";
	}
	@RequestMapping("getById")
	@ResponseBody
	public House getById(int houseId){
		return houseService.getHouseById(houseId);
	}
	@RequestMapping("updateHouse")
	public String update(Model model,House house,MultipartFile myFile,Integer[] oids,HttpServletRequest request) throws IllegalStateException, IOException{
		if(!myFile.isEmpty()){
			String realPath = "E:/upload/";
			File file = new File(realPath, house.getHousePic());
			if(file.exists()){
				file.delete();
			}
			String oldFile = myFile.getOriginalFilename();
			String fileName = UUID.randomUUID().toString()+oldFile.substring(oldFile.lastIndexOf("."));
			myFile.transferTo(new File(realPath, fileName));
			house.setHousePic(fileName);
		}
		houseService.updateHouse(house,oids);
		return "redirect:list";
	}
}

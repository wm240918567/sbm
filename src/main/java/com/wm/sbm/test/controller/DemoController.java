package com.wm.sbm.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.wm.sbm.test.entity.Demo;
import com.wm.sbm.test.service.DemoService;

@RestController
public class DemoController {
	
	@Resource
	private DemoService demoService;
	

	@RequestMapping("/save")
	public void save() {
		demoService.save();
	}
	
	@RequestMapping(value="/likeName")
	public List<Demo> likeName(String name){
//		startPage(第几页，每页行数)
		PageHelper.startPage(1,2);
		return demoService.likeName("%"+name+"%");
	}
	
	@RequestMapping("/findDemoById")
	public Demo findDemoById(int id) {
		System.out.println("id:"+id);
		return demoService.findDemoById(id);
	}
}

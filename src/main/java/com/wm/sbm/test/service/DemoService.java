package com.wm.sbm.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wm.sbm.test.entity.Demo;
import com.wm.sbm.test.mapper.DemoMapper;

@Service
public class DemoService {
	
	@Resource
	private DemoMapper demoMapper;
	
	@Transactional
	public void save() {
		Demo demo = new Demo();
		demo.setName("赵四");
		demoMapper.save(demo);
		System.out.println(demo.getId());
	}
	
	public List<Demo> likeName(String name){
		return demoMapper.likeName(name);
	}
	
	public Demo findDemoById(int id) { 
		return demoMapper.findDemoById(id);
	}
	

}

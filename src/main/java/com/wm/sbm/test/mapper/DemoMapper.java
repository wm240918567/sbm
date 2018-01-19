package com.wm.sbm.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.wm.sbm.test.entity.Demo;

public interface DemoMapper {

	/**
	 * @Options使用@Options可以返回save的主键
	 * useGeneratedKeys是否要开启自增长主键key
	 * keyColumn 对应的DB中的名称
	 * keyProperty  对应的entity中的名称
	 * 返回的主键不用使用返回值，直接返回到传入的entity中.
	 * @param demo
	 */
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	@Insert("insert into demo(name) values(#{name});")
	public void save(Demo demo);
	
	@Select("select * from Demo where name like #{name}")
	public List<Demo> likeName(String name);

	@Select("select * from demo where id = #{id}")
	public Demo findDemoById(int id);
}

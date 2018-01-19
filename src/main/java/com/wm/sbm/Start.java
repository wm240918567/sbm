package com.wm.sbm;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication(scanBasePackages = { "com.wm.sbm"})
//扫描该包下的mybatis的持久化类
@MapperScan("com.wm.sbm.*.mapper")
public class Start extends WebMvcConfigurerAdapter{

	/**
	 * fastjson配置：
	 * 1，pom中引入依赖。
	 * 2，继承WebMvcConfigurerAdapter父类
	 * 3，重写configureMessageConverters方法
	 * 4，解决中文乱码
	 * 还有一种方法注入@bean，百度既有。
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			
			/**
			 * 配置spring boot使用 fastjson解析框架
			 */
			//先定义一个fastJsonHttpMessageConverte转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
			//添加fastJson的配置信息，比如是否需要格式化返回的JSON数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
			//解决fastJson中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        
        	//在fastJsonHttpMessageConverter添加fastJson的配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
			//将fastJsonHttpMessageConverter添加到converters当中
		converters.add(fastConverter);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}

}

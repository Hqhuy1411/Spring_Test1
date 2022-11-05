package com.DemoSpring;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		Path uploadDirPath = Paths.get("./images");
		String uploadPath = uploadDirPath.toFile().getAbsolutePath();
		registry.addResourceHandler("/images/**").addResourceLocations("file:/" + uploadPath +"/" );
	}
	
}

package org.kosta.myproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private String uploadPath = "file:///C:/kosta250/hanbitImages/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/images/**") //웹브라우저에 입력하는 url에 /photo 로 시작하는 경우 uploadPath에 설정한 폴더 기준으로 파일을 읽어오도록 설정
    			.addResourceLocations(uploadPath);//로컬컴퓨터에 저장된 파일을 읽어올 root경로
    }
}
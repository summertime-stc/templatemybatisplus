package com.example.stest.analysis.config;

import com.example.stest.analysis.interceptor.OneInterceptor;
import com.example.stest.analysis.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override

    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/**");

    }

    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        WebMvcConfigurer.super.addResourceHandlers(registry);

    }


}


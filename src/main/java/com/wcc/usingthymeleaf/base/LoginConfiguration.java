package com.wcc.usingthymeleaf.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/user/login");
        loginRegistry.excludePathPatterns("/user/logout");
        // 排除资源请求
        loginRegistry.excludePathPatterns("/hello");
        loginRegistry.excludePathPatterns("/index.html");
        loginRegistry.excludePathPatterns("/user/login.html");
        loginRegistry.excludePathPatterns("/error/**");
        loginRegistry.excludePathPatterns("/lib/**");
        loginRegistry.excludePathPatterns("/res/**");
//        loginRegistry.excludePathPatterns("/css/**");
//        loginRegistry.excludePathPatterns("/js/**");
//        loginRegistry.excludePathPatterns("/images/**");
    }
}

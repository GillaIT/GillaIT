package com.example.GillaIT;

import com.example.GillaIT.web.interceptor.AdminCheckInterceptor;
import com.example.GillaIT.web.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/post/detail/**", "/signup", "/login", "/logout", "/admin/login", "/css/**", "/*.ico", "/error", "/signup/email", "/signup/emailAuth");
        registry.addInterceptor(new AdminCheckInterceptor())
                .order(2)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");
    }
}

package com.example.bookmall.Config;

import com.example.bookmall.Compont.LoginHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginHandlerInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Bean
    public WebMvcConfigurer myWebMvcConfigurer(){

        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**").
                        excludePathPatterns("/admin/**","/user/**");
            }
        };

        return webMvcConfigurer;
    }


}

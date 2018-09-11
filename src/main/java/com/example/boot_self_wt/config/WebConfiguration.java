package com.example.boot_self_wt.config;

import com.example.boot_self_wt.common.filter.RateLimiterInterceptor;
import com.example.boot_self_wt.common.filter.ServiceAuthRestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wangtao
 * @date 2018/9/10 17:01
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(getRateLimiterInterceptor()).
                addPathPatterns("/**");
        registry.addInterceptor(getServiceAuthRestInterceptor())
                .addPathPatterns(getIncludePathPatterns());
    }

    @Bean
    RateLimiterInterceptor getRateLimiterInterceptor() {
        return new RateLimiterInterceptor();
    }

    @Bean
    ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthRestInterceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/userm/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

}

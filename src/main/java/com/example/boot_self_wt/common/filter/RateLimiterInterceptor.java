package com.example.boot_self_wt.common.filter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongl on 2018/6/27.
 */
public class RateLimiterInterceptor extends HandlerInterceptorAdapter {
    //每秒只发出5个令牌
    private RateLimiter rateLimiter = RateLimiter.create(15.0);

    /**
     * 尝试获取token令牌
     * @return
     */
    private boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(rateLimiter.tryAcquire()) {
            System.out.println("Succees***************************" );
            return super.preHandle(request, response, handler);
        }else if(rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)){
            System.out.println("等待***************************" + rateLimiter.acquire());
            return super.preHandle(request, response, handler);
        }else{
            System.out.println(new Date() + "  瞬时请求过多，抛出异常！");
            throw new Exception("服务器繁忙，请稍后再试！");
        }
    }

}

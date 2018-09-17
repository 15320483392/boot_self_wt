package com.example.boot_self_wt.common.utils;

import com.example.boot_self_wt.common.constant.CommonConstants;
import com.example.boot_self_wt.domain.entity.RedisLogin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangtao
 * @date 2018/9/17 16:50
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 保存信息
     * @author wangtao
     * @date 2018/9/17 16:58
     * @param  * @param loginName
     * @return void
     */
    public void addRedisLogin(String loginName){
        List<RedisLogin> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        if (redisTemplate.opsForValue().get(CommonConstants.REDIS_KEY) != null) {
            String str = redisTemplate.opsForValue().get(CommonConstants.REDIS_KEY);
            try {
                list = mapper.readValue(str,new TypeReference<List<RedisLogin>>() { });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //1537171766 933
        long nowtimes = new Date().getTime();
        list.stream().filter(u -> nowtimes < (u.getTimes() + CommonConstants.TOKEN_OVERTIME));
        if (list.size() > 0) {
            for (int i = 0 ; i < list.size() ; i++) {
                RedisLogin redisLogin = list.get(i);
                if (loginName.equals(redisLogin.getLoginName())) {
                    System.out.println("账号已登录，确认登录");
                    list.remove(i);
                }
            }
        }
        RedisLogin redisLogin = new RedisLogin();
        redisLogin.setLoginName(loginName);
        redisLogin.setTimes(new Date().getTime());
        list.add(redisLogin);
        //将账户存入
        redisTemplate.opsForValue().set(CommonConstants.REDIS_KEY,list.toString());
    }

    /**
     * 验证账号是否过期
     * @author wangtao
     * @date 2018/9/17 16:58
     * @param  * @param loginName
     * @return boolean
     */
    public boolean VerificationLogin(String loginName){
        boolean falg = false;
        List<RedisLogin> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        if (redisTemplate.opsForValue().get(CommonConstants.REDIS_KEY) != null) {
            String str = redisTemplate.opsForValue().get(CommonConstants.REDIS_KEY);
            try {
                list = mapper.readValue(str,new TypeReference<List<RedisLogin>>() { });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //1537171766 933
        long nowtimes = new Date().getTime();
        list.stream().filter(u -> nowtimes < (u.getTimes() + CommonConstants.TOKEN_OVERTIME));
        if (list.size() > 0) {
            for (int i = 0 ; i < list.size() ; i++) {
                RedisLogin redisLogin = list.get(i);
                if (loginName.equals(redisLogin.getLoginName())) {
                    falg = true;
                }
            }
        }
        return falg;
    }
}

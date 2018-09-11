package com.example.boot_self_wt.common.utils.user;

import com.example.boot_self_wt.common.server.KeyConfiguration;
import com.example.boot_self_wt.common.utils.jwt.IJWTInfo;
import com.example.boot_self_wt.common.utils.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by ace on 2017/9/10.
 */
@Component
public class JwtTokenUtil {

    //token过期时间
    @Value("${jwt.expire}")
    private int expire;

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 私钥加密
     * @author wangtao
     * @date 2018/9/11 9:47
     * @param  * @param jwtInfo
     * @return java.lang.String
     */
    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(),expire);
    }

    /**
     * 公钥解密
     * @author wangtao
     * @date 2018/9/11 9:47
     * @param  * @param token
     * @return com.example.boot_self_wt.common.utils.jwt.IJWTInfo
     */
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }


}

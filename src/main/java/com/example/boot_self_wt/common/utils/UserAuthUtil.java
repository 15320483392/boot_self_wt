package com.example.boot_self_wt.common.utils;

import com.example.boot_self_wt.common.exception.auth.ClientTokenException;
import com.example.boot_self_wt.common.utils.jwt.IJWTInfo;
import com.example.boot_self_wt.common.utils.jwt.JWTHelper;
import com.example.boot_self_wt.config.ServiceAuthConfig;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableScheduling
public class UserAuthUtil {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new ClientTokenException("Client token expired!");
        } catch (SignatureException ex) {
            throw new ClientTokenException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new ClientTokenException("Client token is null or empty!");
        }
    }
}

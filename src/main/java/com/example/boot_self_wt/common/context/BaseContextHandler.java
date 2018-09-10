package com.example.boot_self_wt.common.context;

import com.example.boot_self_wt.common.constant.CommonConstants;
import com.example.boot_self_wt.common.utils.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by ace on 2017/9/8.
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getTenantID(){
        Object value = get(CommonConstants.CONTEXT_KEY_TENANTID);
        return returnObjectValue(value);
    }

    public static String getUserID(){
        Object value = get(CommonConstants.CONTEXT_KEY_STAFF_ID);
        return returnObjectValue(value);
    }

    public static String getLoginName(){
        Object value = get(CommonConstants.CONTEXT_KEY_LOGIN_NAME);
        return returnObjectValue(value);
    }


    public static String getStaffName(){
        Object value = get(CommonConstants.CONTEXT_KEY_STAFF_NAME);
        return StringHelper.getObjectValue(value);
    }

    public static String getToken(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
        return StringHelper.getObjectValue(value);
    }
    public static void setToken(String token){set(CommonConstants.CONTEXT_KEY_USER_TOKEN,token);}

    public static void setStaffName(String staffName){set(CommonConstants.CONTEXT_KEY_STAFF_NAME,staffName);}

    public static void setStaffID(String staffId){
        set(CommonConstants.CONTEXT_KEY_STAFF_ID,staffId);
    }

    public static void setLoginName(String loginName){
        set(CommonConstants.CONTEXT_KEY_LOGIN_NAME,loginName);
    }

    public static void setTenantId(String TenantId) {
        set(CommonConstants.CONTEXT_KEY_TENANTID, TenantId);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest {
        private Logger logger = LoggerFactory.getLogger(UnitTest.class);

        @Test
        public void testSetContextVariable() throws InterruptedException {
            BaseContextHandler.set("test", "main");
            new Thread(()->{
                BaseContextHandler.set("test", "moo");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContextHandler.get("test"), "moo");
                logger.info("thread one done!");
            }).start();
            new Thread(()->{
                BaseContextHandler.set("test", "moo2");
                assertEquals(BaseContextHandler.get("test"), "moo2");
                logger.info("thread two done!");
            }).start();

            Thread.sleep(5000);
            assertEquals(BaseContextHandler.get("test"), "main");
            logger.info("main one done!");
        }

        @Test
        public void testSetUserInfo(){
            BaseContextHandler.setStaffID("test");
            assertEquals(BaseContextHandler.getUserID(), "test");
            BaseContextHandler.setStaffName("test2");
            assertEquals(BaseContextHandler.getLoginName(), "test3");
        }
    }
}

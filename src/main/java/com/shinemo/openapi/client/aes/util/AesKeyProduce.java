package com.shinemo.openapi.client.aes.util;

import com.shinemo.openapi.client.aes.common.Const;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by yuanjian on 4/14/17.
 */
public class AesKeyProduce {

    public static String idKeyProduce(Long orgId,int id){
        return orgId + Const.ID_CACHE_SPACE + id;
    }
    /**
     * 生成一个秘钥并返回
     * @return
     */
    public static String aeskeyProduce(){
        return RandomStringUtils.randomAscii(32).replaceAll("&|#|%|\\+|=| |/|\\?","_");
    }

}

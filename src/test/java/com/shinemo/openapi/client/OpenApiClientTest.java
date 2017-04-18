package com.shinemo.openapi.client;

import com.shinemo.openapi.client.common.AESUtils;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
public class OpenApiClientTest {
    private OpenApiClient client;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
    }

    @Test
    public void getToken() throws Exception {
        OpenApiResult<AccessTokenDTO> result = client.getAccessToken();
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        byte[] key = "1234".getBytes();
        byte[] keys = AESUtils.getSecretKey(key);

        System.out.println(Arrays.toString(keys));
        String src_text = "asdfadsfa水电费手动阀撒旦法斯蒂芬松岛枫松岛枫是的";


        byte[] src_bytes = src_text.getBytes("utf-8");

        byte[] encrypt_bytes = AESUtils.encrypt(src_bytes, AESUtils.getSecretKey(key));
        String encrypt_text = new String(encrypt_bytes, "iso8859-1");
        byte[] encrypt_bytes2 = encrypt_text.getBytes("iso8859-1");

        byte[] decrypt_bytes = AESUtils.decrypt(encrypt_bytes2, AESUtils.getSecretKey(key));
        String decrypt_text = new String(decrypt_bytes, "utf-8");

        System.out.println("src_text=" + src_text);
        System.out.println("src_text=" + src_text.length());
        System.out.println("src_bytes=" + Arrays.toString(src_bytes));
        System.out.println("src_bytes=" + src_bytes.length);
        System.out.println("encrypt_bytes=" + Arrays.toString(encrypt_bytes));
        System.out.println("encrypt_bytes=" + encrypt_bytes.length);
        System.out.println("encrypt_text=" + encrypt_text);
        System.out.println("encrypt_text=" + encrypt_text.length());
        System.out.println("encrypt_bytes2=" + Arrays.toString(encrypt_bytes2));
        System.out.println("decrypt_bytes=" + Arrays.toString(decrypt_bytes));
        System.out.println("decrypt_text=" + decrypt_text);
    }

}
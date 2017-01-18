package com.pj.mvp.utils;

import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES加密 解密算法
 * 
 * @author lifq
 * @date 2015-3-17 上午10:12:11
 */
public class DesUtil {

    private final static String DES = "DES";

    private final static String ENCODE = "GBK";

    private final static String defaultKey = "。。。。";

    public static void main(String[] args) throws Exception {

        String data = "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";
        // String key = "payabc*@";
        // System.err.println(encrypt(data, key));
        // System.err.println(decrypt(encrypt(data, key), key));
        // System.out.println(encrypt(data));
        System.out.println(decrypt(data));
        // System.out.println(decrypt("yJELFXsFnz0BZjMQQKhvmA2j1b35vq1aQzZLYe37PkljvTZ1Ub+ZTQ=="));

    }

    /**
     * 使用 默认key 加密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:46:43
     */
    public static String encrypt(String data) {

        try {
            byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
            String strs = Base64.encode(bt);
            return strs;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 使用 默认key 解密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:49:52
     */
    public static String decrypt(String data) {

        try {
            if (data == null)
                return null;
            byte[] buf = Base64.decode(data);
            byte[] bt = decrypt(buf, defaultKey.getBytes(ENCODE));
            return new String(bt, ENCODE);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * Description 根据键值进行加密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {

        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = Base64.encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException, Exception {

        if (data == null)
            return null;
        byte[] buf = Base64.decode(data);
        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {

        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {

        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}
package cn.levacr.is.is.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by hello on 2017/5/7.
 */

public class EncrUtil {
    /**
     * 加密
     *
     * @param file   待加密数据
     * @param key    密钥
     * @return byte[]    加密数据
     * @throws Exception
     */
    private static OutputStream encrypt(File file, Key key) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //执行操作
        CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(file), cipher);
        return cos;
    }

    /**
     * 解密
     *
     * @param file   待解密文件
     * @param key    密钥
     * @return byte[]    解密数据
     * @throws Exception
     */
    private static InputStream decrypt(File file, Key key) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        CipherInputStream cis = new CipherInputStream(new FileInputStream(file), cipher);
        return cis;
    }



    /**
     * 转换密钥
     *
     * @param key    二进制密钥
     * @return 密钥
     */
    private static Key toKey(byte[] key){
        //生成密钥
        return new SecretKeySpec(key, "AES");
    }
}

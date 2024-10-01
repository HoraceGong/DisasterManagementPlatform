package com.dmp.user.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 为用户密码和用户信息提供加密、解密服务
 */
public class CodeUtils {

    private final static String salt = "dmpuserinfosalt"; //加密盐（切勿忘记）

    /**
     * 加密用户密码
     * @param rawCodeString 用户原始密码
     * @return 加密结果
     */
    public String codeEncryption(String rawCodeString) throws NoSuchAlgorithmException {
        if (rawCodeString == null) {
            return null;
        }
        // 创建SHA-256摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update((rawCodeString + salt).getBytes());

        //计算哈希值
        byte[] result = messageDigest.digest();

        HexBytesConversion conversion = new HexBytesConversion();

        //将哈希值转化为16进制字符串并返回
        return conversion.bytesToString(result);
    }

    /**
     * 解密用户密码
     * @param encryptedString 加密后的用户密码
     * @return 解密结果
     */
    public String codeDecryption(String encryptedString) {
        return null;
    }
}

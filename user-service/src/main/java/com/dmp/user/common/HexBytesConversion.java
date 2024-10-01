package com.dmp.user.common;

/**
 * 提供byte数组和十六进制字符串之间的相互转换
 */
public class HexBytesConversion {

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 将byte数组转换为16进制字符串
     * @param byteArr byte数组
     * @return 16进制字符串
     */
    public String bytesToString(byte[] byteArr) {
        char[] buf = new char[byteArr.length * 2];
        int index = 0;

        for(byte b : byteArr) { // 利用位运算进行转换
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

    /**
     * 将16进制字符串转为byte数组
     * @param str 16进制字符串
     * @return byte数组
     */
    public byte[] stringToByte(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }
}

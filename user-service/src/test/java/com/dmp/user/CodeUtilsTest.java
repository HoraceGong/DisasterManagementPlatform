package com.dmp.user;

import com.dmp.user.common.CodeUtils;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class CodeUtilsTest {

    @Test
    public void encodeTest(){
        CodeUtils codeUtils = new CodeUtils();
        try {
            System.out.println(codeUtils.codeEncryption("123456"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

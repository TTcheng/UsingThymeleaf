package com.wcc.usingthymeleaf;

import com.wcc.usingthymeleaf.exception.BusinessException;
import com.wcc.usingthymeleaf.utils.EncryptionUtils;
import org.junit.Test;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name UtilsTest
 * @description 工具类测试
 * @date 19-1-14 下午2:47
 */
public class UtilsTest {

    @Test
    public void testEncryption() throws BusinessException {
        String plaintext = "handhand";
        String encrypted = EncryptionUtils.encrypt(plaintext);
        boolean b = EncryptionUtils.validate(plaintext, encrypted);
        System.out.println("encrypted = " + encrypted);
        assert b;
    }
}

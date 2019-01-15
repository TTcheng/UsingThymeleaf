package com.wcc.usingthymeleaf.service;

import com.wcc.usingthymeleaf.entity.User;
import com.wcc.usingthymeleaf.exception.BusinessException;
import com.wcc.usingthymeleaf.mapper.UserMapper;
import com.wcc.usingthymeleaf.utils.EncryptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name UserService
 * @description 用户service
 * @date 19-1-14 下午3:45
 */
@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper mapper;

    /**
     * 通过主键查询用户信息
     * @author Wangchuncheng
     * @date 19-1-14 下午3:55
     * @param user 前端用户信息
     * @return com.wcc.usingthymeleaf.entity.User
     **/
    public User selectByPrimaryKey(User user) {
        return mapper.selectByPrimaryKey(user.getId());
    }

    public User selectByUsername(User user){
        return mapper.selectByUserName(user);
    }

    /**
     * 登录,密码错误或验证失败时抛出异常
     * @author Wangchuncheng
     * @date 19-1-14 下午4:01
     * @param user 前端用户信息
     * @throws BusinessException
     * @return 数据库里的真实用户信息
     **/
    public User doLogin(User user) throws BusinessException {
        User condition = new User();
        condition.setName(user.getName());
        User realUser = selectByUsername(condition);
        boolean valid = EncryptionUtils.validate(user.getPassword(), realUser.getPassword());
        if (!valid) {
            throw new BusinessException("密码错误");
        }
        return realUser;
    }
}

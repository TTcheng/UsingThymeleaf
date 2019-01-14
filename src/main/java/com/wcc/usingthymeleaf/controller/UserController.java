package com.wcc.usingthymeleaf.controller;

import com.wcc.usingthymeleaf.base.BaseController;
import com.wcc.usingthymeleaf.base.ResponseData;
import com.wcc.usingthymeleaf.entity.User;
import com.wcc.usingthymeleaf.service.UserService;
import com.wcc.usingthymeleaf.utils.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name UserController
 * @description 用户控制
 * @date 19-1-14 下午3:10
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public ResponseData login(User user) {
        super.validateEmpty("id", user.getId());
        ResponseData response = new ResponseData();
        try {
            User validUser = userService.doLogin(user);
            super.getSession().setAttribute("user", validUser);
        } catch (Exception e) {
            response.setStatus(ResponseData.STATUS_ERROR);
            response.setMessage(e.getMessage());
            logger.error(ResponseData.STATUS_ERROR, e);
        }
        response.setStatus(ResponseData.STATUS_SUCCESS);
        return response;
    }
}

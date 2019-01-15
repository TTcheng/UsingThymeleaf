package com.wcc.usingthymeleaf.controller;

import com.wcc.usingthymeleaf.base.BaseController;
import com.wcc.usingthymeleaf.base.ResponseData;
import com.wcc.usingthymeleaf.entity.User;
import com.wcc.usingthymeleaf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     *
     * @param user 前台用户信息
     * @return com.wcc.usingthymeleaf.base.ResponseData
     * @author jesse
     * @date 19-1-15 上午9:06
     **/
    @ResponseBody
    @PostMapping("/user/login")
    public ResponseData login(User user) {
        super.validateEmpty("name", user.getName());
        ResponseData response = new ResponseData();
        try {
            User validUser = userService.doLogin(user);
            super.getSession().setAttribute("user", validUser);
            response.setStatus(ResponseData.STATUS_SUCCESS);
        } catch (Exception e) {
            response.setStatus(ResponseData.STATUS_ERROR);
            response.setMessage(e.getMessage());
            logger.error(ResponseData.STATUS_ERROR, e);
        }
        return response;
    }

    /**
     * 登录页面
     *
     * @param model 视图模型
     * @return java.lang.String
     * @author jesse
     * @date 19-1-15 上午9:07
     **/
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "/user/login";//返回登录页面
    }
}

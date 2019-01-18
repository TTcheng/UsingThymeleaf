package com.wcc.usingthymeleaf.base;

import com.wcc.usingthymeleaf.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name BaseController
 * @description 基本控制器
 * @date 19-1-14 下午3:13
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    protected void validateEmpty(String name,Object val) throws BusinessException {
        if(StringUtils.isEmpty(val)){
            throw new BusinessException("["+name+"]不能为空");
        }
    }

    protected HttpSession getSession(){
        return request.getSession();
    }
}

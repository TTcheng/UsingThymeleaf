package com.wcc.usingthymeleaf.base;

import com.wcc.usingthymeleaf.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * <p>
 * 程序异常处理器
 * </p>
 *
 * @author chuncheng.wang@hand-china.com 19-1-18 上午10:08
 */
@Order
@RestControllerAdvice
public class BaseExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionHandler.class);

    /**
     * <p>
     * 拦截{@link com.wcc.usingthymeleaf.exception.BusinessException}的异常信息
     * 返回封装后的异常信息
     * </p>
     *
     * @param exception BusinessException
     * @return com.wcc.usingthymeleaf.base.ResponseData
     * @author Wangchuncheng
     * @date 19-1-18 上午10:11
     **/
    @ExceptionHandler(BusinessException.class)
    public ResponseData process(BusinessException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return ResponseData.newError(exception.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ResponseData process(SQLException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return ResponseData.newError("数据操作错误，联系管理员");
    }

    @ExceptionHandler(Exception.class)
    public ResponseData process(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
        return ResponseData.newError("未知错误，联系管理员");
    }
}

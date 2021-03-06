package com.wcc.usingthymeleaf.controller;

import com.github.pagehelper.PageInfo;
import com.wcc.usingthymeleaf.base.BaseController;
import com.wcc.usingthymeleaf.base.ResponseData;
import com.wcc.usingthymeleaf.entity.Employee;
import com.wcc.usingthymeleaf.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name EmployeeController
 * @description 员工管理
 * @date 19-1-15 上午10:32
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @GetMapping("/add")
    public ResponseData add(Employee employee) {
        employeeService.insert(employee);
        return ResponseData.newSuccess();
    }

    @ResponseBody
    @GetMapping("/update")
    public ResponseData update(Employee employee) {
        employeeService.updateById(employee);
        return ResponseData.newSuccess();
    }

    @GetMapping("/page")
    public String getPage(Model model, Employee employee, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        try {
            PageInfo<Employee> pageInfo = employeeService.select(employee, page, pageSize);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute(ResponseData.STATUS, ResponseData.STATUS_SUCCESS);
        } catch (Exception e) {
            model.addAttribute(ResponseData.STATUS, ResponseData.STATUS_ERROR);
            model.addAttribute(ResponseData.MESSAGE, e.getMessage());
            logger.error("error", e);
        }
        return "/emp/employee";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam Long id, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        try {
            employeeService.deleteById(id);
            model.addAttribute(ResponseData.STATUS, ResponseData.STATUS_SUCCESS);
        } catch (Exception e) {
            model.addAttribute(ResponseData.STATUS, ResponseData.STATUS_ERROR);
            model.addAttribute(ResponseData.MESSAGE, e.getMessage());
            logger.error("error", e);
        }
        return "redirect:/emp/page?page=" + page + "&pageSize=" + pageSize;
    }

    /**
     * 新增或编辑页面
     *
     * @param model 模型数据
     * @param id    null时为新增，否则为编辑
     * @return java.lang.String
     * @author gongfucheng
     * @date 19-1-15 下午4:08
     **/
    @GetMapping("/edit")
    public String addOrUpdate(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            //新增
            model.addAttribute("emp", new Employee());
            return "/emp/edit";
        }
        //编辑
        Employee emp = employeeService.selectById(id);
        model.addAttribute("emp", emp);
        return "/emp/edit";
    }

}

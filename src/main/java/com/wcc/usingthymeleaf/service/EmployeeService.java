package com.wcc.usingthymeleaf.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcc.usingthymeleaf.entity.Employee;
import com.wcc.usingthymeleaf.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name EmployeeService
 * @description 员工服务
 * @date 19-1-15 上午11:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    public PageInfo<Employee> select(Employee employee, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Employee> employees = mapper.select(employee);
        PageInfo<Employee> pageInfo = new PageInfo(employees);
        return pageInfo;
    }

    public Employee selectById(Long id){
        return mapper.selectByPrimaryKey(id);
    }

    public Integer updateById(Employee emp){
        return mapper.updateByPrimaryKeySelective(emp);
    }

    public Integer deleteById(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer insert(Employee employee) {
        return mapper.insert(employee);
    }
}

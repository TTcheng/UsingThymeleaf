package com.wcc.usingthymeleaf.mapper;

import com.wcc.usingthymeleaf.entity.Employee;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> select(Employee record);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}
package com.wcc.usingthymeleaf.mapper;

import com.wcc.usingthymeleaf.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    List<User> select(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
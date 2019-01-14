package com.wcc.usingthymeleaf;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name MapperTest
 * @description todo
 * @date 19-1-14 上午11:47
 */

import com.wcc.usingthymeleaf.entity.Employee;
import com.wcc.usingthymeleaf.entity.User;
import com.wcc.usingthymeleaf.mapper.EmployeeMapper;
import com.wcc.usingthymeleaf.mapper.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by hailor on 16/9/21.
 */
//@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Rollback
@Transactional
public class MapperTest {

    @Resource
    UserMapper userMapper;

    private User user;

    @Before
    public void setUp() {

    }

    @Test
    public void testUserMapper() throws Exception {
        user = new User("Jack", 20, "fadfgdase", "M");
        int insert = userMapper.insert(user);
        assertEquals(1, insert);

        List<User> users = userMapper.select(user);
        assertEquals(1, users.size());
        User res = users.get(0);
        assertNotNull(res);

        res.setAge(25);
        int update = userMapper.updateByPrimaryKeySelective(res);
        assertEquals(1, update);

        int delete = userMapper.deleteByPrimaryKey(res.getId());
        assertEquals(1, delete);
    }

    private Employee employee;
    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void testEmployeeMapper() throws Exception {
        employee = new Employee("Jack", 20, "M");
        int insert = employeeMapper.insert(employee);
        assertEquals(1, insert);

        List<Employee> employees = employeeMapper.select(employee);
        assertEquals(1, employees.size());
        Employee res = employees.get(0);
        assertNotNull(res);

        res.setAge(25);
        int update = employeeMapper.updateByPrimaryKeySelective(res);
        assertEquals(1, update);

        int delete = employeeMapper.deleteByPrimaryKey(res.getId());
        assertEquals(1, delete);
    }

    @After
    public void tearDown() {

    }
}


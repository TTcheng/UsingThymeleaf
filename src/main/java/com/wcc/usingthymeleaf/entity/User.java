package com.wcc.usingthymeleaf.entity;

import com.wcc.usingthymeleaf.base.BaseEntity;

/**
 * @author jesse
 */
public class User extends BaseEntity {
    private static final long serialVersionUID = -3155875419236070378L;
    private Long id;

    private String name;

    private Integer age;

    private String password;

    private String gender;

    public User() {
    }

    public User(String name, Integer age, String password, String gender) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
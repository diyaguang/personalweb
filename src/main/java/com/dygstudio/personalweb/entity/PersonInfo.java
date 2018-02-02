package com.dygstudio.personalweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: diyaguang
 * @date: 2018/01/31 下午2:20
 * @description: com.dygstudio.personalweb.entity
 */
@Entity
@Table(name = "personinfo")
public class PersonInfo {
    @Id
    private String id;  //使用 GUID 标识主键
    private String name;
    private Integer age;
    //日期类型数据必须使用注解 @DateTimeFormat 来进行格式化，保证它在存取时间时能提供正确的格式。
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String mobile;
    private String address;
    private String census;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;
    private Integer status;
    private String headImgUrl;
    private String description;
    @OneToOne
    @JoinColumn(name = "positionKey")
    @JsonBackReference   //使用这个注解来防止关系对象的递归访问
    private Dictionary position;

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCensus() {
        return census;
    }
    public void setCensus(String census) {
        this.census = census;
    }
    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getHeadImgUrl() {
        return headImgUrl;
    }
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPosition(Dictionary position) {
        this.position = position;
    }

    public PersonInfo(){}


}

package com.dygstudio.personalweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: diyaguang
 * @date: 2018/01/31 下午4:25
 * @description: com.dygstudio.personalweb.entity
 */
@Entity
@Table(name = "Dictionary")
public class Dictionary {

    @Id
    private String id;
    private String value;
    private String parent;
    private Integer order;

    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }


}

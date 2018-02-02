package com.dygstudio.personalweb.service;

import org.springframework.stereotype.Service;

/**
 * @author: diyaguang
 * @date: 2018/02/02 下午2:19
 * @description: com.dygstudio.personalweb.service
 */
@Service
public interface RedisService {
    Object getObject(String key);
    void setObject(Object obj);
}

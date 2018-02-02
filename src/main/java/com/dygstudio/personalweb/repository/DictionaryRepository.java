package com.dygstudio.personalweb.repository;

import com.dygstudio.personalweb.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/01/31 下午6:00
 * @description: com.dygstudio.personalweb.repository
 */
@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,String> {
    List<Dictionary> getDictionariesByParent(String parentId);
}

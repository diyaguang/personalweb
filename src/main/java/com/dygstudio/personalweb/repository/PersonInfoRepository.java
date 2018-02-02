package com.dygstudio.personalweb.repository;

import com.dygstudio.personalweb.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: diyaguang
 * @date: 2018/01/31 下午5:58
 * @description: com.dygstudio.personalweb.repository
 */
@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo,String> {
}

package com.dygstudio.personalweb.repository;

import com.dygstudio.personalweb.entity.PersonInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: diyaguang
 * @date: 2018/01/31 下午5:58
 * @description: com.dygstudio.personalweb.repository
 */
@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo,String> {

    @Query("select t from PersonInfo t where t.age=?1 and t.name=?2")
    PersonInfo findByAgeAndName(Integer age,String name);

    @Query("select t from PersonInfo t where t.name like :name")
    Page<PersonInfo> findByName(@Param("name") String name, Pageable pageRequest);
}

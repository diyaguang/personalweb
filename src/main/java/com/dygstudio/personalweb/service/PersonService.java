package com.dygstudio.personalweb.service;

import com.dygstudio.personalweb.entity.PersonInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: diyaguang
 * @date: 2018/02/02 下午4:33
 * @description: com.dygstudio.personalweb.service
 */
@Service
public interface PersonService {
    Boolean savePerson(PersonInfo personInfo);
    Optional<PersonInfo> getPersonByID(String id);
    List<PersonInfo> getAll();
    Page<PersonInfo> findAll(Pageable pageable);
    void deletePerson(String id);
}

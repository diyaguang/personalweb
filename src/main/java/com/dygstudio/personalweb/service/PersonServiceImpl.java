package com.dygstudio.personalweb.service;

import com.dygstudio.personalweb.entity.PersonInfo;
import com.dygstudio.personalweb.repository.PersonInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: diyaguang
 * @date: 2018/02/02 下午4:35
 * @description: com.dygstudio.personalweb.service
 */
@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonInfoRepository personInfoRepository;
    public Boolean savePerson(PersonInfo personInfo){
        PersonInfo result = personInfoRepository.save(personInfo);
        if(result!=null)
            return true;
        else return false;
    }
    public Optional<PersonInfo> getPersonByID(String id){
        return personInfoRepository.findById(id);
    }
    public List<PersonInfo> getAll(){
        return personInfoRepository.findAll();
    }
}
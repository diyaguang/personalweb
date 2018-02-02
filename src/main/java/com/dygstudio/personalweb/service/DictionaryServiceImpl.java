package com.dygstudio.personalweb.service;

import com.dygstudio.personalweb.entity.Dictionary;
import com.dygstudio.personalweb.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: diyaguang
 * @date: 2018/02/02 下午3:46
 * @description: com.dygstudio.personalweb.service
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    public Optional<Dictionary> getDictionary(String id){
        return dictionaryRepository.findById(id);
    }
    public List<Dictionary> getDictionaryForType(String parentId){
        return dictionaryRepository.getDictionariesByParent(parentId);
    }
    public Boolean saveDictionary(Dictionary dictionary){
        Dictionary result = dictionaryRepository.save(dictionary);
        if(result !=null)
            return true;
        else
            return false;
    }
}

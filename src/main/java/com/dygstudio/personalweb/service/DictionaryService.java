package com.dygstudio.personalweb.service;

import com.dygstudio.personalweb.entity.Dictionary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: diyaguang
 * @date: 2018/02/02 下午3:22
 * @description: com.dygstudio.personalweb.service
 */
@Service
public interface DictionaryService {
    Optional<Dictionary> getDictionary(String id);
    List<Dictionary> getDictionaryForType(String parentId);
    Boolean saveDictionary(Dictionary dictionary);
}

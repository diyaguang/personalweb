package com.dygstudio.personalweb.controller;

import com.dygstudio.personalweb.entity.Dictionary;
import com.dygstudio.personalweb.entity.PersonInfo;
import com.dygstudio.personalweb.service.DictionaryService;
import com.dygstudio.personalweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * @author: diyaguang
 * @date: 2018/02/02 下午3:08
 * @description: com.dygstudio.personalweb.controller
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    DictionaryService dictionaryService;
    @Autowired
    PersonService personService;


    @RequestMapping("/new")
    public ModelAndView create(ModelMap model){
        String positionDicKey = "8b2950565d5c4d06877871c997789306";
        List<Dictionary> positions = dictionaryService.getDictionaryForType(positionDicKey);
        model.addAttribute("positions",positions);
        return new ModelAndView("person/new");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(PersonInfo personInfo) throws Exception{
        personService.savePerson(personInfo);
        return "1";
    }

    public ModelAndView show(ModelMap model, @PathVariable String id){
        Optional<PersonInfo> result = personService.getPersonByID(id);
        if(result.isPresent())
            model.addAttribute("personInfo",result.get());
        else model.addAttribute("ExceptionInfo","没有找到用户");
        return new ModelAndView("person/show");
    }
}

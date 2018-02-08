package com.dygstudio.personalweb.controller;

import com.dygstudio.personalweb.entity.Dictionary;
import com.dygstudio.personalweb.entity.PersonInfo;
import com.dygstudio.personalweb.service.DictionaryService;
import com.dygstudio.personalweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/{id}")
    public ModelAndView show(ModelMap model, @PathVariable String id){
        Optional<PersonInfo> result = personService.getPersonByID(id);
        if(result.isPresent())
            model.addAttribute("personInfo",result.get());
        else model.addAttribute("ExceptionInfo","没有找到用户");
        return new ModelAndView("person/show");
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView update(ModelMap model,@PathVariable String id){
        Optional<PersonInfo> result = personService.getPersonByID(id);
        if(result.isPresent())
            model.addAttribute("personInfo",result.get());
        else model.addAttribute("ExceptionInfo","没有找到用户");
        String positionDicKey = "8b2950565d5c4d06877871c997789306";
        List<Dictionary> positions = dictionaryService.getDictionaryForType(positionDicKey);
        model.addAttribute("positions",positions);
        return new ModelAndView("person/edit");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public String update(PersonInfo personInfo, HttpServletRequest request) throws Exception{
        Optional<PersonInfo> result = personService.getPersonByID(personInfo.getId());
        if(result.isPresent()){
            PersonInfo old = result.get();
            old.setName(personInfo.getName());
            personService.savePerson(old);
            return "1";
        }
        return "0";
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable String id) throws Exception{
        Optional<PersonInfo> result = personService.getPersonByID(id);
        if(result.isPresent()){
            personService.deletePerson(id);
            return "1";
        }
        return "0";
    }

    @RequestMapping("/list")
    public Page<PersonInfo> list(HttpServletRequest request) throws Exception{
        String name=request.getParameter("name");
        String page = request.getParameter("page");
        String size = request.getParameter("size");
        Pageable pageable = new PageRequest(page==null?0:Integer.parseInt(page),size==null?10:Integer.parseInt(size),new Sort(Sort.Direction.DESC,"id"));
        List<PersonInfo> result = personService.findAll(pageable).getContent();
        return personService.findAll(pageable);
    }

    @RequestMapping("/test")
    public PersonInfo TestMethod(HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        PersonInfo result = personService.findByAgeAndName(age, name);
         return result;
    }
}

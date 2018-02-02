package com.dygstudio.personalweb.service;

import com.dygstudio.personalweb.entity.Dictionary;
import com.dygstudio.personalweb.entity.PersonInfo;
import com.dygstudio.personalweb.repository.DictionaryRepository;
import com.dygstudio.personalweb.repository.PersonInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: diyaguang
 * @date: 2018/02/01 上午10:13
 * @description: com.dygstudio.personalweb.service
 */
@Service
public class CommonService {

    private static Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    PersonInfoRepository personInfoRepository;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void testFirstInitData() throws ParseException{
        dictionaryRepository.deleteAll();
        personInfoRepository.deleteAll();

        //option dictionary -----------------
        Dictionary positionTypeDic = new Dictionary();
        String positionTypeDicKey = UUID.randomUUID().toString().replaceAll("-","");
        positionTypeDic.setId(positionTypeDicKey);
        positionTypeDic.setValue("职位/岗位");
        positionTypeDic.setOrder(1001);
        dictionaryRepository.save(positionTypeDic);

        Dictionary positionDic = new Dictionary();
        String positionDicKey = UUID.randomUUID().toString().replaceAll("-","");
        positionDic.setId(positionDicKey);
        positionDic.setParent(positionTypeDicKey);
        positionDic.setValue("高级开发工程师");
        positionDic.setOrder(100101);
        dictionaryRepository.save(positionDic);

        Dictionary positionTestDic = new Dictionary();
        String positionTestDicKey = UUID.randomUUID().toString().replaceAll("-","");
        positionTestDic.setId(positionTestDicKey);
        positionTestDic.setParent(positionTypeDicKey);
        positionTestDic.setValue("高级测试工程师");
        positionTestDic.setOrder(100102);
        dictionaryRepository.save(positionTestDic);

        //option personInfo ----------------
        PersonInfo personInfo = new PersonInfo();
        String pId = UUID.randomUUID().toString().replaceAll("-","");
        personInfo.setId(pId);
        personInfo.setAge(34);
        personInfo.setAddress("beijing china");
        personInfo.setName("狄亚光");
        personInfo.setBirthday(dateFormat.parse("1983-03-08 00:00:00"));
        personInfo.setCensus("石家庄");
        personInfo.setDescription("个人说明");
        personInfo.setHeadImgUrl("");
        personInfo.setMobile("13811678743");
        personInfo.setPosition(positionDic);
        personInfo.setRegisterDate(new Date());
        personInfo.setStatus(1);
        personInfoRepository.save(personInfo);
    }
}

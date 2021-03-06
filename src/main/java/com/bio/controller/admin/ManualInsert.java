package com.bio.controller.admin;

import com.bio.Utils.PersonInfoUtils;
import com.bio.beans.Person;
import com.bio.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ManualInsert {
    @Autowired
    private IPersonService personService;

    @RequestMapping("/manualInsertPage")
    public String goInsertPage(){
        return "jsp/upload/manualInsertion";
    }

    @RequestMapping(value = "/manualInsertion")
    public ModelAndView manualInsertion(HttpServletRequest request,
                                        Person person){

        ModelAndView mv = new ModelAndView();
        if (person == null){
            mv.addObject("message", "输入错误");
        }else {
            String ID_code = person.getID_code();
            //提取年龄、性别
            //加密 md5(ID_code)
            person.setID_code(PersonInfoUtils.md5(ID_code));
            person.setGender(PersonInfoUtils.getGender(ID_code));
            //insert user to db
            personService.addPerson(person);
            //list all uploaded users
            List<Person> persons = personService.findAllPersons();
            //测试输出：当前插入对象
//            System.out.println(person);
            mv.addObject("message", "上传成功，请继续添加");
            mv.addObject("persons",persons);
        }
        mv.setViewName("/jsp/upload/manualInsertion");
        return mv;
    }
}

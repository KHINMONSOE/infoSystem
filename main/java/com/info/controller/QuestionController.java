package com.info.controller;

import com.info.entity.Question;
import com.info.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;
    // queryAll
    @GetMapping("/userQuestion")
    public String showUsers(ModelMap modelMap) {
        List<Question> userQuestion = questionService.queryAllUser();
        modelMap.addAttribute("userQuestion", userQuestion);
        return "userQuestion";
    }

    // 根据id查询
    @GetMapping("/query")
    public String query(Integer QuestionID, ModelMap modelMap) {

    	Question userQuestion = questionService.queryById(QuestionID);
        System.out.println(userQuestion);
        modelMap.addAttribute("userQuestion", userQuestion);
        return "userQuestion";

    }
  //根据flag查询
  	@GetMapping("/queryByFlag") 
  	public String queryByFlag(Integer disp_flg, ModelMap modelMap) { 
  		 List<Question> userQuestion = questionService.queryByFlag(disp_flg); // 如果Flag为null，则默认设置为0		 
  		 System.out.println(userQuestion); 
  		 modelMap.addAttribute("userQuestion",userQuestion); 
  		 return "userQuestion"; 
  	}
		 

    //根据年度查询
    @GetMapping("/queryYear")
    public String queryYear(String Year, ModelMap modelMap) {

        List<Question> userQuestion = questionService.queryByYear(Year);

        System.out.println(userQuestion);
        modelMap.addAttribute("userQuestion", userQuestion);
        return "userQuestion";

    }
    // delete
    @RequestMapping(value = "/deleteUserQuestion+{id}")
    public String dropUser(@PathVariable("id") Integer id, ModelMap modelMap) {
        int flag = questionService.dropUser(id);
        List<Question> userQuestion = questionService.queryAllUser();
        modelMap.addAttribute("userQuestion", userQuestion);
        if (flag == 1) {
            return "userQuestion";
        } else {

            return "error";
        }
    }


    // queryById
    @RequestMapping("/userQuestionUpdate+{id}")
    public String queryUser(@PathVariable("id") Integer id, ModelMap modelMap) {
        Question userQuestion = questionService.queryById(id);
        modelMap.addAttribute("userQuestion", userQuestion);
        return "userQuestionUpdate";
    }

    // queryById
    @RequestMapping("/userQuestionAdd+{id}")
    public String queryUserQuestionAdd(@PathVariable("id") Integer id, ModelMap modelMap) {
        Question userQuestion = questionService.queryById(id);
        modelMap.addAttribute("userQuestion", userQuestion);
        return "userQuestionAddPage";
    }


    // add

    @RequestMapping("/addUserQuestion")
    @ResponseBody
    public Map addUser(Question userQuestion) {
        int flag = questionService.addUser(userQuestion);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            // map.put("msg", "新規出来だ");
            return map;
        } else {
            // map.put("msg", "新規失敗した");
            return map;
        }
    }
    // update
    @RequestMapping("/modifyUserQuestion")
    @ResponseBody
    public Map modifyUser(Question userQuestion) {
        int flag = questionService.modifyUser(userQuestion);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
        	 //  map.put("msg", "編集出来た");
            return map;
        } else {
        	 // map.put("msg", "編集失敗した");
            return map;
        }
    }
}
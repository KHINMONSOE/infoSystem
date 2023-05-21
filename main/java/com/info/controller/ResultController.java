package com.info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.info.entity.Question;
import com.info.entity.Result;
import com.info.service.QuestionService;
import com.info.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResultController {

	@Autowired
	ResultService resultService;

	@Autowired
	QuestionService questionService;

	 // queryAll
	  @RequestMapping("/user") 
	  public String showUsers(Result userResult, ModelMap modelMap) {
	  //List<UserResult> resultList = resultService.queryByYear();
	  List<Question> resultList = questionService.queryAllUser();
	  //resultList.get(0).setUserinputres(userinputres);
	  modelMap.addAttribute("resultList", resultList);
	  return "userResult";
	  }
	 
	  //@RequestMapping("/result")
		//public String showResult(Result resulted, ModelMap modelMap) {
			//List<Question> resultList = questionService.showScore();
			//modelMap.addAttribute("resultList", resultList);
			//return "resulted";
		//}

	@RequestMapping("/result")
	public String showResult(ModelMap modelMap) {
		List<Result> resultList = resultService.showScore();
		modelMap.addAttribute("resultList", resultList);
		return "resulted";
	}
	
	/*
	 * @GetMapping("queryYear1") public String queryYear(String Year, ModelMap
	 * modelMap) { List<Question> resultList = questionService.queryByYear(Year);
	 * modelMap.addAttribute("resultList", resultList); return "resulted"; }
	 */
	 
	@GetMapping("queryYear1") 
	public String queryYear(String Year, ModelMap modelMap) { 
		List<Result> resultList = resultService.queryByYear(Year);
		modelMap.addAttribute("resultList", resultList); 
		return "resulted"; 
	}
		 
	// add
	@RequestMapping("/addUserResult")
	@ResponseBody
	public Map addUser(Result result) {
		String[] strQuestionIdList = result.getQuestionid().split(",");
		String[] strUserinputresList = result.getUserinputres().split(",");
		int flag = 0;
		if(strQuestionIdList.length == strUserinputresList.length)
		{
			for(int i=0;i<strQuestionIdList.length;i++)
			{
				Result aResult = new Result();
				aResult.setCommitdate(result.getCommitdate());
				aResult.setCompany(result.getCompany());
				aResult.setDeploy(result.getDeploy());
				aResult.setMail(result.getMail());
				aResult.setQuestion(result.getQuestion());
				aResult.setQuestionid(strQuestionIdList[i]);
				aResult.setUserinputres(strUserinputresList[i]);
				aResult.setUsername(result.getUsername());
				aResult.setYear(result.getYear());
				aResult.setScore(result.getScore());
				flag += resultService.addUser(aResult);
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag == strQuestionIdList.length) {
			map.put("msg", "回答ありがとうございます!");
			return map;
		} else {
			map.put("msg", "回答して下さい!");
			return map;
		}
	}
	
}

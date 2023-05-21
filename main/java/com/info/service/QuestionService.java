package com.info.service;

import com.info.entity.Question;

import java.util.List;

public interface QuestionService {

	   List<Question> queryByYear(String year);

	    Question queryById(Integer questionid);

	    int addUser(Question question);

	    int dropUser(int questionid);

	    int modifyUser(Question question);

	    List<Question> queryAllUser();

	    List<Question> queryByFlag(int disp_flg);

		List<Question> showScore();

}
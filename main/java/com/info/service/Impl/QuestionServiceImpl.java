package com.info.service.Impl;

import com.info.dao.QuestionDao;
import com.info.dao.ResultDao;
import com.info.entity.Question;
import com.info.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;
    @Autowired
    ResultDao resultDao;

    @Override
    public List<Question> queryByYear(String year) {
        return questionDao.queryByYear(year);
    }

    @Override
    public int dropUser(int questionid) {
        return questionDao.dropUser(questionid);
    }

    @Override
    public int modifyUser(Question question) {
        return questionDao.modifyUser(question);
    }

    @Override
    public List<Question> queryAllUser() {
        return questionDao.queryAllUser();
    }
  
    @Override
    public List<Question> queryByFlag(int disp_flg) {
        return questionDao.queryByFlag(disp_flg);
    }

	@Override
	public int addUser(Question question) {
		// TODO Auto-generated method stub
		return questionDao.addUser(question);
	}

	@Override
	public Question queryById(Integer questionid) {
		// TODO Auto-generated method stub
		return questionDao.queryById(questionid);
	}
	
	@Override
	public List<Question> showScore() {
		// TODO Auto-generated method stub
		return questionDao.showScore();
	}

	
}
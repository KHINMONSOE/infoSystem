package com.info.service.Impl;

import com.info.dao.QuestionDao;
import com.info.dao.ResultDao;
import com.info.entity.Result;
import com.info.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultDao resultDao;
    @Autowired
    QuestionDao questionDao;

    @Override
    public Result queryById(int questionid) {
        return resultDao.queryById(questionid);
    }

    @Override
    public int addUser(Result result) {
        return resultDao.addUser(result);
    }

    @Override
    public int dropUser(int questionid) {
        return resultDao.dropUser(questionid);
    }

    @Override
    public int modifyUser(Result result) {
        return resultDao.modifyUser(result);
    }

    @Override
    public List<Result> queryAllUser() {
        return resultDao.queryAllUser();
    }

    @Override
    public List<Result> queryByYear(String year) {
        return resultDao.queryByYear(year);
    }

	@Override
	public List<Result> showScore() {
		// TODO Auto-generated method stub
		return resultDao.showScore();
	}

}
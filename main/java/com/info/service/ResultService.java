package com.info.service;

import com.info.entity.Result;

import java.util.List;

public interface ResultService {
    Result queryById(int questionid);

    int addUser(Result result);

    int dropUser(int questionid);

    int modifyUser(Result result);

    List<Result> queryAllUser();

    List<Result> queryByYear(String year);

	List<Result> showScore();
}
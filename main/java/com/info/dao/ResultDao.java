package com.info.dao;

import com.info.entity.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResultDao {
    Result queryById(int questionid);

    int addUser(Result result);

    int dropUser(int questionid);

    int modifyUser(Result result);

    List<Result> queryAllUser();

    List<Result> queryByYear(String year);

    List<Result> showScore();
}
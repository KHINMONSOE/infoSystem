package com.info.dao;

import com.info.entity.Question;
import com.info.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface QuestionDao {

    List<Question> queryByYear(String year);

    Question queryById(Integer questionid);

    int addUser(Question question);

    int dropUser(int questionid);

    int modifyUser(Question question);

    List<Question> queryAllUser();
    
    List<Question> queryByFlag(int disp_flg);

    List<Question> showScore();

}
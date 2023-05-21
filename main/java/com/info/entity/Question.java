package com.info.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Question {
    private String year;

    private Integer questionid;
    
    private String result;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commitdate;

    private int score;

    private int disp_flg;

    private int disp_sort;

    private String question;
    
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getCommitdate() {
		return commitdate;
	}

	public void setCommitdate(Date commitdate) {
		this.commitdate = commitdate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getDisp_flg() {
		return disp_flg;
	}

	public void setDisp_flg(int disp_flg) {
		this.disp_flg = disp_flg;
	}

	public int getDisp_sort() {
		return disp_sort;
	}

	public void setDisp_sort(int disp_sort) {
		this.disp_sort = disp_sort;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
    
    

	

}

package com.info.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;
@Data
public class Result {
    private String mail;

    private String username;

    private String company;

    private String deploy;

    private String year;

    private String questionid;
    
    private String question;

    private String userinputres;
    
    private int score;

	/* @DateTimeFormat(pattern = "yyyy-MM-dd") */
    private Date commitdate;
    //多数レコードを追加ためのList
    private List<String> userinputresList;

    private List<Integer> questionidList;
    
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDeploy() {
		return deploy;
	}

	public void setDeploy(String deploy) {
		this.deploy = deploy;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserinputres() {
		return userinputres;
	}

	public void setUserinputres(String userinputres) {
		this.userinputres = userinputres;
	}

	public Date getCommitdate() {
		return commitdate;
	}

	public void setCommitdate(Date commitdate) {
		this.commitdate = commitdate;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
    
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
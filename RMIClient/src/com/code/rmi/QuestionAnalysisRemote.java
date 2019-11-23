package com.code.rmi;

import java.rmi.Remote;

import com.code.value.AnswerBundle;
import com.code.value.FinalResult;
import com.code.value.User;

public interface QuestionAnalysisRemote extends Remote{
public FinalResult SubmitAnswers(AnswerBundle answer,String ses)throws Exception;
public String login(User user)throws Exception;
}

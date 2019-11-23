package com.code.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.code.rmi.QuestionAnalysisRemote;
import com.code.value.AnswerBundle;
import com.code.value.FinalResult;
import com.code.value.QuestionRate;
import com.code.value.User;

public class RemoteImpl extends UnicastRemoteObject implements QuestionAnalysisRemote{

	public RemoteImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public FinalResult SubmitAnswers(AnswerBundle answer,String sessionid)  {
		// TODO Auto-generated method stub
	try {
		if(answer.getLong_time_medicine().equalsIgnoreCase("Yes")) {
			Markscounter.setUsage_count(Markscounter.getUsage_count()+1);
		}
		if(answer.getBuy_medicine_without_prescription().equalsIgnoreCase("yes"))
		{
			Markscounter.setUsage_count(Markscounter.getUsage_count()+1);
		}
		if(answer.getHow_often_buy_without_prescription().equalsIgnoreCase("Once a week")||answer.getHow_often_buy_without_prescription().equalsIgnoreCase("Twice a week")) {
			Markscounter.setUsage_count(Markscounter.getUsage_count()+1);
		}
		if(answer.getWhy_buy_medicine_without_prescription().equalsIgnoreCase("To save money")) {
			Markscounter.setUsage_count(Markscounter.getUsage_count()+1);
		}
		if(answer.getKnowledge_about_medicine().equalsIgnoreCase("yes")) {
			Markscounter.setKnowledge_count(Markscounter.getKnowledge_count()+1);
		}
		if(answer.getKnow_side_effect().equalsIgnoreCase("yes")) {
			Markscounter.setKnowledge_count(Markscounter.getKnowledge_count()+1);
		}
		if(answer.getHow_know_medicine().equalsIgnoreCase("from the doctor")) {
			Markscounter.setKnowledge_count(Markscounter.getKnowledge_count()+1);
		}
		if(answer.getBuy_medicine_without_prescription_good_idea().equalsIgnoreCase("no")) {
			Markscounter.setKnowledge_count(Markscounter.getKnowledge_count()+1);
		}
		FinalResult fresult=new FinalResult();
		fresult.setMyknowledge(Markscounter.getKnowledge_count()>=3?"Knowledgable":"Not Knowledgable");
		fresult.setMedicineUsabale(Markscounter.getUsage_count()>=3?"Usable":"Not Usable");	
		Databaseworks.executeQry("insert into sessions values('"+sessionid+"','"+answer.getGender()+"','"+answer.getAge()+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(3,'"+answer.getLong_time_medicine()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(4,'"+answer.getBuy_medicine_without_prescription()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(5,'"+answer.getHow_often_buy_without_prescription()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(8,'"+answer.getWhy_buy_medicine_without_prescription()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(6,'"+answer.getKnowledge_about_medicine()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(7,'"+answer.getKnow_side_effect()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(9,'"+answer.getHow_know_medicine()+"','"+sessionid+"')");
		Databaseworks.executeQry("insert into answers(qnum,answer,sessionid)values(10,'"+answer.getBuy_medicine_without_prescription_good_idea()+"','"+sessionid+"')");
        Databaseworks.executeQry("insert into result(sessionid,ratetype,rate)values('"+sessionid+"','Knowledge about medicine',"+Markscounter.getKnowledge_count()+")");
        Databaseworks.executeQry("insert into result(sessionid,ratetype,rate)values('"+sessionid+"','Can usage medicine',"+Markscounter.getUsage_count()+")");
		List<QuestionRate>qrk=Databaseworks.getQUestionKnow();
		List<QuestionRate>qru=Databaseworks.getQuestionrate();
		
		
		fresult.setKnowledge(qrk);
		fresult.setUsable(qru);
		Markscounter.setKnowledge_count(0);
		Markscounter.setUsage_count(0);
		return fresult;
	}catch(Exception ex) {
		ex.printStackTrace();
	}
				
        
        return null;
	}

	@Override
	public String login(User user){
		// TODO Auto-generated method stub
		try {
			String result=Databaseworks.getLoggedin("customer", user.getUsername(), user.getPassword());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "Unknown Error Occurred";
	}

}

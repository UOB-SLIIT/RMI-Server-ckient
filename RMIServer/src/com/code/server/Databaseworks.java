package com.code.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.code.value.QuestionRate;

public class Databaseworks {
static Connection con;
static {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useTimezone=true&serverTimezone=UTC", "root", "");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static ResultSet getResultSet(String qry) throws Exception{
	Statement stm=con.prepareStatement(qry);
	ResultSet res=stm.executeQuery(qry);
	
	return res;
}
public static void executeQry(String sql)throws Exception {
	Statement stm=con.prepareStatement(sql);
	stm.execute(sql);
}

public static String getLoggedin(String type,String user,String pass)throws Exception{
	ResultSet rs=getResultSet("select * from login where username='"+user+"' and type='"+type+"'");
	rs.last();
	if(rs.getRow()!=0) {
		if(pass.equals(decode(rs.getString(3)))) {
			return "Success";
		}
		return "Invalid password";
	}
	return "Invalid User name";
}
public static List<QuestionRate> getQuestionrate()throws Exception{
	List<QuestionRate>qru=new ArrayList<>();
	ResultSet rs2=Databaseworks.getResultSet("SELECT avg(rate),agerange FROM `result` inner join sessions on result.sessionid=sessions.sessionid where ratetype='Can usage medicine' group by agerange");
	while(rs2.next()) {
		QuestionRate qts=new QuestionRate();
		qts.setAge_range(rs2.getString(2));
		qts.setValue(rs2.getString(1));
		qru.add(qts);
	}
	return qru;
	
}

public static List<QuestionRate>getQUestionKnow()throws Exception{
	List<QuestionRate>qrk=new ArrayList<>();
	ResultSet rs=Databaseworks.getResultSet("SELECT avg(rate),agerange FROM `result` inner join sessions on result.sessionid=sessions.sessionid where ratetype='Knowledge about medicine' group by agerange");
	while(rs.next()) {
		QuestionRate qts=new QuestionRate();
		qts.setAge_range(rs.getString(2));
		qts.setValue(rs.getString(1));
		qrk.add(qts);
	}
	return qrk;
}
public static List<QuestionRate>getQUestionSet(String qry)throws Exception{
	List<QuestionRate>qrk=new ArrayList<>();
	ResultSet rs=Databaseworks.getResultSet(qry);
	while(rs.next()) {
		QuestionRate qts=new QuestionRate();
		qts.setAge_range(rs.getString(2));
		qts.setValue(rs.getString(1));
		qrk.add(qts);
	}
	return qrk;
}
private static String decode(String data) {
	byte[]bt=Base64.getDecoder().decode(data);
	return new String(bt);
}

}

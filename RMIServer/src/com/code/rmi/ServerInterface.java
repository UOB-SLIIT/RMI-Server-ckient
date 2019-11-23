package com.code.rmi;

public interface ServerInterface extends Readable{

 

	public String addQuetion(String Question ,int id);

	public void deleteQuestion(String Question,int id);

	public void editQuestion(String Question ,int id);

	public void addModerator(String username, String password,String  name,String id);

	public String userLogin(String username, String password);
	
	public String adminLogin(String username, String password);
	
	public String moderatorLogin(String username, String password);

	public void deleteUser(String username);

	public String deleteModerator(String username);

	public String plotGraph(String[] answers);


}

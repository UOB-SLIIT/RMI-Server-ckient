package client;

import java.rmi.Naming;
import java.util.UUID;

import com.code.rmi.QuestionAnalysisRemote;

public class ServerRemotefounder {
public static QuestionAnalysisRemote remote;
private static String session=UUID.randomUUID().toString();
public static QuestionAnalysisRemote getRemote()throws Exception {
	remote=(QuestionAnalysisRemote)Naming.lookup("rmi://localhost:8888/questionsremote");//7636
	return remote;
}
public static void setNewSession() {
	session=UUID.randomUUID().toString();
}
public static String getSession() {
	return session;
}
}

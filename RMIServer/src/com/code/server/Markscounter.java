package com.code.server;

public class Markscounter {
private static int knowledge_count;
private static int usage_count;
public static int getKnowledge_count() {
	return knowledge_count;
}
public static void setKnowledge_count(int knowledge_count) {
	Markscounter.knowledge_count = knowledge_count;
}
public static int getUsage_count() {
	return usage_count;
}
public static void setUsage_count(int usage_count) {
	Markscounter.usage_count = usage_count;
}
}

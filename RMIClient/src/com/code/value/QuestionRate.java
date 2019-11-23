package com.code.value;

import java.io.Serializable;

public class QuestionRate implements Serializable {
private String age_range;
private String value;
public String getAge_range() {
	return age_range;
}
public void setAge_range(String age_range) {
	this.age_range = age_range;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
}

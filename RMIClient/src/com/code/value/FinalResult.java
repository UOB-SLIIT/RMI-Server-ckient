package com.code.value;

import java.io.Serializable;
import java.util.List;

public class FinalResult implements Serializable {
private String myknowledge;
private String medicineUsabale;
private List<QuestionRate>knowledge;
public List<QuestionRate> getKnowledge() {
	return knowledge;
}
public void setKnowledge(List<QuestionRate> knowledge) {
	this.knowledge = knowledge;
}
public List<QuestionRate> getUsable() {
	return usable;
}
public void setUsable(List<QuestionRate> usable) {
	this.usable = usable;
}
private List<QuestionRate>usable;
public String getMyknowledge() {
	return myknowledge;
}
public void setMyknowledge(String myknowledge) {
	this.myknowledge = myknowledge;
}
public String getMedicineUsabale() {
	return medicineUsabale;
}
public void setMedicineUsabale(String medicineUsabale) {
	this.medicineUsabale = medicineUsabale;
}
}

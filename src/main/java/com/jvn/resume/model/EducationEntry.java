package com.jvn.resume.model;

public class EducationEntry extends AbstractEntry {

  public EducationEntry(){
  }

  public void setDegree(String degree) {
    this.setString1(degree);
  }

  public String getDegree() {
    return this.getString1();
  }

  public void setInstitution(String institution) {
    this.setString2(institution);
  }

  public String getInstitution() {
    return this.getString2();
  }

  public void setCity(String city) {
    this.setString3(city);
  }

  public String getCity() {
    return this.getString3();
  }

  public void setGpa(String gpa) {
    this.setString4(gpa);
  }

  public String getGpa() {
    return this.getString4();
  }

  public void setDescription(String description) {
    this.setString5(description);
  }

  public String getDescription() {
    return this.getString5();
  }

}

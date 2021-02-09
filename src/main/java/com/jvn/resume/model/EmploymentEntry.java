package com.jvn.resume.model;

public class EmploymentEntry extends AbstractEntry {

  private String jobTitle;
  private String employer;
  private String address;

  public EmploymentEntry() {
  }

  public void setJobTitle(String jobTitle) {
    this.setString1(jobTitle);
  }

  public String getJobTitle() {
    return getString1();
  }

  public void setEmployer(String employer) {
    this.setString2(employer);
  }

  public String getEmployer() {
    return getString2();
  }

  public void setAddress(String address) {
    this.setString3(address);
  }

  public String getAddress() {
    return getString3();
  }

}

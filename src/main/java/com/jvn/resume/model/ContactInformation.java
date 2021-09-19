package com.jvn.resume.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
public class ContactInformation {

  private String firstName;
  private String title;
  private String lastName;
  private Address address;
  private String phoneNumber; // TODO update Phone Number to Map
  private String email;
  private String webpage;
  private String additionalInfo;
  private String quote;

  @Override
  public String toString() {
      return reflectionToString(this);
  }

}

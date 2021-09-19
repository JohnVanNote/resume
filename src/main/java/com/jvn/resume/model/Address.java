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
public class Address {

  private String street;
  private String aptNumber;
  private String city;
  private String state;
  private String zip;

  @Override
  public String toString() {
      return reflectionToString(this);
  }

}

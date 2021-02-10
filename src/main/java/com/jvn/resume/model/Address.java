package com.jvn.resume.model;

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

}

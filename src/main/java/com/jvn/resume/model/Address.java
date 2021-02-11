package com.jvn.resume.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    return ToStringBuilder.reflectionToString(this);
  }

}

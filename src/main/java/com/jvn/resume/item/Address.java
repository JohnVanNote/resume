package com.jvn.resume.item;

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
public class Address extends AbstractItem {

  private String street;
  private String additionalStreet;
  private String city;
  private String state;
  private String zip;

}

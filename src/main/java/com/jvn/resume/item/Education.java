package com.jvn.resume.item;

import com.jvn.resume.date.DateRange;
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
public class Education extends AbstractItem {

  private String degree;
  private String name;
  private Address address;
  private String gpa;
  private DateRange tenure;

}

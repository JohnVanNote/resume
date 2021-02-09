package com.jvn.resume.model;

import com.jvn.resume.model.date.Duration;
import java.util.List;
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
public class Experience extends AbstractItem {

  private String title;
  private Duration tenure;
  private String company;
  private Address address;
  private List<String> technologyUsed;
  private List<String> highlights;

}

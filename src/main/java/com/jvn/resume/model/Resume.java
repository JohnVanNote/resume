package com.jvn.resume.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

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
public class Resume {

  private ContactInformation contactInformation;
  private List<Section> sections;

  @Override
  public String toString() {
      return reflectionToString(this);
  }

}

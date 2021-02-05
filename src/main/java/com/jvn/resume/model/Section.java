package com.jvn.resume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {

  protected boolean include = true;
  private String title;
  private List<String> entries;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

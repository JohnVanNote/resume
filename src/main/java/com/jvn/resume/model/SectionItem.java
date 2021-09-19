package com.jvn.resume.model;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class SectionItem {

  private boolean emphasis;
  private String key;
  private String value;
  private String comment;

  public boolean hasComment() {
    return isNotEmpty(comment);
  }

  @Override
  public String toString() {
    return reflectionToString(this);
  }

}

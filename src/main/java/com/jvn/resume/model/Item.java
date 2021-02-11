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
@Setter
@NoArgsConstructor
public class Item {

  private boolean emphasis;
  private String key;
  private String value;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

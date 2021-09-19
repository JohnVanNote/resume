package com.jvn.resume.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import com.jvn.resume.model.date.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public abstract class AbstractEntry {

  private Duration duration;
  protected String string1;
  protected String string2;
  protected String string3;
  protected String string4;
  protected Description description;

  @Override
  public String toString() {
      return reflectionToString(this);
  }

}

package com.jvn.resume.section;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractSection implements Section {

  protected boolean include = true;

  public boolean isInclude() {
    return include;
  }

  public void setInclude(boolean include) {
    this.include = include;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

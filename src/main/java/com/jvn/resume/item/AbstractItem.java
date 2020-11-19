package com.jvn.resume.item;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AbstractItem implements Item {

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

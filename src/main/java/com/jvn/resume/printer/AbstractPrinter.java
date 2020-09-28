package com.jvn.resume.printer;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractPrinter implements Printer {

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

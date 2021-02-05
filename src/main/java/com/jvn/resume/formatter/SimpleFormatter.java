package com.jvn.resume.formatter;

import com.jvn.resume.model.Resume;

public class SimpleFormatter implements Formatter {

  @Override
  public String format(Resume resume) {
    return resume.toString();
  }

}

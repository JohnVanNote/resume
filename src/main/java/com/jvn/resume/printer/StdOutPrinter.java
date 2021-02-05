package com.jvn.resume.printer;

import com.jvn.resume.formatter.Formatter;

import com.jvn.resume.model.Resume;
import java.io.IOException;

public class StdOutPrinter extends AbstractPrinter {

  public StdOutPrinter(Resume resume) {
    super(resume);
  }

  @Override
  public void close() throws Exception {
  }

  @Override
  public void print(Formatter formatter) throws IOException {
    System.out.println(formatter.format(resume));
  }

}

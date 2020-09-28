package com.jvn.resume.printer;

import com.jvn.resume.Resume;
import java.io.IOException;
import java.io.Writer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimplePrinter extends AbstractPrinter {

  protected Appendable out;

  @Override
  public void printResume(Resume resume) throws IOException {
    this.out.append(resume.toString());
  }

  public void close() throws IOException {
    if (out instanceof Writer) {
      ((Writer) out).close();
    }
  }

}

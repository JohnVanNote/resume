package com.jvn.resume.printer;

import com.jvn.resume.model.Resume;
import java.io.Writer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
@AllArgsConstructor
public abstract class FileSystemPrinter implements Printer {

  protected Resume resume;
  protected Appendable out;

  @Override
  public void close() throws Exception {
    if (out instanceof Writer) {
      ((Writer) out).close();
    }
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

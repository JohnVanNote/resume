package com.jvn.resume.printer;

import com.jvn.resume.formatter.Formatter;
import com.jvn.resume.model.Resume;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
@AllArgsConstructor
public class FileSystemPrinter implements Printer {

  protected Resume resume;
  protected Path path;

  @Override
  public void print(Formatter formatter) throws IOException {
    Files.write(path, formatter.format(resume).getBytes());
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

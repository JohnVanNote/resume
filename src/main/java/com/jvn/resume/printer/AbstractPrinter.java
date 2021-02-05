package com.jvn.resume.printer;

import com.jvn.resume.model.Resume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractPrinter implements Printer {

  protected Resume resume;

}

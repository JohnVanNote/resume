package com.jvn.resume.printer;

import com.jvn.resume.formatter.Formatter;
import java.io.IOException;

public interface Printer extends AutoCloseable {

  void print(Formatter formatter) throws IOException;

}

package com.jvn.resume.printer;

import com.jvn.resume.Resume;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Printer_UnitTest {

  private Printer printer = new PrinterImplementation();

  @Test
  public void printResume_InInterface_IsCallable() throws IOException {
    printer.printResume(null);
    Assert.assertTrue(((PrinterImplementation) printer).called);
  }

  @Test(expectedExceptions = IOException.class)
  public void printResume_InInterface_CanThrowIOException() throws IOException {
    printer.printResume(new Resume());
  }

  private static class PrinterImplementation implements Printer {

    boolean called = false;

    public void printResume(Resume resume) throws IOException {
      called = true;
      if (resume != null) {
        throw new IOException();
      }
    }

  }

}

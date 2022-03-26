package com.jvn.resume.printer;

import com.jvn.resume.formatter.Formatter;
import com.jvn.resume.model.Resume;

public class StdOutPrinter extends AbstractPrinter {

    public StdOutPrinter(Resume resume) {
        super(resume);
    }

    @Override
    public void print(Formatter formatter) {
        System.out.println(formatter.format(resume));
    }

}

package com.jvn.resume;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvn.resume.printer.Printer;
import com.jvn.resume.printer.VelocityPrinter;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Main {

  private static final String DEF_PROP_PATH = "resume.properties";
  private static final String DATA_DIR = "data";
  private static final String OUTPUT_DIR = "out";
  private static final String TEMPLATES_DIR = "templates";

  /*
  public static void main(String[] args) throws Exception {

    String propertiesFilePath = DEF_PROP_PATH;
    if (args.length > 0) {
      propertiesFilePath = args[0];
    }

    ResumeProperties properties = new ResumeProperties(propertiesFilePath);
    String resumeFileName = properties.getFileName();
    String resumeFileType = properties.getFileType();
    String templateFileName = properties.getTemplateFileName();
    String outputFileName = properties.getOutputFileName();
    String baseFileName = FilenameUtils.getBaseName(resumeFileName);

    File resumeFile = new File(DATA_DIR, resumeFileName);
    ObjectMapper mapper = MapperFactory.getMapper(resumeFileType);
    Resume resume = mapper.readValue(FileUtils.readFileToString(resumeFile), LatexResume.class);

    File template = new File(TEMPLATES_DIR, templateFileName);
    File out = new File(OUTPUT_DIR, outputFileName);
    Printer printer = new VelocityPrinter(template, out);
    printer.printResume(resume);

    List<MapperFactory.FileType> otherTypes = MapperFactory.getOtherTypes(resumeFileType);
    for (MapperFactory.FileType type : otherTypes) {
      String typeString = type.getType();
      ObjectMapper otherMapper = MapperFactory.getMapper(typeString);
      String filename = baseFileName + "." + typeString;
      otherMapper.writeValue(new File(DATA_DIR, filename), resume);
    }

  }
   */

}

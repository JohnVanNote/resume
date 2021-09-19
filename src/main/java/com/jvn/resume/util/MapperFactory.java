package com.jvn.resume.util;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public class MapperFactory {

  private MapperFactory() {
  }

  public static ObjectMapper getMapper(String filetype) {
    FileType type = FileType.fromType(filetype);
    if (type == null) {
      String msg = String.format("File Type %s does not match a supported format: %s.", filetype, Arrays.asList(FileType.values()));
      throw new IllegalArgumentException(msg);
    }
    return getMapper(type);
  }

  public static List<FileType> getOtherTypes(String filetype) {
    FileType type = FileType.fromType(filetype);
    List<FileType> otherTypes = new ArrayList<>(Arrays.asList(FileType.values()));
    otherTypes.remove(type);
    return otherTypes;
  }

  private static ObjectMapper getMapper(FileType type) {
    ObjectMapper mapper;
    switch (type) {
      case JSON:
        mapper = new ObjectMapper();
        //mapper.setDefaultPrettyPrinter(CustomJsonArrayPrettyPrinter.INSTANCE);
        break;
      case XML:
        mapper = new XmlMapper();
        break;
      default:
        throw new IllegalArgumentException(String.format("No behavior defined for file type %s.", type));
    }

    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    return mapper;
  }


  @Getter
  public enum FileType {
    XML("xml"),
    JSON("json");

    private String type;

    FileType(String type) {
      this.type = type;
    }

    public static FileType fromType(String filetype) {
      FileType theType = null;
      for (FileType type : FileType.values()) {
          if (equalsIgnoreCase(type.getType(), filetype)) {
              theType = type;
          }
      }
      return theType;
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }
  }

}

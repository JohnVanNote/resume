package com.jvn.resume.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvn.resume.model.Address;
import com.jvn.resume.model.ContactInformation;
import com.jvn.resume.model.Resume;

public class ResumePrintingUtil {

  public static void main(String[] args) throws Exception {
    Address contactAddress = Address.builder()
        .city("New York")
        .state("New York")
        .street("NY Ave")
        .zip("12345")
        .build();
    ContactInformation contactInfo = ContactInformation.builder()
        .firstName("Don")
        .lastName("Draper")
        .address(contactAddress)
        .phoneNumber("123-456-7890")
        .email("ddraper@sterling-cooper.com")
        .build();
    Resume resume = Resume.builder()
        .contactInformation(contactInfo)
        .build();
    ObjectMapper mapper = MapperFactory.getMapper("json");
    mapper.writeValue(System.out, resume);
  }

}

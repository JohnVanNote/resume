package com.jvn.resume.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvn.resume.model.Address;
import com.jvn.resume.model.ContactInformation;
import com.jvn.resume.model.EducationEntry;
import com.jvn.resume.model.EmploymentEntry;
import com.jvn.resume.model.Resume;
import com.jvn.resume.model.Section;
import com.jvn.resume.model.date.Duration;
import com.jvn.resume.model.date.SimpleDate;
import java.time.Month;
import java.util.Arrays;

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

    EducationEntry edEntry1 = new EducationEntry();
    edEntry1.setDuration(Duration.builder()
        .startDate(
            SimpleDate.builder().month(Month.SEPTEMBER).year(1950).build()
        )
        .endDate(
            SimpleDate.builder().month(Month.MAY).year(1954).build()
        ).build());
    edEntry1.setDegree("Degree");
    edEntry1.setInstitution("Institution");
    edEntry1.setCity("City");
    edEntry1.setGpa("Grade");
    edEntry1.setDescription("Description");

    Section education = Section.builder()
        .title("Education")
        .educationEntries(Arrays.asList(edEntry1, edEntry1))
        .build();

    EmploymentEntry empEntry1 = new EmploymentEntry();
    empEntry1.setDuration(Duration.builder()
        .startDate(
            SimpleDate.builder().month(Month.JANUARY).year(1958).build()
        )
        .endDate(
            SimpleDate.builder().month(Month.DECEMBER).year(1963).build()
        ).build());
    empEntry1.setJobTitle("Creative Director");
    empEntry1.setEmployer("Sterling Cooper");
    empEntry1.setAddress("New York, NY");

    Section experience = Section.builder()
        .title("Experience")
        .employmentEntries(Arrays.asList(empEntry1))
        .build();

    Resume resume = Resume.builder()
        .contactInformation(contactInfo)
        .sections(Arrays.asList(
            education,
            experience
        ))
        .build();
    ObjectMapper mapper = MapperFactory.getMapper("json");
    mapper.writeValue(System.out, resume);
  }

}

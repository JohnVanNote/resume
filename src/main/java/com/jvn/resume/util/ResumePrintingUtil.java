package com.jvn.resume.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvn.resume.model.Address;
import com.jvn.resume.model.ContactInformation;
import com.jvn.resume.model.EducationEntry;
import com.jvn.resume.model.EmploymentEntry;
import com.jvn.resume.model.Item;
import com.jvn.resume.model.Resume;
import com.jvn.resume.model.Section;
import com.jvn.resume.model.date.Duration;
import com.jvn.resume.model.date.SimpleDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    List<Item> items = new ArrayList<>();
    items.add(Item.builder().emphasis(true).key("title").value("Title").build());
    items.add(Item.builder().key("supervisors").value("Supervisors").build());
    items.add(Item.builder().key("description").value("Short thesis abstract").build());

    Section thesis = Section.builder()
        .title("Master Thesis")
        .items(items)
        .build();

    EmploymentEntry vocationalEntry = new EmploymentEntry();
    vocationalEntry.setDuration(Duration.builder()
        .startDate(
            SimpleDate.builder().month(Month.JANUARY).year(1958).build()
        )
        .endDate(
            SimpleDate.builder().month(Month.DECEMBER).year(1963).build()
        ).build());
    vocationalEntry.setJobTitle("Creative Director");
    vocationalEntry.setEmployer("Sterling Cooper");
    vocationalEntry.setAddress("New York, NY");

    EmploymentEntry miscEntry = new EmploymentEntry();
    miscEntry.setDuration(Duration.builder()
        .startDate(
            SimpleDate.builder().month(Month.JANUARY).year(1953).build()
        )
        .endDate(
            SimpleDate.builder().month(Month.DECEMBER).year(1957).build()
        ).build());
    miscEntry.setJobTitle("Army");
    miscEntry.setEmployer("WW2");
    miscEntry.setAddress("Western Front");

    Section experience = Section.builder()
        .title("Experience")
        .subSections(Arrays.asList(
            Section.builder()
                .title("Vocational")
                .employmentEntries(Arrays.asList(vocationalEntry))
                .build(),
            Section.builder()
                .title("Miscellaneous")
                .employmentEntries(Arrays.asList(miscEntry))
                .build()
        )).build();

    Resume resume = Resume.builder()
        .contactInformation(contactInfo)
        .sections(Arrays.asList(
            education,
            thesis,
            experience
        )).build();

    ObjectMapper mapper = MapperFactory.getMapper("json");
    mapper.writeValue(System.out, resume);
  }

}

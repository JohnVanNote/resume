package com.jvn.resume.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvn.resume.model.Address;
import com.jvn.resume.model.ContactInformation;
import com.jvn.resume.model.Description;
import com.jvn.resume.model.DescriptionItem;
import com.jvn.resume.model.EducationEntry;
import com.jvn.resume.model.EmploymentEntry;
import com.jvn.resume.model.SectionItem;
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
    edEntry1.setDescription(Description.builder().content("Description").build());

    Section education = Section.builder()
        .title("Education")
        .educationEntries(Arrays.asList(edEntry1, edEntry1))
        .build();

    List<SectionItem> sectionItems = new ArrayList<>();
    sectionItems.add(SectionItem.builder().emphasis(true).key("title").value("Title").build());
    sectionItems.add(SectionItem.builder().key("supervisors").value("Supervisors").build());
    sectionItems.add(SectionItem.builder().key("description").value("Short thesis abstract").build());

    Section thesis = Section.builder()
        .title("Master Thesis")
        .sectionItems(sectionItems)
        .build();

    EmploymentEntry vocationalEntry1 = new EmploymentEntry();
    vocationalEntry1.setDuration(Duration.builder()
        .startDate(
            SimpleDate.builder().month(Month.JANUARY).year(1958).build()
        )
        .endDate(
            SimpleDate.builder().month(Month.DECEMBER).year(1963).build()
        ).build());
    vocationalEntry1.setJobTitle("Creative Director");
    vocationalEntry1.setEmployer("Sterling Cooper");
    vocationalEntry1.setAddress("New York, NY");
    vocationalEntry1.setDescription(Description.builder()
        .content("General description no longer than 1--2 lines. Detailed achievements:%")
        .descriptionItems(Arrays.asList(
            DescriptionItem.builder()
                .content("Achievement 1")
                .build(),
            DescriptionItem.builder()
                .content("Achievement 2, with sub-achievements")
                .descriptionItems(
                    Arrays.asList(
                        DescriptionItem.builder()
                            .content("Sub-achievement (a)")
                            .build(),
                        DescriptionItem.builder()
                            .content("Sub-achievement (b)")
                            .descriptionItems(
                                Arrays.asList(
                                    DescriptionItem.builder()
                                        .content("Sub-sub-achievement i")
                                        .build(),
                                    DescriptionItem.builder()
                                        .content("Sub-sub-achievement ii")
                                        .build(),
                                    DescriptionItem.builder()
                                        .content("Sub-sub-achievement iii)")
                                        .build()
                                )
                            )
                            .build(),
                        DescriptionItem.builder()
                            .content("Sub-achievement (c)")
                            .build()
                    )
                )
                .build(),
            DescriptionItem.builder()
                .content("Achievement 3")
                .build()
        ))
        .build());

    EmploymentEntry vocationalEntry2 = new EmploymentEntry();
    vocationalEntry2.setDuration(Duration.builder()
        .startDate(
            SimpleDate.builder().month(Month.APRIL).year(1955).build()
        )
        .endDate(
            SimpleDate.builder().month(Month.NOVEMBER).year(1958).build()
        ).build());
    vocationalEntry2.setJobTitle("Boss");
    vocationalEntry2.setEmployer("Example");
    vocationalEntry2.setAddress("Wherever");

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
                .employmentEntries(Arrays.asList(vocationalEntry1, vocationalEntry2))
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

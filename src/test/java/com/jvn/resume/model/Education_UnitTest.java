package com.jvn.resume.model;

import com.jvn.resume.date.DateRange;
import com.jvn.resume.date.SimpleDate;
import java.time.Month;
import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class Education_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    SimpleDate startDate = SimpleDate.builder().month(Month.JANUARY).year(1983).build();
    SimpleDate endDate = SimpleDate.builder().month(Month.FEBRUARY).year(1984).build();
    DateRange tenure = DateRange.builder().startDate(startDate).endDate(endDate).build();

    Address address = Address.builder()
        .street("135 String St.")
        .aptNumber("Apt. 22b")
        .city("Portland")
        .state("OR")
        .zip("Some Oregon Zip")
        .build();

    Education education = new Education();
    education.setName("College");
    education.setDegree("Masters");
    education.setGpa("4.0");
    education.setTenure(tenure);
    education.setAddress(address);

    ToStringUtil.assertToStringContains(education.toString(),
        "JANUARY", "1983",
        "FEBRUARY", "1984",
        "135 String St.", "Apt. 22b", "Portland", "OR", "Some Oregon Zip",
        "College", "Masters", "4.0");
  }

}

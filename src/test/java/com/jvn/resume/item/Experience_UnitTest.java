package com.jvn.resume.item;

import com.google.common.collect.ImmutableList;
import com.jvn.resume.date.DateRange;
import com.jvn.resume.date.SimpleDate;
import java.time.Month;
import org.testng.annotations.Test;
import test.util.ToStringUtil;

public class Experience_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    SimpleDate startDate = SimpleDate.builder().month(Month.APRIL).year(1989).build();
    SimpleDate endDate = SimpleDate.builder().month(Month.DECEMBER).year(2010).build();
    DateRange tenure = DateRange.builder().startDate(startDate).endDate(endDate).build();

    Address address = Address.builder()
        .street("Street")
        .build();

    Experience experience = new Experience();
    experience.setTitle("President");
    experience.setTenure(tenure);
    experience.setCompany("Google");
    experience.setAddress(address);
    experience.setHighlights(ImmutableList.of("H1", "H2"));
    experience.setTechnologyUsed(ImmutableList.of("T1"));

    ToStringUtil.assertToStringContains(experience.toString(),
        "APRIL", "1989",
        "DECEMBER", "2010",
        "Street",
        "President", "Google", "H1", "H2", "T1"
    );
  }

}

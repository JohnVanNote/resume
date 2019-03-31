package com.jvn.resume.date;

import java.time.Month;
import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class DateRange_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    SimpleDate startDate = new SimpleDate();
    startDate.setMonth(Month.APRIL);
    startDate.setYear(1990);

    SimpleDate endDate = new SimpleDate();
    endDate.setMonth(Month.MARCH);
    endDate.setYear(2019);

    DateRange range = new DateRange();
    range.setStartDate(startDate);
    range.setEndDate(endDate);

    ToStringUtil.assertToStringContains(range.toString(),
        "APRIL", "1990", "MARCH", "2019");
  }

}

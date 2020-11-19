package com.jvn.resume.date;

import java.time.Month;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class SimpleData_UnitTest {

  private static final SimpleDate DATE = new SimpleDate();

  static {
    DATE.setMonth(Month.AUGUST);
    DATE.setYear(1980);
  }

  @Test
  public void readable_AllFields_PrintsReadableDate() {
    Assert.assertEquals(DATE.readable(), "Aug. 1980");
  }

  @Test
  public void toString_AnyState_PrintsFields() {
    ToStringUtil.assertToStringContains(DATE.toString(), "AUGUST", "1980");
  }

}

package com.jvn.resume.model;

import com.jvn.test.util.ToStringUtil;
import org.testng.annotations.Test;

public class ContactInformation_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    ContactInformation section = ContactInformation.builder()
        .address(Address.builder().street("Street").build())
        .email("gmail")
        .firstName("Jim")
        .lastName("Jeff")
        .webpage("internet.com").build();
    ToStringUtil.assertToStringContains(section.toString(), "Street", "gmail", "Jim", "Jeff", "internet.com");
  }

}

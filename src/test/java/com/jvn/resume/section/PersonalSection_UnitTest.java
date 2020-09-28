package com.jvn.resume.section;

import com.jvn.resume.item.Address;
import com.jvn.test.util.ToStringUtil;
import org.testng.annotations.Test;

public class PersonalSection_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    PersonalSection section = new PersonalSection();
    section.setAddress(Address.builder().street("Street").build());
    section.setEmail("gmail");
    section.setFirstName("Jim");
    section.setLastName("Jeff");
    section.setWebsite("internet.com");

    ToStringUtil.assertToStringContains(section.toString(), "Street", "gmail", "Jim", "Jeff", "internet.com");
  }

}

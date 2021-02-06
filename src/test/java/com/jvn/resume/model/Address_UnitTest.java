package com.jvn.resume.model;

import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class Address_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    Address address = new Address();
    address.setStreet("123 Blue Street");
    address.setAptNumber("Apt. 456");
    address.setCity("Red City");
    address.setState("Yellow State");
    address.setZip("98765");

    ToStringUtil.assertToStringContains(address.toString(), "123 Blue Street", "Apt. 456", "Red City", "Yellow State", "98765");
  }

}

package com.jvn.resume.section;

import com.google.common.collect.ImmutableList;
import com.jvn.resume.item.Education;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class EducationSection_UnitTest {

  @Test
  public void getTitle_AnyState_IsEducation() {
    EducationSection section = new EducationSection();
    Assert.assertEquals(section.getTitle(), "Education");
  }

  @Test
  public void toString_AnyState_PrintsFields() {
    Education school1 = Education.builder().degree("Degree").build();
    Education school2 = Education.builder().gpa("11.0").build();

    EducationSection section = new EducationSection();
    section.setSchools(ImmutableList.of(school1, school2));

    ToStringUtil.assertToStringContains(section.toString(), "Degree", "11.0", "Education");
  }

}

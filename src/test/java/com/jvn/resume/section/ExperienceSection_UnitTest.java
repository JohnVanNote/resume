package com.jvn.resume.section;

import com.google.common.collect.ImmutableList;
import com.jvn.resume.item.Experience;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class ExperienceSection_UnitTest {

  @Test
  public void getTitle_AnyState_IsExperience() {
    ExperienceSection section = new ExperienceSection();
    Assert.assertEquals(section.getTitle(), "Experience");
  }

  @Test
  public void toString_AnyState_PrintsFields() {
    Experience exp1 = Experience.builder().title("King").build();
    Experience exp2 = Experience.builder().company("Westeros").build();

    ExperienceSection section = new ExperienceSection();
    section.setExperiences(ImmutableList.of(exp1, exp2));

    ToStringUtil.assertToStringContains(section.toString(), "King", "Westeros", "Experience");
  }

}

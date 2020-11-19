package com.jvn.resume.item;

import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;
import com.jvn.test.util.ToStringUtil;

public class ToolSet_UnitTest {

  @Test
  public void toString_AnyState_PrintsFields() {
    ToolSet toolSet = new ToolSet();
    toolSet.setLabel("Label");
    toolSet.setTools(ImmutableList.of("T1", "T2", "T3"));

    ToStringUtil.assertToStringContains(toolSet.toString(), "Label", "T1", "T2", "T3");
  }

}

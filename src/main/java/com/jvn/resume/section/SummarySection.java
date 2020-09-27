package com.jvn.resume.section;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SummarySection extends AbstractTitledSection {

  private String summary;
  public static final String TITLE = "Summary";

  @Override
  public String getTitle() {
    return TITLE;
  }

}

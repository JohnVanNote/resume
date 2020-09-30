package com.jvn.resume.section;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ProjectSection extends AbstractTitledSection {

  private List<String> projects;
  public static final String TITLE = "Personal Projects";

  public String getTitle() {
    return TITLE;
  }

}

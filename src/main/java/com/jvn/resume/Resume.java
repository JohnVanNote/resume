package com.jvn.resume;

import com.jvn.resume.section.EducationSection;
import com.jvn.resume.section.ExperienceSection;
import com.jvn.resume.section.PersonalSection;
import com.jvn.resume.section.ProjectSection;
import com.jvn.resume.section.SummarySection;
import com.jvn.resume.section.TechnicalSection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
@NoArgsConstructor
public class Resume {

  private PersonalSection personalSection;
  private SummarySection summarySection;
  private ProjectSection projectSection;
  private ExperienceSection experienceSection;
  private EducationSection educationSection;
  private TechnicalSection technicalSection;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

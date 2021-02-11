package com.jvn.resume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {

  private String title;
  private List<Section> subSections;
  private List<EducationEntry> educationEntries;
  private List<EmploymentEntry> employmentEntries;
  private List<Item> items;

}

package com.jvn.resume.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
public class DescriptionItem {

  private String content;
  private List<DescriptionItem> descriptionItems;

  @Override
  public String toString() {
      return reflectionToString(this);
  }

}

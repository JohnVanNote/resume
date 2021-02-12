package com.jvn.resume.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
public class Description {

  private String content;
  private List<DescriptionItem> descriptionItems;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

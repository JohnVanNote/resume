package com.jvn.resume.model.date;

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
public class Duration {

  private SimpleDate startDate;
  private SimpleDate endDate;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

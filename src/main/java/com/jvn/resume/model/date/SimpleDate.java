package com.jvn.resume.model.date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Month;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

@AllArgsConstructor
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Setter
public class SimpleDate {

  private Integer year;
  private Month month;

  public String readable() {
    return String.format("%s. %d", StringUtils.left(StringUtils.capitalize(StringUtils.lowerCase(month.toString())), 3), year);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

package com.jvn.resume.model.date;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.left;
import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Month;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
      return format("%s. %d", left(capitalize(lowerCase(month.toString())), 3), year);
  }

  @Override
  public String toString() {
      return reflectionToString(this);
  }

}

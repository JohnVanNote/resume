package com.jvn.resume.section;

import com.jvn.resume.item.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonalSection extends AbstractSection {

  private String firstName;
  private String lastName;
  private Address address;
  private String phoneNumber;
  private String email;
  private String website;

}

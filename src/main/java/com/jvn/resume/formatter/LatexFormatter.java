package com.jvn.resume.formatter;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import com.jvn.resume.model.AbstractEntry;
import com.jvn.resume.model.Address;
import com.jvn.resume.model.ContactInformation;
import com.jvn.resume.model.EducationEntry;
import com.jvn.resume.model.EmploymentEntry;
import com.jvn.resume.model.Resume;
import com.jvn.resume.model.Section;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LatexFormatter implements Formatter {

  private final Theme theme;
  private final FontSize fontSize;
  private final FontFamily fontFamily;
  private final PaperSize paperSize;
  private final Color color;
  private double margin = 0.75;

  private static final String LS = System.lineSeparator();
  private static final String TAB = "  ";

  @Override
  public String format(Resume resume) {
    StringBuilder format = new StringBuilder();
    format.append("%% start of file").append(LS);
    format.append(LS);
    format.append(topFormatting());
    format.append(LS);
    format.append(contactFormatting(resume));
    format.append(LS);
    format.append("\\begin{document}").append(LS);
    format.append(LS);
    format.append("\\makecvtitle").append(LS);
    format.append(LS);
    format.append(sectionsFormatting(resume)).append(LS);
    format.append(LS);
    format.append("\\end{document}").append(LS);
    format.append("%% end of file");
    return format.toString();
  }

  private String topFormatting() {
    String formattingOptions = String.join(",", fontSize.getName(), paperSize.getName(), fontFamily.getName());

    StringBuilder format = new StringBuilder();
    format.append("\\documentclass[").append(formattingOptions).append("]{moderncv}").append(LS);
    format.append(LS);
    format.append("\\moderncvstyle{").append(theme.getName()).append("}").append(LS);
    format.append(LS);
    format.append("\\moderncvcolor{").append(color.getName()).append("}").append(LS);
    format.append(LS);
    format.append("\\nopagenumbers{}").append(LS);
    format.append(LS);
    format.append("\\usepackage[utf8]{inputenc}").append(LS);
    format.append(LS);
    format.append("\\usepackage[scale=").append(margin).append("]{geometry}").append(LS);

    return format.toString();
  }

  private String contactFormatting(Resume resume) {
    ContactInformation contactInfo = resume.getContactInformation();
    String firstName = contactInfo.getFirstName();
    String lastName = contactInfo.getLastName();
    String title = contactInfo.getTitle();
    Address address = contactInfo.getAddress();
    String phoneNumber = contactInfo.getPhoneNumber();
    String email = contactInfo.getEmail();
    String webpage = contactInfo.getWebpage();

    StringBuilder format = new StringBuilder();
    format.append("\\name{").append(firstName).append("}{").append(lastName).append("}").append(LS);
    if (isNotEmpty(title)) {
      format.append("\\title{").append(title).append("}").append(LS);
    }
    format.append(formatAddress(address)).append(LS);
    format.append("\\phone[mobile]{").append(phoneNumber).append("}").append(LS);
    format.append("\\email{").append(email).append("}").append(LS);
    format.append("\\homepage{").append(webpage).append("}").append(LS);

    return format.toString();
  }

  private String formatAddress(Address address) {
    String street = address.getStreet();
    String aptNumber = address.getAptNumber();
    String city = address.getCity();
    String zip = address.getZip();
    String state = address.getState();

    String fullStreet = isNotEmpty(aptNumber) ? street + ", " + aptNumber : street;
    return String.format("\\address{%s}{%s %s}{%s}", fullStreet, city, state, zip);
  }

  private String sectionsFormatting(Resume resume) {
    List<Section> sections = resume.getSections();
    StringBuilder format = new StringBuilder();
    if (sections != null) {
      for (Section section : sections) {
        format.append(sectionFormatting(section));
        format.append(LS);
      }
    }
    return format.toString();
  }

  private String sectionFormatting(Section section) {
    StringBuilder format = new StringBuilder();
    format.append("\\section{").append(section.getTitle()).append("}").append(LS);

    List<EducationEntry> educationEntries = section.getEducationEntries();
    if (educationEntries != null) {
      for (EducationEntry entry : educationEntries) {
        format.append(cvEntryFormat(entry));
      }
    }

    List<EmploymentEntry> employmentEntries = section.getEmploymentEntries();
    if (employmentEntries != null) {
      for (EmploymentEntry employmentEntry : employmentEntries) {
        format.append(cvEntryFormat(employmentEntry));
      }
    }

    format.append(LS);
    return format.toString();
  }

  private String cvEntryFormat(AbstractEntry entry) {
    StringBuilder format = new StringBuilder();
    format.append("\\cventry{")
        .append(entry.getDuration().getStartDate().readable())
        .append(" - ")
        .append(entry.getDuration().getEndDate().readable())
        .append("}{")
        .append(entry.getString1())
        .append("}{")
        .append(entry.getString2())
        .append("}{")
        .append(entry.getString3())
        .append("}{\\textit{")
        .append(entry.getString4())
        .append("}}{")
        .append(entry.getDescription())
        .append("}")
        .append(LS);
    return format.toString();
  }


  @Getter
  public enum FontSize {
    TEN("10pt"),
    ELEVEN("11pt"),
    TWELVE("12pt");

    private String name;

    FontSize(String name) {
      this.name = name;
    }
  }

  @Getter
  public enum FontFamily {
    SANS("sans"),
    ROMAN("roman"),
    MONOSPACED("monospaced");

    private String name;

    FontFamily(String name) {
      this.name = name;
    }
  }

  @Getter
  public enum PaperSize {
    A4("a4paper"),
    A5("a5paper"),
    EXECUTIVE("executivepaper"),
    LANDSCAPE("landscape"),
    LEGAL("legalpaper"),
    LETTER("letterpaper");

    private String name;

    PaperSize(String name) {
      this.name = name;
    }
  }

  @Getter
  public enum Theme {
    CASUAL("casual"),
    CLASSIC("classic"),
    OLDSTYLE("oldstyle"),
    BANKING("banking");

    private String name;

    Theme(String name) {
      this.name = name;
    }
  }

  @Getter
  public enum Color {
    BLUE("blue"),
    ORANGE("orange"),
    GREEN("green"),
    RED("red"),
    PURPLE("purple"),
    GREY("grey"),
    BLACK("black");

    private String name;

    Color(String name) {
      this.name = name;
    }
  }

}

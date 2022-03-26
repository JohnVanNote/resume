package com.jvn.resume.formatter;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import com.jvn.resume.model.AbstractEntry;
import com.jvn.resume.model.Address;
import com.jvn.resume.model.ContactInformation;
import com.jvn.resume.model.Description;
import com.jvn.resume.model.DescriptionItem;
import com.jvn.resume.model.EducationEntry;
import com.jvn.resume.model.EmploymentEntry;
import com.jvn.resume.model.Resume;
import com.jvn.resume.model.Section;
import com.jvn.resume.model.SectionItem;
import com.jvn.resume.model.date.Duration;
import com.jvn.resume.model.date.SimpleDate;
import java.util.List;
import java.util.Objects;
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
    return "" +
        "%% start of file" + LS + LS +
        formatTop() + LS +
        formatContactInformation(resume) + LS +
        "\\begin{document}" + LS + LS +
        "\\makecvtitle" + LS + LS +
        formatSections(resume) + LS + LS +
        "\\end{document}" + LS
        + "%% end of file";

  }

  private String formatTop() {
    final String formattingOptions = String.join(",", fontSize.getName(), paperSize.getName(), fontFamily.getName());

    return "" +
        "\\documentclass[" + formattingOptions + "]{moderncv}" + LS + LS +
        "\\moderncvstyle{" + theme.getName() + "}" + LS + LS +
        "\\moderncvcolor{" + color.getName() + "}" + LS + LS +
        "\\nopagenumbers{}" + LS + LS +
        "\\usepackage[utf8]{inputenc}" + LS + LS +
        "\\usepackage[scale=" + margin + "]{geometry}" + LS;
  }

  private String formatContactInformation(Resume resume) {
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

  private String formatSections(Resume resume) {
    List<Section> sections = resume.getSections();
    StringBuilder format = new StringBuilder();
    if (sections != null) {
      for (Section section : sections) {
        format.append(formatSection(section)).append(LS);
      }
    }
    return format.toString();
  }

  private String formatSection(Section section, boolean isSubSection) {
    StringBuilder format = new StringBuilder();
    if (!isSubSection) {
      format.append("\\section{").append(section.getTitle()).append("}").append(LS);
    } else {
      format.append("\\subsection{").append(section.getTitle()).append("}").append(LS);
    }

    List<EducationEntry> educationEntries = section.getEducationEntries();
    if (educationEntries != null) {
      for (EducationEntry entry : educationEntries) {
        format.append(formatCvEntry(entry));
      }
    }

    List<EmploymentEntry> employmentEntries = section.getEmploymentEntries();
    if (employmentEntries != null) {
      for (EmploymentEntry employmentEntry : employmentEntries) {
        format.append(formatCvEntry(employmentEntry));
      }
    }

    List<SectionItem> sectionItems = section.getSectionItems();
    if (sectionItems != null) {
      for (SectionItem sectionItem : sectionItems) {
        format.append(formatSectionItem(sectionItem));
      }
    }

    List<Section> subsections = section.getSubSections();
    if (subsections != null) {
      for (Section subsection : subsections) {
        format.append(formatSubSection(subsection));
      }
    }

    return format.toString();
  }

  private String formatSection(Section section) {
    return formatSection(section, false);
  }

  private String formatSubSection(Section section) {
    return formatSection(section, true);
  }

  private String formatCvEntry(AbstractEntry entry) {
    Duration duration = entry.getDuration();
    SimpleDate startDate = duration.getStartDate();
    SimpleDate endDate = duration.getEndDate();
    String string1 = Objects.toString(entry.getString1(), "");
    String string2 = Objects.toString(entry.getString2(), "");
    String string3 = Objects.toString(entry.getString3(), "");
    String string4 = Objects.toString(entry.getString4(), "");
    Description description = entry.getDescription();

    StringBuilder format = new StringBuilder();
    format.append("\\cventry{")
        .append(startDate.readable())
        .append(" - ")
        .append(endDate.readable())
        .append("}{")
        .append(string1)
        .append("}{")
        .append(string2)
        .append("}{")
        .append(string3)
        .append("}")
        .append("{");
    if (isNotEmpty(string4)) {
      format.append("\\textit{")
          .append(string4)
          .append("}");
    }
    format.append("}{");

    if (description != null) {
      String content = description.getContent();
      List<DescriptionItem> descriptionItems = description.getDescriptionItems();
      format.append(content).append("%").append(LS);
      format.append(formatDescriptionItems(descriptionItems));
    }

    format.append("}");
    format.append(LS);
    return format.toString();
  }

  private String formatSectionItem(SectionItem sectionItem) {
    StringBuilder format = new StringBuilder();
    format.append("\\cvitem{").append(sectionItem.getKey()).append("}");
    String valueStr = String.format("{%s}", sectionItem.getValue());
    if (sectionItem.isEmphasis()) {
      format.append("{\\emph").append(valueStr).append("}");
    } else {
      format.append(valueStr);
    }
    format.append(LS);
    return format.toString();
  }

  private String formatDescriptionItems(List<DescriptionItem> descriptionItems) {
    StringBuilder format = new StringBuilder();
    if (descriptionItems != null && !descriptionItems.isEmpty()) {
      format.append("\\begin{itemize}%").append(LS);
      for (DescriptionItem item : descriptionItems) {
        String content = item.getContent();
        List<DescriptionItem> subDescriptionItems = item.getDescriptionItems();
        format.append("\\item ").append(content).append(LS);
        format.append(formatDescriptionItems(subDescriptionItems));
      }
      format.append("\\end{itemize}").append(LS);
    }
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

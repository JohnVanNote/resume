package com.jvn.resume;

import com.jvn.resume.model.Resume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LatexResume {

  private Theme theme;
  private FontSize fontSize;
  private FontFamily fontFamily;
  private PaperSize paperSize;
  private Color color;

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

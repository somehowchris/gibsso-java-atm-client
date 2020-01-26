package services;

public class NumberPadService {

  private StringBuilder builder;

  public NumberPadService() {
    this.reset();
  }

  public void reset() {
    builder = new StringBuilder();
  }

  public void append(String text) {
    builder.append(text);
  }

  public String getString() {
    return builder.toString();
  }

}

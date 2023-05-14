package topic.Sports;

public class Futbol extends Sports {
  private static int frequency = 0;

  public Futbol(String name) {
    super(name);
    this.setCategory("Futbol");
    this.setParentCategory("Sports");
  }

  public int getFrequency() {
    return frequency;
  }

  @Override
  public void incrementFrequency() {
    super.incrementFrequency();
    frequency++;
  }
}

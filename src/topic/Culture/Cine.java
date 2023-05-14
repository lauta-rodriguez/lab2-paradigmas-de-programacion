package topic.Culture;

public class Cine extends Culture {
  private static int frequency = 0;

  public Cine(String name) {
    super(name);
    this.setCategory("Cine");
    this.setParentCategory("Culture");
    frequency++;
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

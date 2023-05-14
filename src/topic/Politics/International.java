package topic.Politics;

public class International extends Politics {
  private static int frequency = 0;

  public International(String name) {
    super(name);
    this.setCategory("International");
    this.setParentCategory("Politics");
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

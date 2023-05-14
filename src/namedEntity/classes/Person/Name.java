package namedEntity.classes.Person;

public class Name extends Person {

  private String canonicalForm;
  private String origin;
  private String[] variants;

  private static int frequency = 0;

  public Name(String name, String category) {
    super(name, category);
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

  public String getCanonicalForm() {
    return canonicalForm;
  }

  public void setCanonicalForm(String canonicalForm) {
    this.canonicalForm = canonicalForm;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String[] getVariants() {
    return variants;
  }

  public void setVariants(String[] variants) {
    this.variants = variants;
  }

  @Override
  public void prettyPrint() {
    System.out.println("Person Name: " + this.getName() + " " + this.getFrequency());
  }
}
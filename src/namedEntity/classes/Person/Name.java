package namedEntity.classes.Person;

public class Name extends Person {

  private String canonicalForm;
  private String origin;
  private String[] variants;

  public Name(String name, String category, int frequency) {
    super(name, category, frequency);
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

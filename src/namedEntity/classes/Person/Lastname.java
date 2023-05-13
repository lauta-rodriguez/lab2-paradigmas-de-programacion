package namedEntity.classes.Person;

public class Lastname extends Person {

  private String canonicalForm;
  private String origin;

  public Lastname(String name, String category, int frequency) {
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

  @Override
  public void prettyPrint() {
    System.out.println("Person Lastname: " + this.getName() + " " + this.getFrequency());
  }
}

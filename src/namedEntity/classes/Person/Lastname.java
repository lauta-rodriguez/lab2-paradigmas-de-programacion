package namedEntity.classes.Person;

public class Lastname extends Person {

  private String canonicalForm;
  private String origin;

  private static int frequency = 0;

  public Lastname(String name, String category) {
    super(name, category);
    frequency++;
  }

  public static int getFrequency() {
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

  @Override
  public void prettyPrint() {
    System.out.println("Person Lastname: " + this.getName() + " " + getFrequency());
  }

  public String StringifyObject() {
		return ("[" + this.getName() + ": (" + this.getCategory() + ", " + getFrequency() + ") ");
	}
}

package namedEntity.classes.Organization;

public class Organization extends namedEntity.NamedEntity {
  private String canonicalForm;
  private int members;
  private String type;

  private static int frequency = 0;

  public Organization(String name, String category) {
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

  public int getMembers() {
    return members;
  }

  public void setMembers(int members) {
    this.members = members;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
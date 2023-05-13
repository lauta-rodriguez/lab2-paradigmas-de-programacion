package namedEntity.classes.Organization;

public class Organization extends namedEntity.NamedEntity {
  private String canonicalForm;
  private int members;
  private String type;

  public Organization(String name, String category, int frequency) {
    super(name, category, frequency);
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

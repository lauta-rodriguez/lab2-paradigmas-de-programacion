package namedEntity.classes.CDate;

public class CDate extends namedEntity.NamedEntity {

  // precisa, forma canónica
  private java.util.Date precise;
  private String canonicalForm;

  public CDate(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public java.util.Date getPrecise() {
    return precise;
  }

  public void setPrecise(java.util.Date precise) {
    this.precise = precise;
  }

  public String getCanonicalForm() {
    return canonicalForm;
  }

  public void setCanonicalForm(String canonicalForm) {
    this.canonicalForm = canonicalForm;
  }

}

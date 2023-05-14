package namedEntity.classes.Person;

public class Title extends Person {

  private String canonicForm;
  private String professional;

  private static int frequency = 0;

  public Title(String name, String category) {
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

  public String getCanonicForm() {
    return canonicForm;
  }

  public void setCanonicForm(String canonicForm) {
    this.canonicForm = canonicForm;
  }

  public String getProfessional() {
    return professional;
  }

  public void setProfessional(String professional) {
    this.professional = professional;
  }

  @Override
  public void prettyPrint() {
    System.out.println("Person Title: " + this.getName() + " " + getFrequency());
  }
}

package namedEntity.classes.Person;

public class Title extends Person {

  private String canonicForm;
  private String professional;

  public Title(String name, String category, int frequency) {
    super(name, category, frequency);
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
    System.out.println("Person Title: " + this.getName() + " " + this.getFrequency());
  }
}

package namedEntity.classes.Person;

import namedEntity.NamedEntity;

public class Person extends NamedEntity {

  protected String id = "ID PERSON";

  public Person(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public void prettyPrint() {
    System.out.println("Person: " + this.getName() + " " + this.getFrequency());
  }
}

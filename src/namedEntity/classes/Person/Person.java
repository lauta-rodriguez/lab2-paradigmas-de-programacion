package namedEntity.classes.Person;

import namedEntity.NamedEntity;

public class Person extends NamedEntity {

  protected String id = "ID PERSON";

  private static int frequency = 0;

  public Person(String name, String category) {
    super(name, category);
    frequency++;
    System.out.println(name + category);
  }

  public static int getFrequency() {
    return frequency;
  }

  @Override
  public void incrementFrequency() {
    super.incrementFrequency();
    frequency++;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public void prettyPrint() {
    System.out.println("Person: " + this.getName() + " " + getFrequency());
  }
}

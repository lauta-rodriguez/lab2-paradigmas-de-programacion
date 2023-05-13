package namedEntity.classes.Place;

public class Place extends namedEntity.NamedEntity {

  private String id;
  
  public Place(String name, String category, int frequency) {
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
    System.out.println("Lugar: " + this.getName() + " " + this.getFrequency());
  }
}

package namedEntity.classes.Place;

public class Place extends namedEntity.NamedEntity {

  private String id;

  private static int frequency = 0;

  public Place(String name, String category) {
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public void prettyPrint() {
    System.out.println("Lugar: " + this.getName() + " " + getFrequency());
  }
}

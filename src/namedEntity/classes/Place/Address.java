package namedEntity.classes.Place;

public class Address extends Place {

  private String city;

  public Address(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}

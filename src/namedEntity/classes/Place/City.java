package namedEntity.classes.Place;

public class City extends Place {

  private int population;
  private String capital;
  private String country;

  public City(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}

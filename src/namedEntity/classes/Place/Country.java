package namedEntity.classes.Place;

public class Country extends Place {

  private int population;
  private String oficialLanguage;

  public Country(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public String getOficialLanguage() {
    return oficialLanguage;
  }

  public void setOficialLanguage(String oficialLanguage) {
    this.oficialLanguage = oficialLanguage;
  }
}

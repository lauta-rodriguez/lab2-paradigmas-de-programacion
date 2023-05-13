package topic.Sports;

public class Futbol extends Sports {

  public Futbol(String name) {
    super(name);
    this.setCategory("Futbol");
    this.setParentCategory("Sports");
  }
}

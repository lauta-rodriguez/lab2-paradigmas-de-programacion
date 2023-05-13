package namedEntity.classes.Product;

public class Product extends namedEntity.NamedEntity {
  private String comercial;
  private String productor;

  public Product(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public String getComercial() {
    return comercial;
  }

  public void setComercial(String comercial) {
    this.comercial = comercial;
  }

  public String getProductor() {
    return productor;
  }

  public void setProductor(String productor) {
    this.productor = productor;
  }
}

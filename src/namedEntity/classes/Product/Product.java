package namedEntity.classes.Product;

public class Product extends namedEntity.NamedEntity {
  private String comercial;
  private String productor;

  private static int frequency = 0;

  public Product(String name, String category) {
    super(name, category);
    frequency++;
  }

  public int getFrequency() {
    return frequency;
  }

  @Override
  public void incrementFrequency() {
    super.incrementFrequency();
    frequency++;
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
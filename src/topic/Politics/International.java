package topic.Politics;

public class International extends Politics {

  public International(String name) {
    super(name);
    this.setCategory("International");
    this.setParentCategory("Politics");
  }
}

package topic.Politics;

public class National extends Politics {

  public National(String name) {
    super(name);
    this.setCategory("National");
    this.setParentCategory("Politics");
  }
}

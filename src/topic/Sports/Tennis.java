package topic.Sports;

public class Tennis extends Sports {

  public Tennis(String name) {
    super(name);
    this.setCategory("Tennis");
    this.setParentCategory("Sports");
  }

}

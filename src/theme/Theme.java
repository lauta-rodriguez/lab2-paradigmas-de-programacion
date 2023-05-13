package theme;

public class Theme {
  private String name = "-";
  private String category = "Otros";
  private String parentCategory = "-";

  public Theme(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String getCategory() {
    return this.category;
  }

  protected void setCategory(String category) {
    this.category = category;
  }

  public String getParentCategory() {
    return this.parentCategory;
  }

  protected void setParentCategory(String parentCategory) {
    this.parentCategory = parentCategory;
  }

  public String StringifyObject() {
    return "[Theme " + this.getParentCategory() + " " + this.getCategory() + " " + this.getName() + "]";
  }

  public static void main(String[] args) {
    Theme theme = new Theme("name");
    System.out.println(theme.StringifyObject());
  }

}

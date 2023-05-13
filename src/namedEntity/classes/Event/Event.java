package namedEntity.classes.Event;

import java.util.Date;

public class Event extends namedEntity.NamedEntity {

  // forma canónica, fecha, recurrente
  private String canonicalForm;
  private Date date;
  private boolean recurrent;

  public Event(String name, String category, int frequency) {
    super(name, category, frequency);
  }

  public String getCanonicalForm() {
    return canonicalForm;
  }

  public void setCanonicalForm(String canonicalForm) {
    this.canonicalForm = canonicalForm;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean isRecurrent() {
    return recurrent;
  }

  public void setRecurrent(boolean recurrent) {
    this.recurrent = recurrent;
  }

}

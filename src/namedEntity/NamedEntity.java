package namedEntity;

import theme.Theme;

/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
	String name;
	String category;
	int frequency;

	Theme theme;

	public NamedEntity(String name, String category, int frequency) {
		super();
		this.name = name;
		this.category = category;
		this.frequency = frequency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return name;
	}

	public void setCategory(String name) {
		this.name = name;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void incFrequency() {
		this.frequency++;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "ObjectNamedEntity [name=" + name + ", frequency=" + frequency + "]";
	}

	public void prettyPrint() {
		System.out.println(this.getName() + " " + this.getFrequency());
	}

}

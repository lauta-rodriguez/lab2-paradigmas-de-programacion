package namedEntity;

import topic.Topic;

/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
	String name;
	String category;
	private static int frequency = 0;

	Topic topic;

	public NamedEntity(String name, String category) {
		super();
		this.name = name;
		this.category = category;
		frequency++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	protected void setCategory(String category) {
		this.category = category;
	}

	public static int getFrequency() {
		return frequency;
	}

	public void incrementFrequency() {
		frequency++;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "ObjectNamedEntity [name=" + name + ", frequency=" + frequency + "]";
	}

	public String StringifyObject() {
		return ("[" + this.getName() + ": (" + this.getCategory() + ", " + getFrequency() + ") ");
	}

	public void prettyPrint() {
		System.out.println(this.getName() + " " + getFrequency());
	}

}

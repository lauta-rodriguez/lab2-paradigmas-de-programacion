package namedEntity.heuristic;

import java.util.Map;

public abstract class Heuristic {

	private static Map<String, String[]> categoryMap = Map.of(
			"Microsft", new String[] { "Company", "Other" },
			"Apple", new String[] { "Company", "Other" },
			"Google", new String[] { "Company", "Other" },
			"Musk", new String[] { "Person", "Other" },
			"Biden", new String[] { "Person", "National" },
			"Trump", new String[] { "Person", "National" },
			"Messi", new String[] { "Person", "Futbol" },
			"Federer", new String[] { "Person", "Tennis" },
			"USA", new String[] { "Country", "National" },
			"Russia", new String[] { "Country", "International" });

	public String getCategory(String entity) {
		String[] category = categoryMap.get(entity);

		if (category != null) {
			return category[0];
		}

		return "Other";
	}

	public String getTopic(String entity) {
		String[] category = categoryMap.get(entity);

		if (category != null) {
			return category[1];
		}

		return "Other";
	}

	public abstract boolean isEntity(String word);

}

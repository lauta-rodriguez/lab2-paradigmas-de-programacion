import java.util.List;

import httpRequest.httpRequester;

import feed.Article;
import feed.Feed;

import parser.GeneralParser;
import parser.RedditParser;
import parser.RssParser;
import parser.SubscriptionParser;

import subscription.SingleSubscription;
import subscription.Subscription;

import namedEntity.heuristic.Heuristic;
import namedEntity.heuristic.QuickHeuristic;

public class FeedReaderMain {

	private static void printHelp() {
		System.out.println("Please, call this program in correct way: FeedReader [-ne]");
	}

	public static void main(String[] args) {
		System.out.println("************* FeedReader version 1.0 *************");

		if (args.length > 1) {
			printHelp();
			return;
		}

		httpRequester requester = new httpRequester();

		/* Leer el archivo de suscription por defecto */
		Subscription subscription = new SubscriptionParser()
				.parse("config/subscriptions.json");
		GeneralParser<List<Article>> feedParser = null;
		Heuristic heuristic = null;

		args = new String[] { "-ne" };

		/*
		 * Si se llama al programa sin argumentos, se genera el Feed
		 * Si se llama al programa con el argumento -ne
		 * se genera el Feed y se computan las entidades nombradas
		 */
		boolean ne = args.length == 1 && args[0].equals("-ne");

		if (ne) {
			/* Llamar al constructor de la heuristica */
			heuristic = new QuickHeuristic();
		}

		for (int i = 0; i < subscription.getLength(); i++) {
			SingleSubscription single = subscription.getSingleSubscription(i);

			/*
			 * llamada al Parser especifico para extrar los datos necesarios por la
			 * aplicacion
			 */
			String type = single.getUrlType();
			if (type.equals("rss")) {
				feedParser = new RssParser();
			} else if (type.equals("reddit")) {
				feedParser = new RedditParser();
			} else {
				System.out.println("Error: type of feed not supported");
				continue;
			}

			String rawUrl = single.getUrl();
			for (int j = 0; j < single.getUlrParamsSize(); j++) {
				String url = rawUrl.replace("%s", single.getUlrParams(j));
				/* Llamar al httpRequester para obtener el feed del servidor */
				String data = requester.getFeed(url, type);
				List<Article> articleList = feedParser.parse(data);
				
				/* llamada al constructor de Feed */
				Feed feed = new Feed(url);
				feed.setArticleList(articleList);
	
				if (ne) {
					/*
					 * Llamar a la heuristica para que compute las entidades nombradas de cada
					 * articulos del feed
					 */
					for (int k = 0; k < articleList.size(); k++) {
						try {
							articleList.get(k).computeNamedEntities(heuristic);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					/*
					 * Llamar al prettyPrint de la tabla de entidades nombradas del feed.
					 */
					feed.prettyPrintNamedEntities();
					continue;
				}

				/*
				 * llamada al prettyPrint del Feed para ver los articulos del feed en forma
				 * legible y amigable para el usuario
				 */
				feed.prettyPrint();
			}
		}
	}

}

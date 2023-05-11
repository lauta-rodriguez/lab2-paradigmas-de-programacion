import java.util.List;

import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;
import parser.RedditParser;
import parser.RssParser;
import parser.SubscriptionParser;
import subscription.SingleSubscription;
import subscription.Subscription;

public class FeedReaderMain {

	private static void printHelp() {
		System.out.println("Please, call this program in correct way: FeedReader [-ne]");
	}

	public static void main(String[] args) {
		System.out.println("************* FeedReader version 1.0 *************");
		httpRequester requester = new httpRequester();

		/* Si se llama al programa sin argumentos, se genera el Feed */
		if (args.length == 0) {

			/* Leer el archivo de suscription por defecto */
			Subscription subscription = new SubscriptionParser()
					.parse("/home/lautaro/Desktop/tempJava/repo/config/subscriptions.json");

			/* Llamar al httpRequester para obtener el feed del servidor */
			for (int i = 0; i < subscription.getLength(); i++) {
				SingleSubscription single = subscription.getSingleSubscription(i);
				String type = single.getUrlType();
				String rawUrl = single.getUrl();

				for (int j = 0; j < single.getUlrParamsSize(); j++) {
					String url = rawUrl.replace("%s", single.getUlrParams(j));
					String data = requester.getFeed(url, type);

					/*
					 * llamada al Parser especifico para extrar los datos necesarios por la
					 * aplicacion
					 */
					if (type.equals("rss")) {

						/* llamada al parser de rss */
						List<Article> articleList = new RssParser().parse(data);

						/* llamada al constructor de Feed */
						Feed feed = new Feed(url);
						feed.setArticleList(articleList);

						/*
						 * llamada al prettyPrint del Feed para ver los articulos del feed en forma
						 * legible y amigable para el usuario
						 */
						feed.prettyPrint();
					} else if (type.equals("reddit")) {

						/* llamada al parser de reddit */
						List<Article> articleList = new RedditParser().parse(data);

						/* llamada al constructor de Feed */
						Feed feed = new Feed(url);
						feed.setArticleList(articleList);
						feed.prettyPrint();
					} else {
						System.out.println("Error: type of feed not supported");
					}
				}
			}

		}
		/*
		 * Si se llama al programa con el argumento -ne
		 * se genera el Feed y se computan las entidades nombradas
		 */
		else if (args.length == 1) {
			/*
			 * Leer el archivo de suscription por defecto;
			 * Llamar al httpRequester para obtener el feed del servidor
			 * Llamar al Parser especifico para extrar los datos necesarios por la
			 * aplicacion
			 * Llamar al constructor de Feed
			 * Llamar a la heuristica para que compute las entidades nombradas de cada
			 * articulos del feed
			 * LLamar al prettyPrint de la tabla de entidades nombradas del feed.
			 */

		} else {
			printHelp();
		}
	}

}

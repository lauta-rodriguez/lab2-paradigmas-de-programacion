import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;
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
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

		if (args.length == 0) {

			/* Leer el archivo de suscription por defecto; */
			Subscription subscription = new SubscriptionParser().parse("config/subscriptions.json");

			/* Llamar al httpRequester para obtenr el feed del servidor */
			for (int i = 0; i < subscription.getLength(); i++) {
				SingleSubscription single = subscription.getSingleSubscription(i);
				String type = single.getUrlType();
				String rawUrl = single.getUrl();

				for (int j = 0; j < single.getUlrParamsSize(); j++) {
					String url = rawUrl.replace("%s", single.getUlrParams(j));
					String data = requester.getFeed(url, type);

					/*
					* Llamar al Parser especifico para extrar los datos necesarios por la
					* aplicacion
					*/
					if (type.equals("rss")) {
						Document xml = new RssParser().parse(data);

						/* Llamar al constructor de Feed */
						Feed feed = new Feed(url);

						NodeList items = xml.getElementsByTagName("item");
						for (int k = 0; k < items.getLength(); k++) {
							String title = xml.getElementsByTagName("title").item(k).getTextContent();
							String description = xml.getElementsByTagName("description").item(k).getTextContent();
							String link = xml.getElementsByTagName("link").item(k).getTextContent();
							String pubDate = xml.getElementsByTagName("pubDate").item(k).getTextContent();
							Date date = null;

							try {
								date = dateFormatter.parse(pubDate);
							} catch (Exception e) {
								System.out.println("Error: date format not supported");
							}

							Article article = new Article(title, description, date, link);
							feed.addArticle(article);
						}

						/*
						 * LLamar al prettyPrint del Feed para ver los articulos del feed en forma
						 * legible y amigable para el usuario
						 */
						feed.prettyPrint();
					} else {
						System.out.println("Error: type of feed not supported");
					}
				}
			}

		} else if (args.length == 1) {

			/*
			 * Leer el archivo de suscription por defecto;
			 * Llamar al httpRequester para obtenr el feed del servidor
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

package feed;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import namedEntity.NamedEntity;
import namedEntity.classes.Organization.Organization;
import namedEntity.classes.Event.Event;
import namedEntity.classes.Person.Lastname;
import namedEntity.classes.Person.Name;
import namedEntity.classes.Person.Title;
import namedEntity.classes.Place.City;
import namedEntity.classes.Place.Address;
import namedEntity.classes.Place.Place;
import namedEntity.classes.Place.Country;
import namedEntity.classes.Product.Product;
import namedEntity.classes.CDate.CDate;
import namedEntity.heuristic.Heuristic;
import theme.Theme;
import theme.Culture.Cine;
import theme.Culture.Culture;
import theme.Culture.Music;
import theme.Politics.International;
import theme.Politics.National;
import theme.Politics.Politics;
import theme.Sports.Basket;
import theme.Sports.F1;
import theme.Sports.Futbol;
import theme.Sports.Sports;
import theme.Sports.Tennis;

/*Esta clase modela el contenido de un articulo (ie, un item en el caso del rss feed) */

public class Article {
	private String title;
	private String text;
	private Date publicationDate;
	private String link;

	private List<NamedEntity> namedEntityList = new ArrayList<NamedEntity>();

	public Article(String title, String text, Date publicationDate, String link) {
		super();
		this.title = title;
		this.text = text;
		this.publicationDate = publicationDate;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", text=" + text + ", publicationDate=" + publicationDate + ", link=" + link
				+ "]";
	}

	public NamedEntity getNamedEntity(String namedEntity) {
		for (NamedEntity n : namedEntityList) {
			if (n.getName().compareTo(namedEntity) == 0) {
				return n;
			}
		}
		return null;
	}

	// God bleds stupid code. I'm sorry.
	private NamedEntity generateNamedEntity(String namedEntity, String category)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		NamedEntity ne = null;
		Class<?> action = null;

		// Personas
		if (category == "Apellido") {
			action = Lastname.class;
		} else if (category == "Nombre") {
			action = Name.class;
		} else if (category == "Titulo") {
			action = Title.class;
		}
		// Lugares
		else if (category == "Lugar") {
			action = Place.class;
		} else if (category == "Ciudad") {
			action = City.class;
		} else if (category == "Pais") {
			action = Country.class;
		} else if (category == "Direccion") {
			action = Address.class;
		}
		// Organizacion
		else if (category == "Organizacion") {
			action = Organization.class;
		}
		// Producto
		else if (category == "Producto") {
			action = Product.class;
		}
		// Evento
		else if (category == "Evento") {
			action = Event.class;
		}
		// Fecha
		else if (category == "Fecha") {
			action = CDate.class;
		} else {
			action = NamedEntity.class;
		}

		ne = (NamedEntity) action.getDeclaredConstructor(String.class, String.class, int.class).newInstance(namedEntity,
				category, 1);

		return ne;
	}

	private Theme generateTheme(String theme)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		Theme t = null;
		Class<?> action = null;

		if (theme == "Culture") {
			action = Culture.class;
		} else if (theme == "Cine") {
			action = Cine.class;
		} else if (theme == "Music") {
			action = Music.class;
		} else if (theme == "Politics") {
			action = Politics.class;
		} else if (theme == "International") {
			action = International.class;
		} else if (theme == "National") {
			action = National.class;
		} else if (theme == "Sports") {
			action = Sports.class;
		} else if (theme == "Futbol") {
			action = Futbol.class;
		} else if (theme == "Basket") {
			action = Basket.class;
		} else if (theme == "Tennis") {
			action = Tennis.class;
		} else if (theme == "F1") {
			action = F1.class;
		} else {
			action = Theme.class;
		}

		t = (Theme) action.getDeclaredConstructor(String.class).newInstance(theme);
		return t;
	}

	public void computeNamedEntities(Heuristic h)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, ClassNotFoundException {
		String text = this.getTitle() + " " + this.getText();

		String charsToRemove = ".,;:()'!?\n";
		for (char c : charsToRemove.toCharArray()) {
			text = text.replace(String.valueOf(c), "");
		}

		for (String s : text.split(" ")) {
			if (h.isEntity(s)) {
				NamedEntity ne = this.getNamedEntity(s);

				if (ne == null) {
					ne = this.generateNamedEntity(s, h.getCategory(s));

					Theme t = this.generateTheme(h.getTheme(s));
					ne.setTheme(t);

					this.namedEntityList.add(ne);
				} else {
					ne.incFrequency();
				}
			}
		}
	}

	public void prettyPrint() {
		System.out
				.println("**********************************************************************************************");
		System.out.println("Title: " + this.getTitle());
		System.out.println("Publication Date: " + this.getPublicationDate());
		System.out.println("Link: " + this.getLink());
		System.out.println("Text: " + this.getText());
		System.out
				.println("**********************************************************************************************");

	}

	public void prettyPrintNamedEntities() {
		System.out
				.println("**********************************************************************************************");
		for (NamedEntity n : this.namedEntityList) {
			n.prettyPrint();
		}
	}

	public static void main(String[] args) {
		Article a = new Article("This Historically Black University Created Its Own Tech Intern Pipeline",
				"A new program at Bowie State connects computing students directly with companies, bypassing an often harsh Silicon Valley vetting process",
				new Date(),
				"https://www.nytimes.com/2023/04/05/technology/bowie-hbcu-tech-intern-pipeline.html");

		a.prettyPrint();
	}

}

# Laboratorio 2: Programación Orientada a Objetos

## Integrantes:

### Grupo 22:

- Lara Kurtz, lara.kurtz@mi.unc.edu.ar
- Gonzalo Bordon, gonzalobordon02@mi.unc.edu.ar
- Lautaro Rodríguez, lautaro.rodriguez@mi.unc.edu.ar

# Requisitos:

```shell
sudo apt install openjdk-11-jdk
```

# Como agregar/quitar suscripciones

Para agregar o quitar una suscripción en el Feed, se debe modificar el archivo `config/subscriptions.json`.

El programa permite leer artículos de Reddit y de RSS. Para agregar una suscripción de RSS, se debe agregar un objeto que contenga los siguientes campos:

```json
{
  "url": "https://rss.nytimes.com/services/xml/rss/nyt/%s.xml",
  "urlParams": ["Business", "Technology"],
  "urlType": "rss"
}
```

Y para leer posts de Reddit, se debe agregar un objeto con los siguientes campos:

```jsonartículos
{
  "url": "https://www.reddit.com/r/%s.json",
  "urlParams": ["programming"],
  "urlType": "reddit"
}
```

# Ejecución

### Como correr el programa

Para leer el Feed y mostrar los artículos, se debe ejecutar el programa sin argumentos:

```shell
FeedReaderMain
```

Para computar un conjunto de entidades nombradas mediante una heurística en cada artículo, se debe ejecutar el programa con el argumento `-ne`:

```shell
FeedReaderMain -ne
```

# Parte 1: Construcción de un lector de feeds

Para obtener los artículos de las distintas fuentes declaramos un parser genérico que recibe un string y devuelve un objeto de tipo T.

`GeneralParser.java`

```java
public abstract T parse(String data);
```

Primero obtenemos un objeto Subscription que contiene un conjunto de SingleSubscriptions (las suscripciones individuales) que se utilizan para obtener los artículos de cada fuente mediante pedidos HTTP.

`SubscriptionParser.java`

```java
@param path el path del archivo subscriptions.json
public Subscription parse(String path)
```

Luego, si el tipo de la suscripción es RSS, se crea un objeto RSSParser que hereda también de GeneralParser y se utiliza para parsear el string que contiene el XML de la fuente RSS.

Esta clase devuelve una lista de objetos Article que contienen la información de cada articulo, lista para ser incorporada al Feed y mostrada por pantalla.

`RSSParser.java`

```java
@param data el string que contiene el XML de la fuente RSS
List<Article> parse(String data)
```

### Decisiones de diseño

Los distintos parsers tienen un comportamiento similar, por lo que se decidió crear una clase abstracta GeneralParser que contiene la función `parse` y que es heredada por las clases RSSParser, RedditParser y SubscriptionParser.

En las clases RSSParser y RedditParser encontramos otra similitud, ambas devuelven una lista de objetos Article e internamente implementan las funciones

```java
@param post el nodo que contiene la información del post
private static Article parseArticle(Node post)

@param postJson el JSON que contiene la información del post
private static Article parseArticle(JSONObject postJson)
```

respectivamente, nos pareció conveniente crear una función abstracta `parseArticle` en GeneralParser que es implementada por las clases RSSParser y RedditParser. El inconveniente de esta decision es que la clase SubscriptionParser no utiliza esta función, por lo que se tendria que implementar de manera vacía.

---

### Punto extra: RedditParser

Para parsear los posts de Reddit, se crea un objeto RedditParser que hereda de GeneralParser y se utiliza para parsear el string que contiene el JSON de la fuente Reddit.

Al igual que en RSSParser, esta clase devuelve una lista de objetos Article.

Una vez se obtiene el JSON de la fuente Reddit, se llama a la función `parse` de RedditParser y se le pasa el string que contiene el JSON.

Internamente, se crea un objeto JSONObject que contiene el JSON de la fuente Reddit y se itera sobre los posts del mismo, extrayendo la información de cada uno de ellos creando un objeto Article por cada post.

`RedditParser.java`

```java
@param data el string que contiene el JSON de la fuente Reddit
public List<Article> parse(String data)
```

# Parte 2: Identificación y clasificación de entidades nombradas

Analizamos cada artículo del Feed y computamos un conjunto de entidades nombradas mediante una heurística en cada uno de ellos.

Para modelar las entidades nombradas utilizamos una clase NamedEntity que contiene **nombre**, **categoría** y **categoría madre**.

Clasificamos a las entidades nombradas según dos jerarquías, una que representa la categorización básica de las entidades nombradas y
otra que a cada entidad nombrada la relaciona con un tema (Topic).

Mostramos por pantalla el nombre de la entidad nombrada y dos tuplas que se corresponden con la primera y segunda jerarquía respectivamente, acompañadas de la cantidad de veces que aparece cada subclase (que representa el último nivel en su respectiva jerarquía) en el Feed.

| Nombre     | Jerarquia basica |     Tema     |
| ---------- | :--------------: | :----------: |
| Week:      |   (Otros, 591)   | (Otros, 591) |
| Trump:     |  (Lastname, 10)  | (Otros, 591) |
| TV:        |   (Otros, 591)   | (Otros, 591) |
| Inflation: |   (Otros, 591)   | (Otros, 591) |
| Elon:      |   (Otros, 591)   | (Otros, 591) |
| Musk:      |    (Name, 4)     | (Otros, 591) |
| CEO:       |   (Otros, 591)   | (Otros, 591) |
| Twitter:   |   (Otros, 591)   | (Otros, 591) |
| Senate:    |   (Otros, 591)   | (Otros, 591) |

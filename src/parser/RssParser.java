package parser;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/* Esta clase implementa el parser de feed de tipo rss (xml)
 * https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm 
 * */

public class RssParser extends GeneralParser {

  public Document parse(String data) {
    //Parser that produces DOM object trees from XML content
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try {
      //Create DocumentBuilder with default configuration
      DocumentBuilder builder = factory.newDocumentBuilder();

      //Parse the content to Document object
      return builder.parse(new InputSource(new StringReader(data)));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e);
    }

    return null;
  }
}

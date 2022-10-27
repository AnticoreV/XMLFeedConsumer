package XML;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class XMLParser {
    public void parse(String path) {
        try {
            Reader fileReader = new FileReader(path);
            XMLInputFactory xmlInputFactory =
                    XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader =
                    xmlInputFactory.createXMLStreamReader(fileReader);
            while (xmlStreamReader.hasNext()) {
                //Get integer value of current event.
                int xmlEvent = xmlStreamReader.next();

                //Process start element.
                if (xmlEvent == XMLStreamConstants.START_ELEMENT) {
                    System.out.println("Start Element: "
                            + xmlStreamReader.getLocalName());
                }
                if (xmlEvent == XMLStreamConstants.END_ELEMENT) {
                    System.out.println("End Element: "
                            +xmlStreamReader.getLocalName());
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

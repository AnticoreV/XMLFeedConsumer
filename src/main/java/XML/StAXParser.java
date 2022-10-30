package XML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class StAXParser {
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

                switch (xmlEvent){
                    case XMLStreamConstants.START_ELEMENT -> {
                        System.out.println("Start Element: " + xmlStreamReader.getLocalName());
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        System.out.println("Content: " + xmlStreamReader.getText());
                        break;
                    }
                    case XMLStreamConstants.ATTRIBUTE -> {
                        System.out.println("Attribute: " + xmlStreamReader.getAttributeValue(xmlEvent));
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT -> {
                        System.out.println("Last Element: " + xmlStreamReader.getLocalName());
                        break;
                    }
                    default -> System.out.println("Default");
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package XML;

import model.Content;
import model.Element;
import model.XMLStorage;
import service.ContentService;
import service.ElementService;

import javax.xml.stream.XMLInputFactory;
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
//            XMLStorage xmlStorage = new XMLStorage();
            Element element = new Element();
            Content content = new Content();
            ElementService elementService = new ElementService();
            ContentService contentService = new ContentService();
            while (xmlStreamReader.hasNext()) {
                //Get integer value of current event
                xmlStreamReader.next();
                if(xmlStreamReader.isStartElement()){
//                    xmlStorage.getFirst_el().add(xmlStreamReader.getLocalName());
                        element.setFirst_el(xmlStreamReader.getLocalName());
                        elementService.save(element);
                } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 0) {
//                    xmlStorage.getContent().add(xmlStreamReader.getText());
                    content.setContent(xmlStreamReader.getText());
                    contentService.save(content);
                } else if (xmlStreamReader.isEndElement()) {
//                    xmlStorage.getSecond_el().add(xmlStreamReader.getLocalName());
                    element.setSecond_el(xmlStreamReader.getLocalName());
                    elementService.save(element);
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

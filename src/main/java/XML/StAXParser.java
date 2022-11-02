package XML;

import model.Content;
import model.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ContentService;
import service.ElementService;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class StAXParser {
    private static final Logger log = LoggerFactory.getLogger(StAXParser.class);
    public void parse(String path) {
        try {
            Reader fileReader = new FileReader(path);
            XMLInputFactory xmlInputFactory =
                    XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader =
                    xmlInputFactory.createXMLStreamReader(fileReader);
            ElementService elementService = new ElementService();
            ContentService contentService = new ContentService();
            int index = 1;
            int iter = 1;
            int iter1 = 1;
            while (xmlStreamReader.hasNext()) {
                Element element = new Element();
                Content content = new Content();
                //Get integer value of current event
                xmlStreamReader.next();
                if(xmlStreamReader.isStartElement()){
                    if(elementService.isEmptyNextIndex(index)){
                        System.out.println("Added first el");
                        element.setFirst_el(xmlStreamReader.getLocalName());
                        element.setSecond_el("empty");
                        elementService.save(element);
                        index++;
                    }
                    else if (elementService.getElement(iter).getFirst_el().equals(xmlStreamReader.getLocalName())) {
                        System.out.println("FIRST EQUALS " + xmlStreamReader.getLocalName());
                        iter++;
                    }
                    else{
                        System.out.println("NEW");
                    }
                } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 1) {
                    if(contentService.isEmptyNextIndex(index)){
                        System.out.println("Added el");
                        content.setContent(xmlStreamReader.getText());
                        contentService.save(content);
                        index++;
                    }
                    else if (contentService.getContent(iter1).getContent().equals(xmlStreamReader.getText())) {
                        System.out.println("ELE EQUALS " + xmlStreamReader.getText());
                        iter1++;
                    }
                    else{
                        System.out.println("NEW");
                    }
                } else if (xmlStreamReader.isEndElement()) {
                    if(elementService.isEmptyNextIndex(index)){
                        System.out.println("Added second el");
                        element.setSecond_el(xmlStreamReader.getLocalName());
                        element.setFirst_el("empty");
                        elementService.save(element);
                        index++;
                    }
                    else if (elementService.getElement(iter).getSecond_el().equals(xmlStreamReader.getLocalName())) {
                        System.out.println("SECOND EQUALS " + xmlStreamReader.getLocalName());
                        iter++;
                    }
                    else{
                        System.out.println("NEW");
                    }
                }
                else{

                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

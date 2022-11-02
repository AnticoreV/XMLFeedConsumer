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
            int element_iter = 1;
            int content_iter = 1;
            while (xmlStreamReader.hasNext()) {
                Element element = new Element();
                Content content = new Content();
                //Get integer value of current event
                xmlStreamReader.next();

                if(xmlStreamReader.isStartElement()){
                    if(elementService.isEmptyNextIndex(index)){
                        element.setFirst_el(xmlStreamReader.getLocalName());
                        element.setSecond_el("empty");
                        elementService.save(element);
                        index++;
                        log.info("Start Element added: " + xmlStreamReader.getLocalName());
                    }
                    else if (elementService.getElement(element_iter).getFirst_el().equals(xmlStreamReader.getLocalName())) {
                        log.warn("Start Element: " + xmlStreamReader.getLocalName() + " is already exists");
                        element_iter++;
                    }
                    else{
                        element.setFirst_el(xmlStreamReader.getLocalName());
                        element.setSecond_el("empty");
                        elementService.save(element);
                        index++;
                        log.info("New Start Element added: " + xmlStreamReader.getLocalName());
                    }

                } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 1) {
                    if(contentService.isEmptyNextIndex(index)){
                        content.setContent(xmlStreamReader.getText());
                        contentService.save(content);
                        index++;
                        log.info("Content added: " + xmlStreamReader.getText());
                    }
                    else if (contentService.getContent(content_iter).getContent().equals(xmlStreamReader.getText())) {
                        log.warn("Content: " + xmlStreamReader.getText() + " is already exists");
                        content_iter++;
                    }
                    else{
                        content.setContent(xmlStreamReader.getText());
                        contentService.save(content);
                        index++;
                        log.info("New Content added: " + xmlStreamReader.getText());
                    }
                }

                else if (xmlStreamReader.isEndElement()) {
                    if(elementService.isEmptyNextIndex(index)){
                        element.setSecond_el(xmlStreamReader.getLocalName());
                        element.setFirst_el("empty");
                        elementService.save(element);
                        index++;
                        log.info("End Element added: " + xmlStreamReader.getLocalName());
                    }
                    else if (elementService.getElement(element_iter).getSecond_el().equals(xmlStreamReader.getLocalName())) {
                        log.warn("End Element: " + xmlStreamReader.getLocalName() + " is already exists");
                        element_iter++;
                    }
                    else{
                        element.setSecond_el(xmlStreamReader.getLocalName());
                        element.setFirst_el("empty");
                        elementService.save(element);
                        index++;
                        log.info("New End Element added: " + xmlStreamReader.getLocalName());
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

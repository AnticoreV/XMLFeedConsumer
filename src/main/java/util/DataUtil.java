package util;

import model.Content;
import model.Element;
import org.slf4j.Logger;
import service.ContentService;
import service.ElementService;

import javax.xml.stream.XMLStreamReader;

public class DataUtil {
    private int index = 1;
    private int element_iter = 1;
    private int content_iter = 1;
    private ElementService elementService = new ElementService();
    private ContentService contentService = new ContentService();

    public void startElementProcessing(XMLStreamReader xmlStreamReader, Logger log){
        Element element = new Element();
        if(elementService.isEmptyNextIndex(index)){
            addStartElementToDB(xmlStreamReader, element);
            index++;
            log.info("Start Element added: " + xmlStreamReader.getLocalName());
        }
        else if (elementService.getElement(element_iter).getFirst_el().equals(xmlStreamReader.getLocalName())) {
            log.warn("Start Element: " + xmlStreamReader.getLocalName() + " is already exists");
            element_iter++;
        }
        else{
            addStartElementToDB(xmlStreamReader, element);
            index++;
            log.info("New Start Element added: " + xmlStreamReader.getLocalName());
        }
    }

    private void addStartElementToDB(XMLStreamReader xmlStreamReader, Element element) {
        element.setFirst_el(xmlStreamReader.getLocalName());
        element.setSecond_el("empty");
        elementService.save(element);
    }

    public void contentProcessing(XMLStreamReader xmlStreamReader, Logger log){
        Content content = new Content();
        if(contentService.isEmptyNextIndex(index)){
            addContentToDB(xmlStreamReader, content);
            index++;
            log.info("Content added: " + xmlStreamReader.getText());
        }
        else if (contentService.getContent(content_iter).getContent().equals(xmlStreamReader.getText())) {
            log.warn("Content: " + xmlStreamReader.getText() + " is already exists");
            content_iter++;
        }
        else{
            addContentToDB(xmlStreamReader, content);
            index++;
            log.info("New Content added: " + xmlStreamReader.getText());
        }
    }

    private void addContentToDB(XMLStreamReader xmlStreamReader, Content content) {
        content.setContent(xmlStreamReader.getText());
        contentService.save(content);
    }

    public void lastElementProcessing(XMLStreamReader xmlStreamReader, Logger log){
        Element element = new Element();
        if(elementService.isEmptyNextIndex(index)){
            addSecondElementToDB(xmlStreamReader, element);
            index++;
            log.info("End Element added: " + xmlStreamReader.getLocalName());
        }
        else if (elementService.getElement(element_iter).getSecond_el().equals(xmlStreamReader.getLocalName())) {
            log.warn("End Element: " + xmlStreamReader.getLocalName() + " is already exists");
            element_iter++;
        }
        else{
            addSecondElementToDB(xmlStreamReader, element);
            index++;
            log.info("New End Element added: " + xmlStreamReader.getLocalName());
        }
    }

    private void addSecondElementToDB(XMLStreamReader xmlStreamReader, Element element) {
        element.setSecond_el(xmlStreamReader.getLocalName());
        element.setFirst_el("empty");
        elementService.save(element);
    }
}

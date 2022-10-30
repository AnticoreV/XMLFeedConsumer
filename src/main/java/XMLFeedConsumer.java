import XML.INIReader;
import model.Content;
import model.Element;
import service.ElementService;



public class XMLFeedConsumer {
    public static void main(String[] args) {
        String outputPath = "/Users/ivansapronov/Desktop/XMLFeedConsumer/src/main/resources/output.xml";
        String configPath = args[0];
        INIReader iniReader = INIReader.getINIReader();
        iniReader.setPath(configPath);


        ElementService elementService = new ElementService();
        Element element = new Element();
        element.setFirst_el("GGG");
        element.setSecond_el("TTT");
        elementService.save(element);
        Content content = new Content();
        content.setContent("hjreih");
        element.setContent(content);
        elementService.update(element);
    }
}

import XML.FileSaver;
import XML.URLReader;
import XML.XMLParser;
import model.Element;
import service.ElementService;

public class XMLFeedConsumer {
    public static void main(String[] args) {
//        String outputPath = "/Users/ivansapronov/Desktop/XMLFeedConsumer/src/main/resources/output.xml";
//        String configPath = args[0];
//        URLReader urlReader = new URLReader(configPath);
//        String url = urlReader.getUrl();

//        FileSaver fileSaver = new FileSaver(outputPath);
//        fileSaver.download(url);

//        XMLParser xmlParser = new XMLParser();
//        xmlParser.parse(outputPath);
        ElementService elementService = new ElementService();
        Element element = new Element();
        element.setFirst_el("yrwif");
        element.setSecond_el("rbhefhuifer");
        elementService.save(element);
    }
}

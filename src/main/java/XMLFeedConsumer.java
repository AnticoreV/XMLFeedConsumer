import XML.FileSaver;
import XML.URLReader;
import XML.XMLParser;

public class XMLFeedConsumer {
    public static void main(String[] args) {
        String outputPath = "/Users/ivansapronov/Desktop/XMLFeedConsumer/src/main/resources/output.xml";
        String configPath = args[0];
        URLReader urlReader = new URLReader(configPath);
        String url = urlReader.getUrl();

//        FileSaver fileSaver = new FileSaver(outputPath);
//        fileSaver.download(url);

        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(outputPath);
    }
}

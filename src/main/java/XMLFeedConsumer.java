import XML.FileSaver;
import XML.URLReader;
public class XMLFeedConsumer {
    public static void main(String[] args) {
        String outputPath = "/Users/ivansapronov/Desktop/XMLFeedConsumer/src/main/resources/output.txt";
        String configPath = args[0];
        URLReader urlReader = new URLReader(configPath);
        String url = urlReader.getUrl();

        FileSaver fileSaver = new FileSaver(outputPath);
        fileSaver.download(url);
    }
}

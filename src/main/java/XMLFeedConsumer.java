import XML.INIReader;
import XML.StAXParser;


public class XMLFeedConsumer {
    public static void main(String[] args) {
        //output path is for file_saver to download file and save it to output path as xml file
        String outputPath = "/Users/ivansapronov/Desktop/XMLFeedConsumer/pom.xml";

        String configPath = args[0];
        INIReader iniReader = INIReader.getINIReader();
        iniReader.setPath(configPath);

        StAXParser stAXParser = new StAXParser();
        stAXParser.parse(outputPath);


    }
}

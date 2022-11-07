package sapronov;


import sapronov.xml.INIReader;
import sapronov.xml.StAXParser;

public class XMLFeedConsumer {
    public static void main(String[] args) {
        //output path is for file_saver to download file and save it to output path as xml file
        String outputPath = "/Users/ivansapronov/Desktop/XMLFeedConsumer/src/main/resources/output.xml";

        String configPath = args[0];
        INIReader iniReader = INIReader.getINIReader();
        iniReader.setPath(configPath);

//        FileSaver fileSaver = new FileSaver(outputPath);
//        fileSaver.download(iniReader.getIniData().get(0));

        StAXParser stAXParser = new StAXParser();
        stAXParser.parse(outputPath);
    }
}

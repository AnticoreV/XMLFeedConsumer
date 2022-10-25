import XML.URLReader;

public class XMLFeedConsumer {
    public static void main(String[] args) {
        URLReader urlReader = new URLReader(args[0]);
        System.out.println(urlReader.getUrl());
    }
}

package XML;

import java.io.FileReader;
import java.io.IOException;


//Read URL from file
public class URLReader {
    private StringBuilder url = new StringBuilder();
    private String path;

    //Get a path to config file
    public URLReader(String path) {
        this.path = path;
    }
    public URLReader(){}
    public void setPath(String path) {
        this.path = path;
    }

    //Get a URL from config file
    private void readUrl(String path){
        try(FileReader reader = new FileReader(path)) {
            int c;
            while((c=reader.read())!=-1){
                url.append((char)c);
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Get method
    public String getUrl() {
        this.readUrl(path);
        return url.toString();
    }
}

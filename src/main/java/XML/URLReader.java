package XML;

import java.io.FileReader;
import java.io.IOException;

public class URLReader {
    private StringBuilder url = new StringBuilder();

    private String path;

    public String getUrl() {
        this.readUrl(path);
        return url.toString();
    }

    public URLReader(String path) {
        this.path = path;
    }

    private void readUrl(String path){
        try(FileReader reader = new FileReader(path))
        {
            int c;
            while((c=reader.read())!=-1){
                url.append((char)c);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

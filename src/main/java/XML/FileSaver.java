package XML;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class FileSaver {
    private String path;

    public FileSaver(String path) {
        this.path = path;
    }

    public void download(String url){
        try{
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream out = new FileOutputStream(path);
            byte [] data_arr = new byte[1024];
            int count;
            while((count = in.read(data_arr, 0, 1024)) != -1){
                out.write(data_arr, 0, count);
                out.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

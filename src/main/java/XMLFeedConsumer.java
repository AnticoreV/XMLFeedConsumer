import java.io.FileReader;
import java.io.IOException;

public class XMLFeedConsumer {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader(args[0]))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

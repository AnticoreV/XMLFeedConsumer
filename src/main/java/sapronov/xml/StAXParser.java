package sapronov.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sapronov.util.DataUtil;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class StAXParser {
    private static final Logger log = LoggerFactory.getLogger(StAXParser.class);
    public void parse(String path) {
        try {
            Reader fileReader = new FileReader(path);
            XMLInputFactory xmlInputFactory =
                    XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader =
                    xmlInputFactory.createXMLStreamReader(fileReader);
            DataUtil dataUtil = new DataUtil();
            while (xmlStreamReader.hasNext()) {
                //Get integer value of current event
                xmlStreamReader.next();

                if(xmlStreamReader.isStartElement()){
                    final int attributeCount = xmlStreamReader.getAttributeCount();
                    dataUtil.startElementProcessing(xmlStreamReader, log);
                    dataUtil.attributeProcessing(attributeCount,xmlStreamReader,log);
                }
                else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 1) {
                    dataUtil.contentProcessing(xmlStreamReader, log);
                }
                else if (xmlStreamReader.isEndElement()) {
                    dataUtil.lastElementProcessing(xmlStreamReader, log);
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

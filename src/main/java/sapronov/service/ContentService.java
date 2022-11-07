package sapronov.service;


import sapronov.dao.XMLDaoImpl;
import sapronov.model.Content;

public class ContentService {
    private XMLDaoImpl xml = new XMLDaoImpl();
    public void save(Content data){xml.save(data);}
    public void update(Content data){xml.update(data);}
    public Content getContent(int id){return xml.getContentBy(id);}
    public boolean isEmptyNextIndex(int id){return xml.isEmptyNextIndex(id);}
}

package service;

import dao.XMLDaoImpl;
import model.Content;

public class ContentService {
    private XMLDaoImpl xml = new XMLDaoImpl();
    public void save(Content data){xml.save(data);}
    public void update(Content data){xml.update(data);}
}

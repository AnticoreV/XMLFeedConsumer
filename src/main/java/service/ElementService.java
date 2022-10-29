package service;

import dao.XMLDaoImpl;
import model.Element;

public class ElementService {
    private XMLDaoImpl xml = new XMLDaoImpl();
    public void save(Element el){xml.save(el);}
}

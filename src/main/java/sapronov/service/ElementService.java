package sapronov.service;

import sapronov.dao.XMLDaoImpl;
import sapronov.model.Element;

public class ElementService {
    private XMLDaoImpl xml = new XMLDaoImpl();
    public void save(Element el){xml.save(el);}
    public void update(Element el){xml.update(el);}
    public Element getElement(int id){return xml.getElementBy(id);}
    public boolean isEmptyNextIndex(int id){return xml.isEmptyNextIndex(id);}
}

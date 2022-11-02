package dao;

import model.Content;
import model.Element;

public interface XMLDao {
    void save(Element element);
    void update(Element element);
    void update(Content content);
    void save(Content content);
    Element getElementBy(int id);
    Content getContentBy(int id);
    boolean isEmptyNextIndex(int id);
}

package sapronov.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sapronov.model.Content;
import sapronov.model.Element;
import sapronov.util.HibernateUtil;


import java.util.List;

public class XMLDaoImpl implements XMLDao{
    public void save(Element element) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(element);
        tx1.commit();
        session.close();
    }
    public void update(Element element) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(element);
        tx1.commit();
        session.close();
    }
    public void save(Content content){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(content);
        tx1.commit();
        session.close();}
    public void update(Content content) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(content);
        tx1.commit();
        session.close();
    }
    public Element getElementBy(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Element.class, id);
    }
    public Content getContentBy(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Content.class, id);
    }
    public boolean isEmptyNextIndex(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "SELECT COUNT(id) AS Number FROM Element";
        Query query = session.createQuery(hql);
        List<Integer> list = query.list();
        if(Integer.parseInt(String.valueOf(list.get(0))) > id){
            return false;
        }
        return true;
    }
}

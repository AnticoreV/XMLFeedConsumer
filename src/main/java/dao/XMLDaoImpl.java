package dao;

import model.Element;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class XMLDaoImpl implements XMLDao{
    public void save(Element element) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(element);
        tx1.commit();
        session.close();
    }
}

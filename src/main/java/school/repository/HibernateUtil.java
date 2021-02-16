package school.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil<E> {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected List<E> findAll(String namedQuery) {
        Query query = getSession().createNamedQuery(namedQuery);
        List<E> list = query.getResultList();
        return list;
    }

    protected E findById(String namedQuery, int id) {
        Query query = getSession().createNamedQuery(namedQuery);
        query.setParameter("id", id);
        E e = (E) query.getSingleResult();
        return e;
    }

    public void delete(Class<E> type, int id) {
        session = getSession();
        E e = session.find(type, id);
        session.remove(e);
    }

    protected E save(E entity) {
        session = getSession();
        session.saveOrUpdate(entity);
        return entity;
    }

}

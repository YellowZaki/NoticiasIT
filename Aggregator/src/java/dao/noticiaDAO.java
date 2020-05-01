package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Noticia;

/**
 *
 * @author Alberto
 */
public class noticiaDAO {

    Session sesion = null;

    public Noticia getNoticia(String id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia where id_noticia='" + id + "'");
        Noticia n = (Noticia) q.uniqueResult();
        tx.commit();
        return n;
    }
    
    public List<Noticia> getAllNoticias() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia");
        List<Noticia> ln = (List<Noticia>) q.list();
        tx.commit();
        return ln;
    } 
    
    
}

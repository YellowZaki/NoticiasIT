package dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Comentario;
import pojos.Noticia;
import pojos.Usuario;

/**
 *
 * @author Alberto
 */
public class comentarioDAO {

    Session sesion = null;


    public void addComentario(Noticia noticia, Usuario usuario, String texto) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Comentario comment = new Comentario(noticia, usuario, new Date(), texto);
        
        Transaction tx = sesion.beginTransaction();
        sesion.save(comment);
        tx.commit();
        sesion.close();
    }

    public Comentario getComentario(String id_comentario) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Comentario where id_comentario='" + id_comentario + "'");
        Comentario n = (Comentario) q.uniqueResult();
        tx.commit();
        sesion.close();
        return n;
    }

    public void borrarComentario(Comentario coment) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(coment);
        tx.commit();
        sesion.close();
    }

    public void updateComentario(Comentario comentario) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(comentario);
        tx.commit();
        
        
        sesion.close();
    }

    

}

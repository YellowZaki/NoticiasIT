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

    Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();


    public void addComentario(Noticia noticia, Usuario usuario, String texto) {
        Comentario comment = new Comentario(noticia, usuario, new Date(), texto);
        
        Transaction tx = sesion.beginTransaction();
        sesion.save(comment);
        tx.commit();
    }

    public Comentario getComentario(String id_comentario) {
        
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Comentario where id_comentario='" + id_comentario + "'");
        Comentario n = (Comentario) q.uniqueResult();
        tx.commit();
        return n;
    }

    public void borrarComentario(Comentario coment) {
        
        Transaction tx = sesion.beginTransaction();
        sesion.delete(coment);
        tx.commit();
    }

    

}

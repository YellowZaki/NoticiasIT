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
        Comentario comment = new Comentario(noticia, usuario, new Date(), texto);
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(comment);
        tx.commit();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Noticia;
import pojos.Personalizacion;
import pojos.Usuario;

/**
 *
 * @author juani_000
 */
public class usuarioDAO {

    Session sesion = null;

    public Usuario getUsuario(String usuario) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + usuario + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        sesion.close();
        return u;
    }

    public void modificarUsuario(Usuario u, Personalizacion p) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();

        sesion.update(p);
        sesion.update(u);

        tx.commit();
        sesion.close();
    }

    public void eliminarUsuario(Usuario u) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        noticiaDAO ndao = new noticiaDAO();
        for (Noticia noticia : (Set<Noticia>)u.getNoticias()) {
            ndao.borrarNoticia(noticia);
        }
        
        Personalizacion p = u.getPersonalizacion();
        sesion.delete(p);
        sesion.delete(u);

        tx.commit();
        sesion.close();
    }
}

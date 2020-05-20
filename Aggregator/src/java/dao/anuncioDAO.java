/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Anuncio;

/**
 *
 * @author hecto
 */
public class anuncioDAO {
    Session sesion = HibernateUtil.getSessionFactory().openSession();

    public Anuncio getAnuncio(String link) {
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio where link='" + link + "'");
        Anuncio t = (Anuncio) q.uniqueResult();
        tx.commit();
        return t;
    }

    public List<Anuncio> getAllanuncios() {
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio");
        List<Anuncio> ln = (List<Anuncio>) q.list();
        tx.commit();
        return ln;
    }

    public void addAnuncio(Anuncio anuncio) {
        Transaction tx = sesion.beginTransaction();
        sesion.save(anuncio);
        tx.commit();
    }

    public void updateAnuncio(Anuncio anuncio) {
        Transaction tx = sesion.beginTransaction();
        sesion.update(anuncio);
        tx.commit();
        
    }

    public void borrarAnuncio(Anuncio anuncio) {
        Transaction tx = sesion.beginTransaction();
        sesion.delete(anuncio);
        tx.commit();
    }
}

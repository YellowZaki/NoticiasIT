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

    Session sesion = null;

    public Anuncio getAnuncio(String link) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio where link='" + link + "'");
        Anuncio t = (Anuncio) q.uniqueResult();
        tx.commit();
        sesion.close();
        return t;
    }

    public List<Anuncio> getAllanuncios() {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio");
        List<Anuncio> ln = (List<Anuncio>) q.list();
        tx.commit();
        sesion.close();
        return ln;
    }

    public void addAnuncio(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(anuncio);
        tx.commit();
        sesion.close();
    }

    public void updateAnuncio(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(anuncio);
        tx.commit();
        sesion.close();
    }

    public void borrarAnuncio(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(anuncio);
        tx.commit();
        sesion.close();
    }

    public List<Anuncio> getAnunciosTema(String tema) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio where nombre_tema='" + tema + "'");
        List<Anuncio> anunciosTema = q.list();
        tx.commit();
        sesion.close();
        return anunciosTema;
    }
}

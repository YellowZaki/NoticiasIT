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
import pojos.Tema;

/**
 *
 * @author hecto
 */
public class temaDAO {

    Session sesion = null;

    public Tema getTema(String tema) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Tema where nombre_tema='" + tema + "'");
        Tema t = (Tema) q.uniqueResult();
        tx.commit();
        sesion.close();
        return t;
    }

    public List<Tema> getAllTemas() {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Tema");
        List<Tema> ln = (List<Tema>) q.list();
        tx.commit();
        sesion.close();
        return ln;
    }

    public void addTema(Tema tema) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(tema);
        tx.commit();
        sesion.close();
    }

    public void updateTema(Tema tema) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(tema);
        tx.commit();
        sesion.close();
    }

    public void borrarTema(Tema tema) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(tema);
        tx.commit();
        sesion.close();
    }
}

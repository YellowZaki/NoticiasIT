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

    Session sesion = HibernateUtil.getSessionFactory().openSession();

    public Tema getTema(String tema) {
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Tema where nombre_tema='" + tema + "'");
        Tema t = (Tema) q.uniqueResult();
        tx.commit();
        return t;
    }

    public List<Tema> getAllTemas() {
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Tema");
        List<Tema> ln = (List<Tema>) q.list();
        tx.commit();
        return ln;
    }

    public void addTema(Tema tema) {
        Transaction tx = sesion.beginTransaction();
        sesion.save(tema);
        tx.commit();
    }

    public void updateTema(Tema tema) {
        Transaction tx = sesion.beginTransaction();
        sesion.update(tema);
        tx.commit();
        
    }

    public void borrarTema(Tema tema) {
        Transaction tx = sesion.beginTransaction();
        sesion.delete(tema);
        tx.commit();
    }
}

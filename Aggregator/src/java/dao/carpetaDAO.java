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
import pojos.Carpeta;

/**
 *
 * @author juani_000
 */
public class carpetaDAO {
    Session sesion = null;

    public Carpeta getCarpeta(String nombre_carpeta, String nombre_usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where nombre_carpeta='" + nombre_carpeta + "' and nombre_usuario='" + nombre_usuario + "'");
        Carpeta c = (Carpeta) q.uniqueResult();
        tx.commit();
        return c;
    }
    
    public List<Carpeta> getAllCarpetas(String nombre_usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where nombre_usuario='" + nombre_usuario + "'");
        List<Carpeta> ln = (List<Carpeta>) q.list();
        tx.commit();
        return ln;
    } 
    
    public void borrarCarpeta(String nombre_carpeta, String nombre_usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete From Carpeta where nombre_carpeta='" + nombre_carpeta + "' and nombre_usuario='" + nombre_usuario + "'");
        q.executeUpdate();
        tx.commit();
    }
}
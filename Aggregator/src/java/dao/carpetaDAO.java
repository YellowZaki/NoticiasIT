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
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where nombre_carpeta='" + nombre_carpeta + "' and usuario='" + nombre_usuario + "'");
        Carpeta c = (Carpeta) q.uniqueResult();
        tx.commit();
        sesion.close();
        return c;
    }
    
    public List<Carpeta> getAllCarpetas(String nombre_usuario) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where usuario='" + nombre_usuario + "'");
        List<Carpeta> ln = (List<Carpeta>) q.list();
        tx.commit();
        sesion.close();
        return ln;
    } 
    
    public void borrarCarpeta(String nombre_carpeta, String nombre_usuario) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete From Carpeta where nombre_carpeta='" + nombre_carpeta + "' and usuario='" + nombre_usuario + "'");
        q.executeUpdate();
        tx.commit();
        sesion.close();
    }
    
    public void addCarpeta(Carpeta carpeta) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(carpeta);
        tx.commit();
        sesion.close();
    }

    public void updateCarpeta(String nombreOriginal, Carpeta carpetaNueva) {
        //Carpeta original = getCarpeta(nombreOriginal, carpetaNueva.getUsuario().getUsuario());
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where nombre_carpeta='" + nombreOriginal + "' and usuario='" + carpetaNueva.getUsuario().getUsuario() + "'");
        Carpeta original = (Carpeta) q.uniqueResult();
        String nombre = carpetaNueva.getNombreCarpeta();
        original.setNombreCarpeta(nombre);
        sesion.update(original);
        tx.commit();
        sesion.close();
        
    }
    
    public void updateCarpeta(Carpeta carpeta) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(carpeta);
        tx.commit();
        sesion.close();
    }
}

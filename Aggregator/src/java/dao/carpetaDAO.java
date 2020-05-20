/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Carpeta;
import pojos.GuardadasEn;
import pojos.Noticia;
 
/**
 *
 * @author juani_000
 */
public class carpetaDAO {
    Session sesion = null;
 
    public Carpeta getCarpeta(String id_carpeta) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where id_carpeta='" + id_carpeta + "'");
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
   
    public void borrarCarpeta(String id_carpeta) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete From GuardadasEn where id_carpeta=" + id_carpeta + "");
        q.executeUpdate();
        q = sesion.createQuery("delete From Carpeta where id_carpeta=" + id_carpeta + "");
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
 
    public void updateCarpeta(String id_carpeta, Carpeta carpetaNueva) {
        //Carpeta original = getCarpeta(nombreOriginal, carpetaNueva.getUsuario().getUsuario());
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Carpeta where id_carpeta=" + id_carpeta + "");
        Carpeta original = (Carpeta) q.uniqueResult();
        String nombre = carpetaNueva.getNombreCarpeta();
        original.setNombreCarpeta(nombre);
        sesion.update(original);
        tx.commit();
        sesion.close();
       
    }
   
    public void updateRelacionCarpeta(GuardadasEn relacion) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(relacion);
        tx.commit();
        sesion.close();
    }
    
    public List<GuardadasEn> getNoticiasCarpeta(String id_carpeta){
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From GuardadasEn where id_carpeta=" + id_carpeta + "");
        List<GuardadasEn> lista = (List<GuardadasEn>) q.list();              
        tx.commit();
        sesion.close();
        return lista;
    }
}

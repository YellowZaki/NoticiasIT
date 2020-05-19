/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Personalizacion;
import pojos.Usuario;

/**
 *
 * @author juani_000
 */
public class usuarioDAO {
    Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

    public Usuario getUsuario(String usuario) {
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + usuario + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }
    
    public void modificarUsuario(Usuario u, Personalizacion p){
        Transaction tx = sesion.beginTransaction();
        
        sesion.update(p);
        sesion.update(u);
        
        tx.commit();
    }
    
    public void eliminarUsuario(Usuario u){
        Transaction tx = sesion.beginTransaction();
        
        Query q = sesion.createQuery("From Personalizacion where id_usuario='" + u.getUsuario() + "'");
        
        Personalizacion p = (Personalizacion)q.uniqueResult();
        
        sesion.delete(p);
        
        sesion.delete(u);
        
        tx.commit();
    }
}

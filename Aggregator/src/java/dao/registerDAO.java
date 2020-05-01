/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Noticia;
import pojos.Usuario;
import utils.Utils;

/**
 *
 * @author Andrés Manuel
 */
public class registerDAO {
    Session sesion = null;
    
    public String Registrar(String usuario, String email, String clave) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        
        Query q = sesion.createQuery("From Usuario where email='" + email + "'");
        Usuario u = (Usuario)q.uniqueResult();
        String enc = "";
        
        if(u == null){
            q = sesion.createQuery("From Usuario where usuario='" + usuario + "'");
            u = (Usuario)q.uniqueResult();
            
            if(u == null){
                clave = Utils.getHashedPassword(clave);
                
                u = new Usuario(usuario, clave, email, usuario);
                sesion.save(u);
            }else{
                enc = "usuario";
            }
        }else{
            enc = "email";
        }

        tx.commit();
        
        return enc;
    }
}

package dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Noticia;
import pojos.Usuario;
import pojos.Voto;

/**
 *
 * @author Alberto
 */
public class noticiaDAO {

    Session sesion = null;

    public Noticia getNoticia(String id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia where id_noticia='" + id + "'");
        Noticia n = (Noticia) q.uniqueResult();
        tx.commit();
        return n;
    }

    public List<Noticia> getAllNoticias() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia");
        List<Noticia> ln = (List<Noticia>) q.list();
        tx.commit();
        return ln;
    }

    public List<Noticia> getNoticias(String tema) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia where tema = '" + tema + "'");
        List<Noticia> ln = (List<Noticia>) q.list();
        tx.commit();
        return ln;
    }

    public void borrarNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(noticia);
        tx.commit();
    }

    public void addNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(noticia);
        tx.commit();
    }
    
    public void votar(Usuario u, String idNoticia, int valor){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        
        Query q1 = sesion.createQuery("From Noticia where id_noticia='" + idNoticia + "'");

        Noticia not = (Noticia)q1.uniqueResult();

        Set<Voto> lista = not.getVotos_1();
        Voto v = null;
        
        for(Voto voto:lista){
            if(voto.getUsuario() == u){
                v = voto;
            }
        }
        
        if(v == null){
            Voto v1;
            
            if(valor == 1){
                v1 = new Voto(not, u, 1);
            }else{
                v1 = new Voto(not, u, -1);
            }
            
            not.getVotos_1().add(v1);
            sesion.save(v1);
            sesion.update(not);
        }else{
            if(valor == 1 && (v.getValor() == -1)){
                v.setValor(1);
                sesion.update(v);
            }else if(valor == -1 && (v.getValor() == 1)){
                v.setValor(-1);
                sesion.update(v);
            }else if(valor == v.getValor()){
                sesion.delete(v);
            }   
        }
        
        tx.commit();
    }
}

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
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia where id_noticia='" + id + "'");
        Noticia n = (Noticia) q.uniqueResult();
        tx.commit();
        sesion.close();
        return n;
    }

    public List<Noticia> getAllNoticias() {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia");
        List<Noticia> ln = (List<Noticia>) q.list();
        tx.commit();
        sesion.close();
        return ln;
    }

    public List<Noticia> getNoticias(String tema) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Noticia where tema = '" + tema + "'");
        List<Noticia> ln = (List<Noticia>) q.list();
        tx.commit();
        sesion.close();
        return ln;
    }

    public void borrarNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(noticia);
        tx.commit();
        sesion.close();
    }
    
    public void updateNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(noticia);
        tx.commit();
        sesion.close();
    }

    public void addNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(noticia);
        tx.commit();
        sesion.close();
    }
    
    public void votar(Usuario u, String idNoticia, int valor){
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        
        Query q1 = sesion.createQuery("From Noticia where id_noticia='" + idNoticia + "'");

        Noticia not = (Noticia)q1.uniqueResult();

        Set<Voto> lista = not.getVotos();
        Voto v = null;
        
        for(Voto voto:lista){
            if(voto.getUsuario().getUsuario().equals(u.getUsuario())){
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
            
            not.getVotos().add(v1);
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
                not.getVotos().remove(v);
                sesion.delete(v);
                sesion.update(not);
            }   
        }
        
        tx.commit();
        sesion.close();
    }
}

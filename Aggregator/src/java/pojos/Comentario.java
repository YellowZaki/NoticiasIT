package pojos;
// Generated 01-may-2020 13:21:32 by Hibernate Tools 4.3.1



/**
 * Comentario generated by hbm2java
 */
public class Comentario  implements java.io.Serializable {


     private int fechaPublicacion;
     private Noticia noticia;
     private Usuario usuario;
     private String texto;

    public Comentario() {
    }

    public Comentario(int fechaPublicacion, Noticia noticia, Usuario usuario, String texto) {
       this.fechaPublicacion = fechaPublicacion;
       this.noticia = noticia;
       this.usuario = usuario;
       this.texto = texto;
    }
   
    public int getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public Noticia getNoticia() {
        return this.noticia;
    }
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }




}



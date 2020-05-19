package pojos;
// Generated 19-may-2020 19:11:18 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Comentario generated by hbm2java
 */
public class Comentario  implements java.io.Serializable {


     private Integer idComentario;
     private Noticia noticia;
     private Usuario usuario;
     private Date fechaPublicacion;
     private String texto;

    public Comentario() {
    }

    public Comentario(Noticia noticia, Usuario usuario, Date fechaPublicacion, String texto) {
       this.noticia = noticia;
       this.usuario = usuario;
       this.fechaPublicacion = fechaPublicacion;
       this.texto = texto;
    }
   
    public Integer getIdComentario() {
        return this.idComentario;
    }
    
    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
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
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }




}



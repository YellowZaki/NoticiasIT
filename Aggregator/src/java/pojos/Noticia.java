package pojos;
// Generated 19-may-2020 20:01:26 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Noticia generated by hbm2java
 */
public class Noticia  implements java.io.Serializable {


     private Integer idNoticia;
     private Tema tema;
     private Usuario usuario;
     private String titulo;
     private String descripcion;
     private String fuente;
     private Date fechaPublicacion;
     private Set votos = new HashSet(0);
     private Set comentarios = new HashSet(0);
     private Set guardadasEns = new HashSet(0);

    public Noticia() {
    }

	
    public Noticia(Tema tema, Usuario usuario, String titulo, String descripcion, String fuente, Date fechaPublicacion) {
        this.tema = tema;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fuente = fuente;
        this.fechaPublicacion = fechaPublicacion;
    }
    public Noticia(Tema tema, Usuario usuario, String titulo, String descripcion, String fuente, Set votos, Set comentarios, Set guardadasEns,  Date fechaPublicacion) {
       this.tema = tema;
       this.usuario = usuario;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.fuente = fuente;
       this.fechaPublicacion = fechaPublicacion;
       this.votos = votos;
       this.comentarios = comentarios;
       this.guardadasEns = guardadasEns;
    }
   
    public Integer getIdNoticia() {
        return this.idNoticia;
    }
    
    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }
    public Tema getTema() {
        return this.tema;
    }
    
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFuente() {
        return this.fuente;
    }
    
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public Set getVotos() {
        return this.votos;
    }
    
    public void setVotos(Set votos) {
        this.votos = votos;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
    public Set getGuardadasEns() {
        return this.guardadasEns;
    }
    
    public void setGuardadasEns(Set guardadasEns) {
        this.guardadasEns = guardadasEns;
    }




}



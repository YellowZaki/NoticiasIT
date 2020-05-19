package pojos;
// Generated 19-may-2020 19:11:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String usuario;
     private String clave;
     private String email;
     private String rol;
     private Set comentarios = new HashSet(0);
     private Set votos = new HashSet(0);
     private Personalizacion personalizacion;
     private Set carpetas = new HashSet(0);
     private Set noticias = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String usuario, String clave, String email, String rol) {
        this.usuario = usuario;
        this.clave = clave;
        this.email = email;
        this.rol = rol;
    }
    public Usuario(String usuario, String clave, String email, String rol, Set comentarios, Set votos, Personalizacion personalizacion, Set carpetas, Set noticias) {
       this.usuario = usuario;
       this.clave = clave;
       this.email = email;
       this.rol = rol;
       this.comentarios = comentarios;
       this.votos = votos;
       this.personalizacion = personalizacion;
       this.carpetas = carpetas;
       this.noticias = noticias;
    }
   
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
    public Set getVotos() {
        return this.votos;
    }
    
    public void setVotos(Set votos) {
        this.votos = votos;
    }
    public Personalizacion getPersonalizacion() {
        return this.personalizacion;
    }
    
    public void setPersonalizacion(Personalizacion personalizacion) {
        this.personalizacion = personalizacion;
    }
    public Set getCarpetas() {
        return this.carpetas;
    }
    
    public void setCarpetas(Set carpetas) {
        this.carpetas = carpetas;
    }
    public Set getNoticias() {
        return this.noticias;
    }
    
    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }




}



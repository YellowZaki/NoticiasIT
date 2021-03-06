package pojos;
// Generated 19-may-2020 20:01:26 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tema generated by hbm2java
 */
public class Tema  implements java.io.Serializable {


     private String nombreTema;
     private String imagen;
     private Set anuncios = new HashSet(0);
     private Set noticias = new HashSet(0);

    public Tema() {
    }

	
    public Tema(String nombreTema, String imagen) {
        this.nombreTema = nombreTema;
        this.imagen = imagen;
    }
    public Tema(String nombreTema, String imagen, Set anuncios, Set noticias) {
       this.nombreTema = nombreTema;
       this.imagen = imagen;
       this.anuncios = anuncios;
       this.noticias = noticias;
    }
   
    public String getNombreTema() {
        return this.nombreTema;
    }
    
    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Set getAnuncios() {
        return this.anuncios;
    }
    
    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }
    public Set getNoticias() {
        return this.noticias;
    }
    
    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }




}



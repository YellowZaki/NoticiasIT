package pojos;
// Generated 19-may-2020 19:11:18 by Hibernate Tools 4.3.1



/**
 * GuardadasEn generated by hbm2java
 */
public class GuardadasEn  implements java.io.Serializable {


     private GuardadasEnId id;
     private Carpeta carpeta;
     private Noticia noticia;

    public GuardadasEn() {
    }

    public GuardadasEn(GuardadasEnId id, Carpeta carpeta, Noticia noticia) {
       this.id = id;
       this.carpeta = carpeta;
       this.noticia = noticia;
    }
   
    public GuardadasEnId getId() {
        return this.id;
    }
    
    public void setId(GuardadasEnId id) {
        this.id = id;
    }
    public Carpeta getCarpeta() {
        return this.carpeta;
    }
    
    public void setCarpeta(Carpeta carpeta) {
        this.carpeta = carpeta;
    }
    public Noticia getNoticia() {
        return this.noticia;
    }
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }




}



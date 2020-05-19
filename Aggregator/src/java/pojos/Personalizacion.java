package pojos;
// Generated 19-may-2020 19:11:18 by Hibernate Tools 4.3.1



/**
 * Personalizacion generated by hbm2java
 */
public class Personalizacion  implements java.io.Serializable {


     private String idUsuario;
     private Usuario usuario;
     private String colorPrimario;
     private int modoOscuro;
     private int mostrarEncabezado;

    public Personalizacion() {
    }

    public Personalizacion(Usuario usuario, String colorPrimario, int modoOscuro, int mostrarEncabezado) {
       this.usuario = usuario;
       this.colorPrimario = colorPrimario;
       this.modoOscuro = modoOscuro;
       this.mostrarEncabezado = mostrarEncabezado;
    }
   
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getColorPrimario() {
        return this.colorPrimario;
    }
    
    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }
    public int getModoOscuro() {
        return this.modoOscuro;
    }
    
    public void setModoOscuro(int modoOscuro) {
        this.modoOscuro = modoOscuro;
    }
    public int getMostrarEncabezado() {
        return this.mostrarEncabezado;
    }
    
    public void setMostrarEncabezado(int mostrarEncabezado) {
        this.mostrarEncabezado = mostrarEncabezado;
    }




}



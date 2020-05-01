package pojos;
// Generated 01-may-2020 13:21:32 by Hibernate Tools 4.3.1



/**
 * Personalizacion generated by hbm2java
 */
public class Personalizacion  implements java.io.Serializable {


     private String idUsuario;
     private Usuario usuario;
     private int colorPrimario;
     private int modoOscuro;
     private int tipografia;
     private int mostrarEncabezado;

    public Personalizacion() {
    }

    public Personalizacion(Usuario usuario, int colorPrimario, int modoOscuro, int tipografia, int mostrarEncabezado) {
       this.usuario = usuario;
       this.colorPrimario = colorPrimario;
       this.modoOscuro = modoOscuro;
       this.tipografia = tipografia;
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
    public int getColorPrimario() {
        return this.colorPrimario;
    }
    
    public void setColorPrimario(int colorPrimario) {
        this.colorPrimario = colorPrimario;
    }
    public int getModoOscuro() {
        return this.modoOscuro;
    }
    
    public void setModoOscuro(int modoOscuro) {
        this.modoOscuro = modoOscuro;
    }
    public int getTipografia() {
        return this.tipografia;
    }
    
    public void setTipografia(int tipografia) {
        this.tipografia = tipografia;
    }
    public int getMostrarEncabezado() {
        return this.mostrarEncabezado;
    }
    
    public void setMostrarEncabezado(int mostrarEncabezado) {
        this.mostrarEncabezado = mostrarEncabezado;
    }




}



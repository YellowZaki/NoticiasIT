/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.usuarioDAO;
import java.util.Map;
import java.util.regex.Pattern;
import pojos.Personalizacion;
import pojos.Usuario;

/**
 *
 * @author Andrés Manuel
 */
public class UsuarioActions extends ActionSupport {
    private String email;
    private String modificarCuenta;
    private String mostrarEncabezado;
    private String temaOscuro;
    private String color_primario;
    private usuarioDAO dao;
    
    public UsuarioActions() {
        dao = new usuarioDAO();
    }
    
    public void validate(){
        if(this.getEmail().trim().equals("")){
            addFieldError("email", "Debe estar relleno");
        }else if(!Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", this.getEmail())){
            addFieldError("email", "El formato del email no es correcto");
        }
    }
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
            
        Usuario u = (Usuario)session.get("usuario");
            
        if(this.getModificarCuenta().equals("Guardar")){
            int encabezado = 1;
            int oscuro = 0;
            u.setEmail(email);
            
            if(!this.getMostrarEncabezado().equals("true")){
                encabezado = 0;
            }
            
            if(this.getTemaOscuro().equals("true")){
                oscuro = 1;
            }
            
            Personalizacion p = u.getPersonalizacion();
        
            p.setModoOscuro(oscuro);
            p.setMostrarEncabezado(encabezado);
            p.setColorPrimario(color_primario);
            
            dao.modificarUsuario(u, p);
        }else{
            dao.eliminarUsuario(u);
        }
        
        return SUCCESS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModificarCuenta() {
        return modificarCuenta;
    }

    public void setModificarCuenta(String modificarCuenta) {
        this.modificarCuenta = modificarCuenta;
    }

    public String getMostrarEncabezado() {
        return mostrarEncabezado;
    }

    public void setMostrarEncabezado(String mostrarEncabezado) {
        this.mostrarEncabezado = mostrarEncabezado;
    }

    public String getTemaOscuro() {
        return temaOscuro;
    }

    public void setTemaOscuro(String temaOscuro) {
        this.temaOscuro = temaOscuro;
    }

    public String getColor_primario() {
        return color_primario;
    }

    public void setColor_primario(String color_primario) {
        this.color_primario = color_primario;
    }
    
    
}

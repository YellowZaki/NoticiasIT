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
import pojos.Usuario;

/**
 *
 * @author Andrés Manuel
 */
public class UsuarioActions extends ActionSupport {
    private String email;
    private String modificarCuenta;
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
            u.setEmail(email);
            
            dao.modificarUsuario(u);
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
    
    
}

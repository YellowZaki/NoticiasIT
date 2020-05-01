/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.usuarioDAO;
import java.util.Map;
import pojos.Usuario;
import utils.*;

/**
 *
 * @author Alberto
 */
public class Login extends ActionSupport {

    private String usuario;
    private String clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Login() {
    }

    public void validate() {

        if (this.usuario.length() == 0) {
            this.addFieldError("usuario", "Debe rellenar el campo");
        }
        if (this.usuario.contains("_") || this.usuario.contains("#") || this.usuario.contains("!") || this.usuario.contains(";") || this.usuario.contains(":") || this.usuario.contains("*") || this.usuario.contains("(") || this.usuario.contains(")") || this.usuario.contains("[") || this.usuario.contains("]") || this.usuario.contains("{") || this.usuario.contains("}")) {
            this.addFieldError("usuario", "No se permiten caracteres extraños");
        }
        if (this.clave.length() == 0) {
            this.addFieldError("clave", "Debe rellenar el campo");
        }

        if (this.clave.contains("_") || this.clave.contains("#") || this.clave.contains("!") || this.clave.contains(";") || this.clave.contains(":") || this.clave.contains("(") || this.clave.contains(")") || this.clave.contains("[") || this.clave.contains("]") || this.clave.contains("{") || this.clave.contains("}")) {
            this.addFieldError("clave", "No se permiten caracteres extraños");
        }

    }

    public String execute() throws Exception {
        Usuario u = new usuarioDAO().getUsuario(usuario);
        String resultado = ERROR;
        if (u != null) {
            if (Utils.isHashedPasswordCorrect(clave, u.getClave())) {
                resultado = SUCCESS;
                Map session = (Map) ActionContext.getContext().get("session");
                session.put("usuario", u);
            }
        }
        return resultado;
    }

}

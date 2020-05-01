/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.registerDAO;
import java.util.Map;
import java.util.regex.Pattern;

public class Register extends ActionSupport {
    private String usuario;
    private String email;
    private String clave;
    private registerDAO dao;
    
    public void validate(){
        if(this.getUsuario().trim().equals("")){
            addFieldError("usuario", "Debe estar relleno");
        }else if(this.getUsuario().trim().length() > 50){
            addFieldError("usuario", "El nombre de usuario no debe sobrepasar los 50 caracteres");
        }
        
        if(this.getEmail().trim().equals("")){
            addFieldError("email", "Debe estar relleno");
        }else if(!Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", this.getEmail())){
            addFieldError("email", "El formato del email no es correcto");
        }
        
        if(this.getClave().trim().equals("")){
            addFieldError("clave", "Debe estar relleno");
        }
    }
    
    public Register() {
        dao = new registerDAO();
    }
    
    public String execute() throws Exception {
        String enc = dao.Registrar(usuario, email, clave);
        
        if(enc.equals("email")){
            Map session = (Map) ActionContext.getContext().get("session");
            
            session.put("errorEmail", "El email introducido ya existe.");
        }else if(enc.equals("usuario")){
            Map session = (Map) ActionContext.getContext().get("session");
            
            session.put("errorUsuario", "El nombre de usuario introducido ya existe.");
        }
        
        if(enc.equals("")){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

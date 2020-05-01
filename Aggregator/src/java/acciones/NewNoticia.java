/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import utils.Utils;

/**
 *
 * @author hecto
 */
public class NewNoticia extends ActionSupport {
    
    private String titulo;
    private String descripcion;
    private String fuente;
    
    public NewNoticia() {
    }
    
    public String execute() throws Exception {
       Map session = (Map) ActionContext.getContext().get("session");
       Date fechaPublicacion = Utils.fechaHoy();
       
       
        return SUCCESS;
    }
    
}

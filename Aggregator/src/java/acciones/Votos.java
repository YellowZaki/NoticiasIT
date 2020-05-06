/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
import java.util.Map;
import pojos.Usuario;

/**
 *
 * @author Andrés Manuel
 */
public class Votos extends ActionSupport {
    private String idNoticia;
    private noticiaDAO dao = new noticiaDAO();
    
    public Votos() {
    }
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario)session.get("usuario");
        
        if(u != null){
            dao.votar(u, getIdNoticia(), 1);
        }
        
        return SUCCESS;
    }

    public String dislike(){
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario)session.get("usuario");
        
        if(u != null){
            dao.votar(u, getIdNoticia(), -1);
        }
        
        return SUCCESS;
    }
    
    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
        this.idNoticia = idNoticia;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;

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
        dao.votar(getIdNoticia(), 1);
        
        return SUCCESS;
    }

    public String dislike(){
        dao.votar(getIdNoticia(), -1);
        
        return SUCCESS;
    }
    
    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
        this.idNoticia = idNoticia;
    }
}

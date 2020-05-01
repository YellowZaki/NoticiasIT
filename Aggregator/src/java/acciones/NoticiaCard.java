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
import javax.servlet.http.HttpServletRequest;
import pojos.Noticia;

/**
 *
 * @author Alberto
 */
public class NoticiaCard extends ActionSupport {

    //    localhost/NoticiaCard.action?id=2
    //Notcia
    //Parámetros de entrada por GET
    String id;

    //Parámetros de salida
    Noticia noticia;

    public String getId() {
        return id;
    }

    public NoticiaCard() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public Noticia getNoticia() {
        return this.noticia;
    }

    public String execute() throws Exception {
        if (id != null) {
            noticiaDAO nd = new noticiaDAO();
            noticia = nd.getNoticia(getId());
        }
        return SUCCESS;
    }

}

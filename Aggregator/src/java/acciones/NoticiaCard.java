/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
import pojos.Noticia;

/**
 *
 * @author Alberto
 */
public class NoticiaCard extends ActionSupport {

    //Parámetros de entrada por GET
    String id;

    //Parámetros de salida
    Noticia noticia;

    public String getId() {
        return id;
    }

    public NoticiaCard() {
    }

    String idd;

    public String getIdd() {
        return idd;
    }

    public String execute() throws Exception {
//        noticiaDAO nd = new noticiaDAO();
//        noticia = nd.getNoticia(getId());
        idd = "Param " + getId();
        return SUCCESS;
    }

}

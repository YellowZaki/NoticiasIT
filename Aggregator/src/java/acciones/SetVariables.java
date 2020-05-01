/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
import java.util.List;
import pojos.Noticia;

/**
 *
 * @author Alberto
 */
public class SetVariables extends ActionSupport {

    //Parámetros de entrada por GET
    String id;

    //Parámetros de salida para mostrar en página .jsp
    Noticia noticia;
    List<Noticia> noticias;

    public SetVariables() {
    }

    /**
     * ###########################################
     *
     * Aquí empiezan los getter y setter de todo
     *
     * ###########################################
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    /**
     * ###########################################
     *
     * Aquí empiezan los métodos para setear variables basado en las posibles
     * condiciones (parámetros GET por ej)
     *
     * ###########################################
     */
    public String listaNoticias() {
        //Limpiamos sesión
        noticiaDAO nd = new noticiaDAO();
        noticias = nd.getAllNoticias();
        return SUCCESS;
    }

    /**
     * Si se le pasa por parámetro GET, el id, se establecerá Noticia. Si no no.
     */
    public String getNoticiaUnica() {
        if (id != null) {
            noticiaDAO nd = new noticiaDAO();
            noticia = nd.getNoticia(getId());
        }
        return SUCCESS;
    }

    //No usar esté metodo, siempre crear uno
    public String execute() throws Exception {
        return SUCCESS;
    }

}

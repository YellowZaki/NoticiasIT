/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Noticia;

/**
 *
 * @author Alberto
 */
public class SetVariables extends ActionSupport {

    //Parámetros de entrada por GET
    String id;//De noticia, si se van a crear mas ids, poner id_xxxx
    String pag;
    String tema; //Para ver_noticias.jsp

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

    public String getPag() {
        return pag;
    }

    public void setPag(String pag) {
        this.pag = pag;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
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

        noticiaDAO nd = new noticiaDAO();
        //Si se pasa el parámeto tema, obtener noticias de un tema. Si no, obtenerlas todas
        if (getTema() != null) {
            noticias = nd.getNoticias(getTema());
        }
        else {
            noticias = nd.getAllNoticias();
        }
               
        
        //Obtener solo los resultados de una página
        int pag = 1;
        if (getPag() != null) {
            pag = Integer.parseInt(getPag());
        }
        else {
            setPag(1+"");
        }
        int initialIndex = pag * 3 - 3;
        int i = 0;
        List<Noticia> final_not = new ArrayList();
        while (i < 3 && initialIndex < noticias.size()) {
            final_not.add(noticias.get(initialIndex));
            i++;
            initialIndex++;
        }
        
        noticias = final_not;
        
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

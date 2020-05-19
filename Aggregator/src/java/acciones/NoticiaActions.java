/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
import dao.temaDAO;
import java.util.Date;
import java.util.Map;
import pojos.Noticia;
import pojos.Tema;
import pojos.Usuario;
import utils.Utils;

/**
 *
 * @author hecto
 */
public class NoticiaActions extends ActionSupport {

    private String titulo;
    private String descripcion;
    private String fuente;
    private String temaNoticia;
    private String actualizar;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActualizar() {
        return actualizar;
    }

    public void setActualizar(String actualizar) {
        this.actualizar = actualizar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getTemaNoticia() {
        return temaNoticia;
    }

    public void setTemaNoticia(String temaNoticia) {
        this.temaNoticia = temaNoticia;
    }

    public NoticiaActions() {
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) session.get("usuario");
        noticiaDAO ndao = new noticiaDAO();

        Date fechaPublicacion = Utils.fechaHoy();
        temaDAO tdao = new temaDAO();
        Tema tema = tdao.getTema(temaNoticia);

        if (this.getId() != null) {//actualizar
            
        } else {
            Noticia noticia = new Noticia(tema, usuario, titulo, descripcion, fuente, fechaPublicacion);
            ndao.addNoticia(noticia);
        }

        return SUCCESS;
    }

}

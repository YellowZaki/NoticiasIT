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
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void validate() {
        if (titulo != null) {
            if (this.titulo.length() == 0) {
                this.addFieldError("titulo", "Debe rellenar el campo");
            }

            if (this.titulo.contains("#") || this.titulo.contains("!") || this.titulo.contains(";") || this.titulo.contains("(") || this.titulo.contains(")") || this.titulo.contains("[") || this.titulo.contains("]") || this.titulo.contains("{") || this.titulo.contains("}")) {
                this.addFieldError("titulo", "No se permiten caracteres extraños");
            }

            if (this.descripcion.length() == 0) {
                this.addFieldError("descripcion", "Debe rellenar el campo");
            }

            if (this.descripcion.contains("#") || this.descripcion.contains("!") || this.descripcion.contains(";") || this.descripcion.contains("(") || this.descripcion.contains(")") || this.descripcion.contains("[") || this.descripcion.contains("]") || this.descripcion.contains("{") || this.descripcion.contains("}")) {
                this.addFieldError("descripcion", "No se permiten caracteres extraños");
            }
            if (this.fuente.length() == 0) {
                this.addFieldError("fuente", "Debe rellenar el campo");
            }

            if (this.fuente.contains("#") || this.fuente.contains("!") || this.fuente.contains(";") || this.fuente.contains("(") || this.fuente.contains(")") || this.fuente.contains("[") || this.fuente.contains("]") || this.fuente.contains("{") || this.fuente.contains("}")) {
                this.addFieldError("fuente", "No se permiten caracteres extraños");

            }
        }
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) session.get("usuario");
        noticiaDAO ndao = new noticiaDAO();

        Date fechaPublicacion = new Date();
        temaDAO tdao = new temaDAO();
        Tema tema = tdao.getTema(temaNoticia);

        if (getId() != null) {//actualizar
            Noticia noticia = ndao.getNoticia(getId());

            noticia.setTema(tema);
            noticia.setTitulo(titulo);
            noticia.setDescripcion(descripcion);
            noticia.setFuente(fuente);
            ndao.updateNoticia(noticia);
        } else {
            Noticia noticia = new Noticia(tema, usuario, titulo, descripcion, fuente, fechaPublicacion);
            ndao.addNoticia(noticia);
        }

        return SUCCESS;
    }

}

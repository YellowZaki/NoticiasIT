/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
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
public class NewNoticia extends ActionSupport {
    
    private String titulo;
    private String descripcion;
    private String fuente;
    private Tema temaNoticia;

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

    public Tema getTemaNoticia() {
        return temaNoticia;
    }

    public void setTemaNoticia(Tema temaNoticia) {
        this.temaNoticia = temaNoticia;
    }
    
    public NewNoticia() {
    }
    
    public String execute() throws Exception {
       Map session = (Map) ActionContext.getContext().get("session");
       Usuario usuario = (Usuario) session.get("usuario");
       
       Date fechaPublicacion = Utils.fechaHoy();
       Noticia noticia = new Noticia(temaNoticia, usuario, titulo, descripcion, fuente, 0, fechaPublicacion);
       noticiaDAO ndao = new noticiaDAO();
       
       ndao.addNoticia(noticia);
       
        return SUCCESS;
    }
    
}

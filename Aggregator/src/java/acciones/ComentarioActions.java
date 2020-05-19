/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.comentarioDAO;
import dao.noticiaDAO;
import java.util.Map;
import pojos.Comentario;
import pojos.Noticia;
import pojos.Usuario;

/**
 *
 * @author Alberto
 */
public class ComentarioActions extends ActionSupport {

    String textoComentario;
    String id_noticia;
    String id_comentario;
    Comentario comentario;

    public ComentarioActions() {
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public String getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(String id_noticia) {
        this.id_noticia = id_noticia;
    }

    public String getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(String id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario user = (Usuario) session.get("usuario");

        comentarioDAO cd = new comentarioDAO();
        noticiaDAO nd = new noticiaDAO();
        Noticia noticia = nd.getNoticia(getId_noticia());

        cd.addComentario(noticia, user, getTextoComentario());
        return SUCCESS;
    }

    public String borrarComentario() {
        comentarioDAO cd = new comentarioDAO();
        Comentario coment = cd.getComentario(id_comentario);
        setId_noticia(coment.getNoticia().getIdNoticia() + "");
        cd.borrarComentario(coment);
        return SUCCESS;
    }

    public String editarComentario() {
        comentarioDAO cd = new comentarioDAO();
        comentario = cd.getComentario(id_comentario);
        return SUCCESS;
    }
    
    public String editarComentarioSubmit() {
        
        comentarioDAO cd = new comentarioDAO();
        comentario = cd.getComentario(id_comentario);
        comentario.setTexto(textoComentario);
        setId_noticia(comentario.getNoticia().getIdNoticia() + "");
        cd.updateComentario(comentario);
        
        return SUCCESS;
    }

}

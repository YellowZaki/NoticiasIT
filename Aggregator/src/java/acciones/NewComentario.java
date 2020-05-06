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
import pojos.Noticia;
import pojos.Usuario;

/**
 *
 * @author Alberto
 */
public class NewComentario extends ActionSupport {
    
    String textoComentario;
    String id_noticia;
    
    public NewComentario() {
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
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario user = (Usuario) session.get("usuario");
        
        comentarioDAO cd = new comentarioDAO();
        noticiaDAO nd = new noticiaDAO();
        Noticia noticia = nd.getNoticia(getId_noticia());
 
        cd.addComentario(noticia, user, getTextoComentario());
        return SUCCESS;
    }
    
}

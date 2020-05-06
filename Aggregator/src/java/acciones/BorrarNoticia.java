package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.noticiaDAO;
import pojos.Noticia;

/**
 *
 * @author Alberto
 */
public class BorrarNoticia extends ActionSupport {
    
    String id_noticia;
    
    public BorrarNoticia() {
    }

    public String getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(String id_noticia) {
        this.id_noticia = id_noticia;
    }

    
    public String execute() throws Exception {
        noticiaDAO nd = new noticiaDAO();
        Noticia noticia = nd.getNoticia(getId_noticia());
        nd.borrarNoticia(noticia);
        return SUCCESS;
    }
    
}

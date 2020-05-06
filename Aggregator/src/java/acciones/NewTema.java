/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.temaDAO;
import java.util.Map;
import pojos.Tema;
import utils.Utils;

/**
 *
 * @author hecto
 */
public class NewTema extends ActionSupport {

    private String nombre;
    private String imagen;
    private String temaOriginal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTemaOriginal() {
        return temaOriginal;
    }

    public void setTemaOriginal(String temaOriginal) {
        this.temaOriginal = temaOriginal;
    }

    public NewTema() {
    }

//    public void validate() {
//
//        if (this.nombre.length() == 0) {
//            this.addFieldError("nombre", "Debe rellenar el campo");
//        }
//        if (this.nombre.contains("_") || this.nombre.contains("#") || this.nombre.contains("!") || this.nombre.contains(";") || this.nombre.contains(":") || this.nombre.contains("*") || this.nombre.contains("(") || this.nombre.contains(")") || this.nombre.contains("[") || this.nombre.contains("]") || this.nombre.contains("{") || this.nombre.contains("}")) {
//            this.addFieldError("nombre", "No se permiten caracteres extraños");
//        }
//        if (this.imagen.length() == 0) {
//            this.addFieldError("imagen", "Debe rellenar el campo");
//        }
//
//        if ( this.imagen.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
//            this.addFieldError("imagen", "No se permiten caracteres extraños");
//        }
//
//    }
    public String execute() throws Exception {
        temaDAO tDAO = new temaDAO();
        Tema tema = null;

        if (temaOriginal != null) {
            tema = tDAO.getTema(temaOriginal);
        } else {
            tema = new Tema(nombre, imagen);
        }

        if (temaOriginal != null) {
            tDAO.updateTema(tema);
        } else {
            tDAO.addTema(tema);
        }

        return SUCCESS;
    }

}

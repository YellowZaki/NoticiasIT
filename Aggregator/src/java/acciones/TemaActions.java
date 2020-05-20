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
import dao.noticiaDAO;
import dao.temaDAO;
import java.util.Map;
import pojos.Tema;
import utils.Utils;

/**
 *
 * @author hecto
 */
public class TemaActions extends ActionSupport {

    private String nombre;
    private String imagen;
    private String temaOriginal;
    private String temaBorrar;
    private String noValidar;
    private String actualizar;

    public String getActualizar() {
        return actualizar;
    }

    public void setActualizar(String actualizar) {
        this.actualizar = actualizar;
    }

    public String getNoValidar() {
        return noValidar;
    }

    public void setNoValidar(String noValidar) {
        this.noValidar = noValidar;
    }

    public String getTemaBorrar() {
        return temaBorrar;
    }

    public void setTemaBorrar(String temaBorrar) {
        this.temaBorrar = temaBorrar;
    }

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

    public TemaActions() {
    }

    public void validate() {
        if (this.noValidar == null) {
            if (this.getActualizar() != null) {
                if (this.imagen.length() == 0) {
                    this.addFieldError("imagen", "Debe rellenar el campo");
                }

                if (this.imagen.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
                    this.addFieldError("imagen", "No se permiten caracteres extraños");
                }
            } else {
                if (this.nombre.length() == 0) {
                    this.addFieldError("nombre", "Debe rellenar el campo");
                }
                if (this.nombre.contains("_") || this.nombre.contains("#") || this.nombre.contains("!") || this.nombre.contains(";") || this.nombre.contains(":") || this.nombre.contains("*") || this.nombre.contains("(") || this.nombre.contains(")") || this.nombre.contains("[") || this.nombre.contains("]") || this.nombre.contains("{") || this.nombre.contains("}")) {
                    this.addFieldError("nombre", "No se permiten caracteres extraños");
                }
                if (this.imagen.length() == 0) {
                    this.addFieldError("imagen", "Debe rellenar el campo");
                }

                if (this.imagen.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
                    this.addFieldError("imagen", "No se permiten caracteres extraños");
                }
            }

        }

    }

    public String execute() throws Exception {
        temaDAO tDAO = new temaDAO();

        if (getTemaOriginal() != null) {
            //actualizamos
            Tema tema = tDAO.getTema(temaOriginal);
            tema.setImagen(imagen);
            tDAO.updateTema(tema);
        } else {
            Tema tema = new Tema(nombre, imagen);
            tDAO.addTema(tema);
        }

        return SUCCESS;
    }

    public String borrarTema() {
        temaDAO tdao = new temaDAO();
        
        Tema tema = tdao.getTema(getTemaBorrar());
        
        tdao.borrarTema(tema);

        return SUCCESS;
    }
}

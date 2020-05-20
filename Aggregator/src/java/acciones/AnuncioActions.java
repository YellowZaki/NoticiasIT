/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.anuncioDAO;
import dao.temaDAO;
import pojos.Anuncio;
import pojos.Tema;

/**
 *
 * @author hecto
 */
public class AnuncioActions extends ActionSupport {

    private String link;
    private String titulo;
    private String imagen;
    private String temaAnuncio;
    private String actualizar;
    private String noValidar;
    private String anuncioBorrar;

    public AnuncioActions() {
    }

    public String getAnuncioBorrar() {
        return anuncioBorrar;
    }

    public void setAnuncioBorrar(String anuncioBorrar) {
        this.anuncioBorrar = anuncioBorrar;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTemaAnuncio() {
        return temaAnuncio;
    }

    public void setTemaAnuncio(String temaAnuncio) {
        this.temaAnuncio = temaAnuncio;
    }

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

    public void validate() {
        if (this.noValidar == null) {
            if (this.getActualizar() != null) {
                if (this.imagen.length() == 0) {
                    this.addFieldError("imagen", "Debe rellenar el campo");
                }

                if (this.imagen.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
                    this.addFieldError("imagen", "No se permiten caracteres extraños");
                }

                if (this.titulo.length() == 0) {
                    this.addFieldError("titulo", "Debe rellenar el campo");
                }

                if (this.titulo.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
                    this.addFieldError("titulo", "No se permiten caracteres extraños");
                }
            } else {
                if (this.link.length() == 0) {
                    this.addFieldError("link", "Debe rellenar el campo");
                }
                if (this.link.contains("_") || this.link.contains("#") || this.link.contains("!") || this.link.contains(";") || this.link.contains(":") || this.link.contains("*") || this.link.contains("(") || this.link.contains(")") || this.link.contains("[") || this.link.contains("]") || this.link.contains("{") || this.link.contains("}")) {
                    this.addFieldError("link", "No se permiten caracteres extraños");
                }
                if (this.imagen.length() == 0) {
                    this.addFieldError("imagen", "Debe rellenar el campo");
                }

                if (this.imagen.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
                    this.addFieldError("imagen", "No se permiten caracteres extraños");
                }

                if (this.titulo.length() == 0) {
                    this.addFieldError("titulo", "Debe rellenar el campo");
                }

                if (this.titulo.contains("#") || this.imagen.contains("!") || this.imagen.contains(";") || this.imagen.contains("(") || this.imagen.contains(")") || this.imagen.contains("[") || this.imagen.contains("]") || this.imagen.contains("{") || this.imagen.contains("}")) {
                    this.addFieldError("titulo", "No se permiten caracteres extraños");
                }
            }

        }
    }

    public String execute() throws Exception {
        anuncioDAO adao = new anuncioDAO();
        temaDAO tdao = new temaDAO();
        Tema tema = tdao.getTema(temaAnuncio);
        
        if (actualizar != null) {
            //actualizamos
            Anuncio anuncio = adao.getAnuncio(getLink());
            anuncio.setImagen(imagen);
            anuncio.setTitulo(titulo);
            anuncio.setTema(tema);
            adao.updateAnuncio(anuncio);
        } else {
            Anuncio Anuncio = new Anuncio(link, tema, titulo, imagen);
            adao.addAnuncio(Anuncio);
        }

        return SUCCESS;
    }

    public String borrarAnuncio() {
        anuncioDAO tdao = new anuncioDAO();
        Anuncio anuncio = tdao.getAnuncio(getAnuncioBorrar());
        tdao.borrarAnuncio(anuncio);

        return SUCCESS;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.carpetaDAO;
import dao.noticiaDAO;
import dao.usuarioDAO;
import java.util.Map;
import pojos.Carpeta;
import pojos.GuardadasEn;
import pojos.Noticia;
import pojos.Usuario;

/**
 *
 * @author juani_000
 */
public class CarpetaActions extends ActionSupport {

    String nombre_carpeta;
    String nombre_usuario;
    String nombre;
    String nombreOriginal;
    String id_noticia;

    public String getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(String id_noticia) {
        this.id_noticia = id_noticia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }

    public String getNombre_carpeta() {
        return nombre_carpeta;
    }

    public void setNombre_carpeta(String nombre_carpeta) {
        this.nombre_carpeta = nombre_carpeta;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public CarpetaActions() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String borrarCarpeta() throws Exception {
        new carpetaDAO().borrarCarpeta(nombre_carpeta, nombre_usuario);
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", new usuarioDAO().getUsuario(nombre_usuario));
        return SUCCESS;
    }

    public String asociar() throws Exception {
        Noticia n = new noticiaDAO().getNoticia(id_noticia);
        Carpeta c = new carpetaDAO().getCarpeta(nombre_carpeta, nombre_usuario);
        GuardadasEn ge = new GuardadasEn();
        ge.setCarpeta(c);
        ge.setNoticia(n);
        c.getGuardadasEns().add(ge);
        new carpetaDAO().updateCarpeta(c);
        Usuario u = new usuarioDAO().getUsuario(nombre_usuario);
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", u);
        return SUCCESS;
    }

    public String crearEditarCarpeta() throws Exception {
        carpetaDAO cDAO = new carpetaDAO();
        Usuario u = new usuarioDAO().getUsuario(nombre_usuario);
        Carpeta carpeta = new Carpeta(nombre, u);

        if (getNombreOriginal() != null) {
            //actualizamos
            cDAO.updateCarpeta(nombreOriginal, carpeta);
            u = new usuarioDAO().getUsuario(nombre_usuario);
        } else {
            cDAO.addCarpeta(carpeta);
            u.getCarpetas().add(carpeta);
        }
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", u);
        return SUCCESS;
    }
}

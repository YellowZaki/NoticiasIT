/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.carpetaDAO;
import dao.usuarioDAO;
import pojos.Carpeta;
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
    
    public String borrarCarpeta() throws Exception{
        new carpetaDAO().borrarCarpeta(nombre_carpeta, nombre_usuario);
        //actualizar carpetas usuario
        return SUCCESS;
    }
    
    public String asociar() throws Exception{
        //asociar una noticia a una carpeta
        return SUCCESS;
    }
    
    public String crearEditarCarpeta() throws Exception{
        carpetaDAO DAO = new carpetaDAO();
        Usuario u = new usuarioDAO().getUsuario(nombre_usuario);
        Carpeta carpeta = new Carpeta(nombre,u);

        if (getNombreOriginal() != null) {
            //actualizamos
            DAO.updateCarpeta(nombreOriginal,carpeta);
        }else{
            DAO.addCarpeta(carpeta);
        }
        return SUCCESS;
    }
}

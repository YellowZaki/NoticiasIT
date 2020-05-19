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
import dao.temaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pojos.Carpeta;
import pojos.Noticia;
import pojos.Tema;
import pojos.Usuario;
import pojos.Voto;

/**
 *
 * @author Alberto
 */
public class SetVariables extends ActionSupport {

    //Parámetros de entrada por GET
    String id;//De noticia, si se van a crear mas ids, poner id_xxxx
    String pag;
    String tema; //Para ver_noticias.jsp
    String nombre_carpeta;
    String nombre_usuario;
    String temaCrearEditar;
    //Parámetros de salida para mostrar en página .jsp
    Noticia noticia;
    List<Noticia> noticias;
    List <Tema> temas;
    Tema tema0;
    Carpeta carpeta;
    int valorVotosNoticia = 0;
    int valorVotoUsuario = 0;

    public SetVariables() {
    }

    /**
     * ###########################################
     *
     * Aquí empiezan los getter y setter de todo
     *
     * ###########################################
     */
    public String getId() {
        return id;
    }

    public String getTemaCrearEditar() {
        return temaCrearEditar;
    }

    public void setTemaCrearEditar(String temaCrearEditar) {
        this.temaCrearEditar = temaCrearEditar;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPag() {
        return pag;
    }

    public void setPag(String pag) {
        this.pag = pag;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public Tema getTema0() {
        return tema0;
    }

    public void setTema0(Tema tema0) {
        this.tema0 = tema0;
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

    public Carpeta getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(Carpeta carpeta) {
        this.carpeta = carpeta;
    }

    public int getValorVotosNoticia() {
        return valorVotosNoticia;
    }

    public void setValorVotosNoticia(int valorVotosNoticia) {
        this.valorVotosNoticia = valorVotosNoticia;
    }

    public int getValorVotoUsuario() {
        return valorVotoUsuario;
    }

    public void setValorVotoUsuario(int valorVotoUsuario) {
        this.valorVotoUsuario = valorVotoUsuario;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
    
    
    

    /**
     * ###########################################
     *
     * Aquí empiezan los métodos para setear variables basado en las posibles
     * condiciones (parámetros GET por ej)
     *
     * ###########################################
     */
    public String listaNoticias() {

        noticiaDAO nd = new noticiaDAO();
        //Si se pasa el parámeto tema, obtener noticias de un tema. Si no, obtenerlas todas
        if (getTema() != null) {
            noticias = nd.getNoticias(getTema());
        } else {
            noticias = nd.getAllNoticias();
        }

        //Obtener solo los resultados de una página
        int pag = 1;
        if (getPag() != null) {
            pag = Integer.parseInt(getPag());
        } else {
            setPag(1 + "");
        }
        int initialIndex = pag * 3 - 3;
        int i = 0;
        List<Noticia> final_not = new ArrayList();
        while (i < 3 && initialIndex < noticias.size()) {
            final_not.add(noticias.get(initialIndex));
            i++;
            initialIndex++;
        }

        noticias = final_not;

        return SUCCESS;
    }



    /**
     * Si se le pasa por parámetro GET, el id, se establecerá Noticia. Si no no.
     */
    public String getNoticiaUnica() {
        if (id != null) {
            noticiaDAO nd = new noticiaDAO();
            noticia = nd.getNoticia(getId());
            Map session = (Map) ActionContext.getContext().get("session");
            Usuario user = null;
            if (session.containsKey("usuario") && session.get("usuario") != null) {
                user = (Usuario) session.get("usuario");
            }
            for (Voto voto : (Set<Voto>) noticia.getVotos()) {
                valorVotosNoticia = valorVotosNoticia + voto.getValor();
                if (user != null && voto.getUsuario().getUsuario().equals(user.getUsuario())) {
                    valorVotoUsuario = voto.getValor();
                }
            }
        }
        return SUCCESS;
    }

    public String setearTema() {

        if (getTemaCrearEditar() != null) {
            temaDAO tDAO = new temaDAO();
            setTema0(tDAO.getTema(getTemaCrearEditar()));
        }

        return SUCCESS;
    }

    public String getCarpetaUnica() {
        if (nombre_carpeta != null) {
            carpetaDAO cd = new carpetaDAO();
            carpeta = cd.getCarpeta(getNombre_carpeta(), getNombre_usuario());
        }
        return SUCCESS;
    }

    //No usar esté metodo, siempre crear uno
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String setearTemas(){
        getNoticiaUnica();
        temaDAO tdao = new temaDAO();
        List<Tema> temas = tdao.getAllTemas();
        setTemas(temas);
         
        return SUCCESS;
    }

}

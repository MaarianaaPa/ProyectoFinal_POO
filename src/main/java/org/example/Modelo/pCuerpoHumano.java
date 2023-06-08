package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class pCuerpoHumano {
    private int id;
    private String seccion; //torso, etc
    private String pCuerpo; //nombre
    private String descripcion; //protege... hueso...
    private String funcion; //que permite... soporta...
    private String url;

    public pCuerpoHumano(int id, String seccion, String pCuerpo, String descripcion, String funcion, String url) {
        this.id = id;
        this.seccion = seccion;
        this.pCuerpo = pCuerpo;
        this.descripcion = descripcion;
        this.funcion = funcion;
        this.url = url;
    }

    public pCuerpoHumano() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getpCuerpo() {
        return pCuerpo;
    }

    public void setpCuerpo(String pCuerpo) {
        this.pCuerpo = pCuerpo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "pCuerpoHumano{" +
                "id=" + id +
                ", seccion=" + seccion +
                ", pCuerpo='" + pCuerpo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", funcion='" + funcion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon IconUrlImagen() {
        ImageIcon imagenURl = null;
        //preparamos una excepcion en el url de la imagen
        try {
            URL urlImagen = new URL(this.url);
            imagenURl = new ImageIcon(urlImagen);
        } catch (MalformedURLException mue) {
            System.out.println(mue.toString());
        }
        return imagenURl;
    }
}
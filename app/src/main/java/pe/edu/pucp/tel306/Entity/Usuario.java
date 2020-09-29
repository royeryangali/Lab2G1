package pe.edu.pucp.tel306.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private int codigoPUCP;
    private String nombre;
    private String apellido;
    private String especialidad;
    private int dni;
    private String clave;
    private ArrayList<String> listaTarea;
    private String color;
    private String mascota;

    public int getCodigoPUCP() {
        return codigoPUCP;
    }

    public void setCodigoPUCP(int codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<String> getListaTarea() {
        return listaTarea;
    }

    public void setListaTarea(ArrayList<String> listaTarea) {
        this.listaTarea = listaTarea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
}

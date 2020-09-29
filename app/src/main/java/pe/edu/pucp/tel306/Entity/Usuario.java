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
}

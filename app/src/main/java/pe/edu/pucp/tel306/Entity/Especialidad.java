package pe.edu.pucp.tel306.Entity;

import java.io.Serializable;

public class Especialidad implements Serializable {
    private String color;
    private String mascota;

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

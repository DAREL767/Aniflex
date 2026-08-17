/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;

/**
 *
 * @author jamed
 */
public class Pelicula extends Contenido {
    
    private String director;
    private double presupuesto;

    public Pelicula(String id, String titulo, int duracionMinutos, double calificacion, Date fechaEstreno, String director, double presupuesto) {

        super(id, titulo, duracionMinutos, calificacion, fechaEstreno); 
        this.director = director;
        this.presupuesto = presupuesto;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String getDetalles() {
        return "Director: " + director + " | Presupuesto: $" + presupuesto + " | Calificación: " + getCalificacion() + " | Fecha de estreno: " + getFechaEstreno();
    }

}

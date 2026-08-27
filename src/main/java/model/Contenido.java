/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jamed
 */
public abstract class Contenido {
    private String id;
    private String titulo;
    private int duracionMinutos;
    private double calificacion;
    private LocalDate fechaEstreno;

    public Contenido(String id, String titulo, int duracionMinutos, double calificacion, LocalDate fechaEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.calificacion = calificacion;
        this.fechaEstreno = fechaEstreno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public abstract String getDetalles();
    public abstract double calcularRetencion ();

}

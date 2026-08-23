/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jamed
 */
package Model;
import java.util.Date;

public class Pelicula extends Contenido implements IAlquilable {
    private boolean esSaga;
    private double recaudacionTaquilla;

    public Pelicula(String id, String titulo, int duracionMinutos, double calificacion, Date fechaEstreno, boolean esSaga, double recaudacionTaquilla) {
        super(id, titulo, duracionMinutos, calificacion, fechaEstreno);
        this.esSaga = esSaga;
        this.recaudacionTaquilla = recaudacionTaquilla;
    }

    // --- ESTE MÉTODO ES EL QUE CONTRARRESTA EL ERROR DE LA INTERFAZ ---
    @Override
    public double calcularAlquiler() {
        return esSaga ? 5000.0 : 3500.0;
    }

    @Override
public String getDetalles() {
    return "🎬 [PELÍCULA] " + getTitulo() + 
           " | ID: " + getId() + 
           " | Duración: " + getDuracionMinutos() + " min" + 
           " | Calificación: " + getCalificacion() + "★" + 
           " | Estreno: " + getFechaEstreno() + 
           " | Es Saga: " + (esSaga ? "Sí" : "No") + 
           " | Taquilla: $" + String.format("%.2f", recaudacionTaquilla) + 
           " | Retención: " + String.format("%.2f", calcularRetencion()) + " pts" +
           " | Alquiler: $" + String.format("%.2f", calcularAlquiler());
}

public double calcularRetencion() {
    double horas = getDuracionMinutos() / 60.0;
    return getCalificacion() * (1 + (horas * 0.1));
}

    // Getters y Setters
    public boolean isEsSaga() { return esSaga; }
    public void setEsSaga(boolean esSaga) { this.esSaga = esSaga; }

    public double getRecaudacionTaquilla() { return recaudacionTaquilla; }
    public void setRecaudacionTaquilla(double recaudacionTaquilla) { this.recaudacionTaquilla = recaudacionTaquilla; }
}
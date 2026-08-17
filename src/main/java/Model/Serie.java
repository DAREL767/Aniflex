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
public class Serie extends Contenido {
    
    private int temporadas;
    private int episodiosPorTemporada;

    public Serie(String id, String titulo, int duracionMinutos, double calificacion, Date fechaEstreno, int temporadas, int episodiosPorTemporada) {
        super(id, titulo, duracionMinutos, calificacion, fechaEstreno); // Primera línea obligatoria
        this.temporadas = temporadas;
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    
    @Override
    public String getDetalles() {
        return "Temporadas: " + temporadas + " | Episodios por temporada: " + episodiosPorTemporada + " | Calificación: " + getCalificacion() + " | Fecha de estreno: " + getFechaEstreno();
    }
}

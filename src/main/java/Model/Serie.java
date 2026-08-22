/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jamed
 */
public class Serie extends Contenido {
    private int temporadas;
    private int episodios;
    private List<Episodio> listaEpisodios;

    public Serie(String id, String titulo, int duracionMinutos, double calificacion, Date fechaEstreno, int temporadas, int episodios) {
        super(id, titulo, duracionMinutos, calificacion, fechaEstreno);
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.listaEpisodios = new ArrayList<>();
    }

    @Override
    public double calcularRetencion() {
        // En series, las horas acumuladas por sus episodios ponderan la calificación
        double horasTotales = (getDuracionMinutos() * episodios) / 60.0;
    return getCalificacion() * (1 + (horasTotales * 0.05));
    }

    @Override
    public String getDetalles() {
        return "📺 [SERIE] " + getTitulo() + 
               " | ID: " + getId() + 
               " | Temporadas: " + temporadas + 
               " | Episodios: " + episodios + 
               " | Calificación: " + getCalificacion() + "★" + 
               " | Retención: " + String.format("%.2f", calcularRetencion()) + " pts";
    }

    // Getters y Setters
    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    public int getEpisodios() { return episodios; }
    public void setEpisodios(int episodios) { this.episodios = episodios; }

    public List<Episodio> getListaEpisodios() { return listaEpisodios; }
    
    public void agregarEpisodio(Episodio ep) {
        this.listaEpisodios.add(ep);
    }
}

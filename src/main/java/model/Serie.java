/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Serie extends Contenido {
    private int temporadas;
    private int episodios;
    
    @lombok.Builder.Default
    private List<Episodio> listaEpisodios = new ArrayList<>();

    public Serie(String id, String titulo, int duracionMinutos, double calificacion, LocalDate fechaEstreno, int temporadas, int episodios) {
        super(id, titulo, duracionMinutos, calificacion, fechaEstreno);
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.listaEpisodios = new ArrayList<>();
    }

    @Override
    public double calcularRetencion() {
        if (episodios == 0) return 0.0;
        double horasTotales = (getDuracionMinutos() / (double) episodios) / 60.0;
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

    public void agregarEpisodio(Episodio ep) {
        if (this.listaEpisodios == null) {
            this.listaEpisodios = new ArrayList<>();
        }
        this.listaEpisodios.add(ep);
    }
}

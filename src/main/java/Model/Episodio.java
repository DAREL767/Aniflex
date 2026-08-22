/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jamed
 */
public class Episodio {
    private int noEpisodio;
    private String titulo;

    public Episodio(int noEpisodio, String titulo) {
        this.noEpisodio = noEpisodio;
        this.titulo = titulo;
    }

    // Getters y Setters
    public int getNoEpisodio() {
        return noEpisodio;
    }

    public void setNoEpisodio(int noEpisodio) {
        this.noEpisodio = noEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

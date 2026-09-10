/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import model.Contenido;
import model.Episodio;
import model.Pelicula;
import model.Serie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioContenido implements IServicioContenido {

    // --- Singleton Instance ---
    private static ServicioContenido instancia;

    // --- State ---
    private final Map<String, Contenido> contenidos;

    private ServicioContenido() {
        this.contenidos = new HashMap<>();
    }

    public static synchronized ServicioContenido getInstance() {
        if (instancia == null) {
            instancia = new ServicioContenido();
        }
        return instancia;
    }

    @Override
    public boolean addContenido(Contenido con) {
        if (contenidos.containsKey(con.getId())) {
            return false;
        }
        contenidos.put(con.getId(), con);
        ServicioObserver.cambio();
        return true;
    }

    @Override
    public void delContenido(String id) {
        if (contenidos.remove(id) != null) {
            ServicioObserver.cambio();
        }
    }

    @Override
    public void delPelicula(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe película con id: " + id);
        } else if (!(c instanceof Pelicula)) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una serie.");
        }
        contenidos.remove(id);
        ServicioObserver.cambio();
    }

    @Override
    public void delSerie(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe serie con id: " + id);
        } else if (!(c instanceof Serie)) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una película.");
        }
        contenidos.remove(id);
        ServicioObserver.cambio();
    }

    @Override
    public void updateContenido(Contenido con) {
        if (!contenidos.containsKey(con.getId())) {
            throw new IllegalArgumentException("No existe contenido a actualizar con id: " + con.getId());
        }
        contenidos.put(con.getId(), con);
        ServicioObserver.cambio();
    }

    @Override
    public double calcRetencion(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        }
        return c.calcularRetencion();
    }

    @Override
    public Pelicula searchPelicula(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        } else if (c instanceof Serie) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una serie.");
        }
        return (Pelicula) c;
    }

    @Override
    public Serie searchSerie(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        } else if (c instanceof Pelicula) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una película.");
        }
        return (Serie) c;
    }

    @Override
    public Contenido searchContenido(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        }
        return c;
    }

    @Override
    public Map<String, Contenido> getPeliculas() {
        Map<String, Contenido> peliculas = new HashMap<>();
        for (Map.Entry<String, Contenido> entry : contenidos.entrySet()) {
            if (entry.getValue() instanceof Pelicula) {
                peliculas.put(entry.getKey(), entry.getValue());
            }
        }
        return Map.copyOf(peliculas);
    }

    @Override
    public Map<String, Contenido> getSeries() {
        Map<String, Contenido> series = new HashMap<>();
        for (Map.Entry<String, Contenido> entry : contenidos.entrySet()) {
            if (entry.getValue() instanceof Serie) {
                series.put(entry.getKey(), entry.getValue());
            }
        }
        return Map.copyOf(series);
    }

    @Override
    public void addEpisodioASerie(String idSerie, int noEpisodio, String titulo) {
        Serie serie = searchSerie(idSerie);
        serie.agregarEpisodio(new Episodio(noEpisodio, titulo));
        ServicioObserver.cambio();
    }

    @Override
    public void delEpisodioDeSerie(String idSerie, int noEpisodio) {
        Serie serie = searchSerie(idSerie);
        serie.getListaEpisodios().removeIf(e -> e.getNoEpisodio() == noEpisodio);
        ServicioObserver.cambio();
    }

    @Override
    public Episodio searchEpisodio(String idSerie, int noEpisodio) {
        Serie serie = searchSerie(idSerie); // previa búsqueda de la serie contenedora
        return serie.getListaEpisodios().stream()
                .filter(e -> e.getNoEpisodio() == noEpisodio)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el episodio " + noEpisodio + " en la serie " + idSerie));
    }

    @Override
    public void updateEpisodio(String idSerie, int noEpisodio, String nuevoTitulo) {
        Episodio episodio = searchEpisodio(idSerie, noEpisodio); // previa búsqueda individual
        episodio.setTitulo(nuevoTitulo);
        ServicioObserver.cambio();
    }

    @Override
    public List<Episodio> listEpisodiosDeSerie(String idSerie) {
        Serie serie = searchSerie(idSerie);
        return List.copyOf(serie.getListaEpisodios());
    }
}

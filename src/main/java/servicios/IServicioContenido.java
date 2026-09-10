package servicios;

import model.Contenido;
import model.Episodio;
import model.Pelicula;
import model.Serie;
import java.util.List;
import java.util.Map;

public interface IServicioContenido{
    boolean addContenido(Contenido con);
    void delContenido(String id);
    void delPelicula(String id);
    void delSerie(String id);
    void updateContenido(Contenido con); 
    double calcRetencion(String id);
    Pelicula searchPelicula(String id);
    Serie searchSerie(String id);
    Contenido searchContenido(String id);
    Map<String, Contenido> getPeliculas();
    Map<String, Contenido> getSeries();
    
    void addEpisodioASerie(String idSerie, int noEpisodio, String titulo);
    void delEpisodioDeSerie(String idSerie, int noEpisodio);
    Episodio searchEpisodio(String idSerie, int noEpisodio);
    void updateEpisodio(String idSerie, int noEpisodio, String nuevoTitulo);
    List<Episodio> listEpisodiosDeSerie(String idSerie);
}

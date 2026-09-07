package servicios;

import Model.Contenido;
import Model.Pelicula;
import Model.Serie;
import servicios.ISujeto;
import java.util.Map;

public interface IServicioContenido extends ISujeto {
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
}

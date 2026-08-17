/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.Pelicula;

/**
 *
 * @author jamed
 */
public class ServicioPelicula {

    private static Map<String, Pelicula> mapaPeliculas = new HashMap<>();

    public static boolean adicionar(Pelicula pelicula) {
        if (mapaPeliculas.containsKey(pelicula.getId())) {
            return false; 
        }
        mapaPeliculas.put(pelicula.getId(), pelicula);
        return true;
    }

    public static List<Pelicula> listar() {
        return new ArrayList<>(mapaPeliculas.values());
    }

    public static Map<String, Pelicula> getMapaPeliculas() {
        return mapaPeliculas;
    }

    public static void setMapaPeliculas(Map<String, Pelicula> mapaPeliculas) {
        ServicioPelicula.mapaPeliculas = mapaPeliculas;
    }
    
}

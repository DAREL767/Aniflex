/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import Model.Contenido;
import Model.Pelicula;
import Model.Serie;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dan
 */
public class ServicioContenido {

    private static Map<String, Contenido> contenidos = new HashMap<>();

    public static boolean addContenido(Contenido con) {
        if (contenidos.containsKey(con.getId())) {
            return false; // ya existe
        }
        contenidos.put(con.getId(), con);
        return true;
    }

    public static void delContenido(String id) {
        contenidos.remove(id);
    }

    public static void delPelicula(String id) {
        Contenido c = contenidos.get(id);

        if (c == null) {
            throw new IllegalArgumentException("No existe película con id: " + id);
        } else if (!(c instanceof Pelicula)) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una serie.");
        }

        contenidos.remove(id);
    }

    public static void delSerie(String id) {
        Contenido c = contenidos.get(id);

        if (c == null) {
            throw new IllegalArgumentException("No existe serie con id: " + id);
        }else if (!(c instanceof Serie)) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una película.");
        }

        contenidos.remove(id);
    }

    public static double calcRetencion(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        }
        return c.calcularRetencion();
    }

    public static Pelicula searchPelicula(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        } else if (c instanceof Serie) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una serie.");
        }
        return (Pelicula) c;
    }

    public static Serie searchSerie(String id) {
        Contenido c = contenidos.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No existe contenido con id: " + id);
        } else if (c instanceof Pelicula) {
            throw new IllegalArgumentException("La id: " + id + " pertenece a una película.");
        }
        return (Serie) c;
    }

    public static Map<String, Contenido> getPeliculas() {
        Map<String, Contenido> peliculas = new HashMap<>();
        for (Map.Entry<String, Contenido> entry : contenidos.entrySet()) {
            if (entry.getValue() instanceof Pelicula) {
                peliculas.put(entry.getKey(), entry.getValue());
            }
        }
        return Map.copyOf(peliculas);
    }

    public static Map<String, Contenido> getSeries() {
        Map<String, Contenido> series = new HashMap<>();
        for (Map.Entry<String, Contenido> entry : contenidos.entrySet()) {
            if (entry.getValue() instanceof Serie) {
                series.put(entry.getKey(), entry.getValue());
            }
        }
        return Map.copyOf(series);
    }
}

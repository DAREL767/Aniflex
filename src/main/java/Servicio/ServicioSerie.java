/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.Serie;

/**
 *
 * @author jamed
 */
public class ServicioSerie {

    private static Map<String, Serie> mapaSeries = new HashMap<>();

    public static boolean adicionar(Serie serie) {
        if (mapaSeries.containsKey(serie.getId())) {
            return false; 
        }
        mapaSeries.put(serie.getId(), serie);
        return true;
    }

    public static List<Serie> listar() {
        return new ArrayList<>(mapaSeries.values());
    }

    public static Map<String, Serie> getMapaSeries() {
        return mapaSeries;
    }

    public static void setMapaSeries(Map<String, Serie> mapaSeries) {
        ServicioSerie.mapaSeries = mapaSeries;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class ServicioObserver {

    private static ArrayList<ICambiable> guisListar
            = new ArrayList();

    public static void addGUIListar(ICambiable gui) {
        if (!guisListar.contains(gui)) {
            guisListar.add(gui);
        }
    }

    public static void delGUIListar(ICambiable gui) {
        guisListar.remove(gui);
    }

    public static void cambio() {
        for (ICambiable gui : guisListar) {
            gui.cambio();
        }
    }

}

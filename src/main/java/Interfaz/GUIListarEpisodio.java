package Interfaz;

import Model.Episodio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import servicios.ServicioContenido;
import servicios.ICambiable;
import servicios.ServicioObserver;

/**
 * Caso de uso: Listar los objetos de la clase D (Episodio) asociados a una Serie.
 * Implementa IObservador para refrescarse automáticamente ante cualquier cambio
 * (igual que GUIListarPelicula / GUIListarSerie).
 */
public class GUIListarEpisodio extends javax.swing.JFrame implements ICambiable {
    private final ServicioContenido servicio;

    private JTextField txtIdSerie;
    private JButton btnListar;
    private JTable tablaEpisodios;
    private String idSerieActual = "";

    public GUIListarEpisodio() {
        setTitle("Listado de Episodios");
        initComponents();
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ServicioObserver.addGUIListar(this);
        servicio = ServicioContenido.getInstance();
    }

    private void initComponents() {
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("ID de la Serie:"));
        txtIdSerie = new JTextField(10);
        top.add(txtIdSerie);
        btnListar = new JButton("Listar Episodios");
        btnListar.addActionListener(this::btnListarActionPerformed);
        top.add(btnListar);

        tablaEpisodios = new JTable(new DefaultTableModel(
                new Object[][]{}, new String[]{"No. Episodio", "Título"}));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tablaEpisodios), BorderLayout.CENTER);
        setPreferredSize(new Dimension(420, 320));
    }

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {
        idSerieActual = txtIdSerie.getText().trim();
        cargarTablaEpisodios();
    }

    private void cargarTablaEpisodios() {
        if (idSerieActual.isEmpty()) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaEpisodios.getModel();
        modelo.setRowCount(0);
        try {
            List<Episodio> episodios = servicio.listEpisodiosDeSerie(idSerieActual);
            for (Episodio e : episodios) {
                modelo.addRow(new Object[]{e.getNoEpisodio(), e.getTitulo()});
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void cambio() {
        cargarTablaEpisodios(); // se refresca sola si idSerieActual ya fue consultada
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GUIListarEpisodio().setVisible(true));
    }
}

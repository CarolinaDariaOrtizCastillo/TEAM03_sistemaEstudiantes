package vallegrade.edu.pe.view;

import vallegrade.edu.pe.controller.EstudianteController;
import vallegrade.edu.pe.model.Estudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FrmEstudiante extends JFrame {
    public JTable tabla;
    private DefaultTableModel modelo;

    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnModificar = new JButton("Modificar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnActualizar = new JButton("Actualizar");

    private EstudianteController controller;

    public FrmEstudiante() {
        setTitle("Gestión de Estudiantes");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Apellidos", "Documento", "Número", "Institución", "Grado"},
                0
        );
        tabla = new JTable(modelo);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

        add(new JScrollPane(tabla), "Center");
        add(panelBotones, "South");

        // Controlador
        controller = new EstudianteController(this);
    }

    public void mostrarEstudiantes(List<Estudiante> lista) {
        modelo.setRowCount(0);
        for (Estudiante est : lista) {
            modelo.addRow(new Object[]{
                    est.getIdEstudiante(),
                    est.getNombre(),
                    est.getApellidos(),
                    est.getDocumento(),
                    est.getNumeroDocumento(),
                    est.getInstitucion(),
                    est.getGrado()
            });
        }
    }
}

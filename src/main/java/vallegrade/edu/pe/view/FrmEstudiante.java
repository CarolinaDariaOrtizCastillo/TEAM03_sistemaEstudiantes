package vallegrade.edu.pe.view;

import vallegrade.edu.pe.controller.EstudianteController;
import vallegrade.edu.pe.model.Estudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FrmEstudiante extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnActualizar;
    private EstudianteController controller;

    public FrmEstudiante() {
        setTitle("Gestión de Estudiantes");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo de tabla
        modelo = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Apellidos", "Documento", "Número", "Institución", "Grado"},
                0
        );
        tabla = new JTable(modelo);

        // Botón actualizar
        btnActualizar = new JButton("Actualizar lista");

        // Panel inferior con botón
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);

        // Layout
        add(new JScrollPane(tabla), "Center");
        add(panelBotones, "South");

        // Crear controlador
        controller = new EstudianteController(this);

        // Evento del botón
        btnActualizar.addActionListener(e -> controller.cargarEstudiantes());
    }

    // Mostrar estudiantes en tabla
    public void mostrarEstudiantes(List<Estudiante> lista) {
        modelo.setRowCount(0); // limpiar tabla
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

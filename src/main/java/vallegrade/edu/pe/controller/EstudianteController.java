package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.model.Estudiante;
import vallegrade.edu.pe.service.EstudianteService;
import vallegrade.edu.pe.view.FrmEstudiante;

import javax.swing.*;
import java.util.List;

public class EstudianteController {
    private EstudianteService service;
    private FrmEstudiante vista;

    public EstudianteController(FrmEstudiante vista) {
        this.vista = vista;
        this.service = new EstudianteService();
        cargarEstudiantes();

        // Eventos
        this.vista.btnAgregar.addActionListener(e -> agregarEstudiante());
        this.vista.btnModificar.addActionListener(e -> modificarEstudiante());
        this.vista.btnEliminar.addActionListener(e -> eliminarEstudiante());
        this.vista.btnActualizar.addActionListener(e -> cargarEstudiantes());
    }

    public void cargarEstudiantes() {
        List<Estudiante> lista = service.obtenerEstudiantes();
        vista.mostrarEstudiantes(lista);
    }

    private void agregarEstudiante() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellidos = JOptionPane.showInputDialog("Apellidos:");
        String documento = JOptionPane.showInputDialog("Documento (DNI/CNE):");
        String numero = JOptionPane.showInputDialog("Número Documento:");
        String institucion = JOptionPane.showInputDialog("Institución:");
        String grado = JOptionPane.showInputDialog("Grado (2/3):");

        Estudiante nuevo = new Estudiante(0, nombre, apellidos, documento, numero, institucion, grado);
        if (service.guardarEstudiante(nuevo)) {
            JOptionPane.showMessageDialog(vista, "Estudiante agregado");
            cargarEstudiantes();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar");
        }
    }

    private void modificarEstudiante() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un estudiante");
            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
        String apellidos = JOptionPane.showInputDialog("Nuevos apellidos:");
        String documento = JOptionPane.showInputDialog("Documento (DNI/CNE):");
        String numero = JOptionPane.showInputDialog("Número Documento:");
        String institucion = JOptionPane.showInputDialog("Institución:");
        String grado = JOptionPane.showInputDialog("Grado (2/3):");

        Estudiante modificado = new Estudiante(id, nombre, apellidos, documento, numero, institucion, grado);
        if (service.actualizarEstudiante(modificado)) {
            JOptionPane.showMessageDialog(vista, "Estudiante actualizado");
            cargarEstudiantes();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar");
        }
    }

    private void eliminarEstudiante() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un estudiante");
            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);
        if (service.eliminarEstudiante(id)) {
            JOptionPane.showMessageDialog(vista, "Estudiante eliminado");
            cargarEstudiantes();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al eliminar");
        }
    }
}

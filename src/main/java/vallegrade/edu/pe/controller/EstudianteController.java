package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.model.Estudiante;
import vallegrade.edu.pe.service.EstudianteService;
import vallegrade.edu.pe.view.FrmEstudiante;

import java.util.List;

public class EstudianteController {
    private EstudianteService service;
    private FrmEstudiante vista;

    public EstudianteController(FrmEstudiante vista) {
        this.vista = vista;
        this.service = new EstudianteService();
        cargarEstudiantes(); // carga inicial
    }

    public void cargarEstudiantes() {
        List<Estudiante> lista = service.obtenerEstudiantes();
        vista.mostrarEstudiantes(lista);
    }
}

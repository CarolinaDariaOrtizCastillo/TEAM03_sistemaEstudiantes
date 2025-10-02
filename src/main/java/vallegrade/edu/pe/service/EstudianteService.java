package vallegrade.edu.pe.service;

import vallegrade.edu.pe.model.Estudiante;
import vallegrade.edu.pe.model.EstudianteDAO;
import java.util.List;

public class EstudianteService {

    private EstudianteDAO dao = new EstudianteDAO();

    public List<Estudiante> obtenerEstudiantes() {
        return dao.listar();
    }

    public boolean guardarEstudiante(Estudiante e) {
        return dao.insertar(e);
    }
}

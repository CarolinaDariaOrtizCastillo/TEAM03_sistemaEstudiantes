package vallegrade.edu.pe.model;

public class Estudiante {

    private int idEstudiante;
    private String nombre;
    private String apellidos;
    private String documento;
    private String numeroDocumento;
    private String institucion;
    private String grado;

    public Estudiante(int idEstudiante, String nombre, String apellidos,
                      String documento, String numeroDocumento, String institucion, String grado) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.numeroDocumento = numeroDocumento;
        this.institucion = institucion;
        this.grado = grado;
    }

    // Getters y setters
    public int getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(int idEstudiante) { this.idEstudiante = idEstudiante; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }
}

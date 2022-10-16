
package Model;


public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String direccion;
    private String enfermedades;
    private String observaciones;
    private int idTutor;
    private int asistenciaTotal;
    private int asistenciaMedia;
    private int asistenciaNula;
    private int aula;

    public Alumno(int idAlumno, String nombre, String apellido, String apellido2, String direccion) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.direccion = direccion;
    }
    public Alumno(int idAlumno, String nombre, int idTutor){
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.idTutor=idTutor;
        
    }
   

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getAsistenciaTotal() {
        return asistenciaTotal;
    }

    public void setAsistenciaTotal(int asistenciaTotal) {
        this.asistenciaTotal = asistenciaTotal;
    }

    public int getAsistenciaMedia() {
        return asistenciaMedia;
    }

    public void setAsistenciaMedia(int asistenciaMedia) {
        this.asistenciaMedia = asistenciaMedia;
    }

    public int getAsistenciaNula() {
        return asistenciaNula;
    }

    public void setAsistenciaNula(int asistenciaNula) {
        this.asistenciaNula = asistenciaNula;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "ID=" + idAlumno + " Nombre=" + nombre +" "+ apellido +" "+ apellido2 + ", Direccion=" + direccion + ", IDTutor=" + idTutor + '}';
    }
    
}

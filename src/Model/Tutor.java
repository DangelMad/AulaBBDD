
package Model;

public class Tutor {
    private int idTutor;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String direccion;
    private String email;
    private String telefono;

    public Tutor(int idTutor, String nombre, String apellido, String apellido2, String direccion, String email, String telefono) {
        this.idTutor = idTutor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Tutor{" + "idTutor=" + idTutor + ", nombre=" + nombre + ", apellido=" + apellido + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
}

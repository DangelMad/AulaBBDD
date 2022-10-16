/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author didactarragolopez
 */
public class Clase {
    private int idClase =1;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Tutor> tutores;
    public Clase (){
        this.alumnos = new ArrayList();
        this.tutores = new ArrayList();
    }
    public void addAlumno (Alumno alumno) {
        alumnos.add(alumno);
    }
    
    public ArrayList<Alumno> getAlumno() {
        return alumnos;
    }
    public void addTutor (Tutor tutor) {
        tutores.add(tutor);
    }
    
    public ArrayList<Tutor> getTutor() {
        return tutores;
    }

    @Override
    public String toString() {
        return "Clase{" + "idClase=" + idClase + ", alumnos=" + alumnos + '}';
    }
}

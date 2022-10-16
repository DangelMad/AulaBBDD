/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;
import java.sql.*;
import javax.swing.*;
import SQL.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.*;
/**
 *
 * @author didactarragolopez
 */

public class Conexion {
    
    public static Connection getConexion(String usuario, String pass){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Aula", usuario, pass);
            return con;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar con el servidor.\nQuizas el usuario o el password sean incorrectos.\nO debido a un problema de conexión");
            return null;
        }        
    }
    public void sentenciaBBDD(String usuario, String pass, String S){
        try {
            Connection con = getConexion(usuario, pass);
            Statement St = con.createStatement();
            St.executeUpdate(S);
            //JOptionPane.showMessageDialog(null, "Hecho!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo ha fallado.");
        }
    }
    
    public void sentenciaModificarDatosAlumno(String usuario, String pass, String S){
        try {
            Connection con = getConexion(usuario, pass);
            Statement st = con.createStatement();
            st.executeUpdate(S);
            JOptionPane.showMessageDialog(null, "Informacion modificada");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo ha fallado.");
        }
    }
    
    public void infoAlumnosAula(String usuario, String pass, int aula, javax.swing.JTextArea text){
        Clase clase = new Clase();
        String SQL = "SELECT * FROM Alumnos where Aula = "+aula+"+1";
        text.setText(null);
        try {
            Connection con = getConexion(usuario, pass);
            Statement S = con.createStatement();
            ResultSet rs = S.executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("IdAlumno");
                int idt = rs.getInt("IdTutor");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String apellido2 = rs.getString("Apellido2");
                String direccion = rs.getString("Direccion");
                Alumno alumno = new Alumno(id,nombre,apellido,apellido2,direccion);
                alumno.setIdTutor(idt);
                clase.addAlumno(alumno);
                
            }
            for (Alumno alumno : clase.getAlumno()){
                text.setText(text.getText()+alumno.toString()+"\n");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo ha ido mal.");
        }
    }
    public void buscarTutorLegal(String usuario, String pass, 
            String SQL, Alumno alumno,javax.swing.JTextArea Observaciones,
            javax.swing.JTextArea Enfermedades, javax.swing.JTextField nombreTutor,
            javax.swing.JTextField Email, javax.swing.JTextField telefono){
        int id=0;
        try {
            Connection con = getConexion(usuario, pass);
            Statement S = con.createStatement();
            ResultSet rs = S.executeQuery(SQL);
            while (rs.next()){
                id = rs.getInt("IdTutor");
                
                String observaciones = rs.getString("Observaciones");
                String enfermedades = rs.getString("Enfermedades");
                Observaciones.setText(observaciones);
                Enfermedades.setText(enfermedades); 
            }
            System.out.println("id = " + id);
            String sentencia = "SELECT *FROM Tutores WHERE IdTutor= "+id;
            System.out.println("sentencia = " + sentencia);
            Statement R =con.createStatement();
            ResultSet r= R.executeQuery(sentencia);
            while (r.next()){
                String nombre = r.getString("Nombre");
                String apellido = r.getString("Apellido");
                String apellido2 = r.getString("Apellido2");
                nombreTutor.setText(nombre +" "+ apellido +" "+ apellido2);
                String tel = r.getString("Telefono");
                String email = r.getString("Email");
                Email.setText(email);
                telefono.setText(tel);
            }
            
        
        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo ha ido mal.");
        }
    }
    public void AlumnosBBDD(String usuario, String pass, int aula, javax.swing.JTable jTable1){
        Clase clase = new Clase();
        String SQL = "SELECT * FROM Alumnos where Aula = 1";
        try {
            Connection con = getConexion(usuario, pass);
            Statement S = con.createStatement();
            ResultSet rs = S.executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("idAlumno");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String apellido2 = rs.getString("Apellido2");
                String direccion = rs.getString("Direccion");
                int idt = rs.getInt("IdTutor");
                Alumno alumno = new Alumno(id,nombre,apellido,apellido2,direccion);
                alumno.setIdTutor(idt);
                clase.addAlumno(alumno);
            }
            //System.out.println("clase.getAlumno().size() = " + clase.getAlumno().size());
            int i=0;
            for(Alumno alumno : clase.getAlumno()){
                //System.out.println("alumno = " + alumno);
                jTable1.setValueAt(alumno.getIdAlumno(), i, 0);
                jTable1.setValueAt(alumno.getNombre(), i, 1);      
                jTable1.setValueAt(alumno.getApellido(), i, 2);
                jTable1.setValueAt(alumno.getApellido2(), i, 3);
                jTable1.setValueAt(false, i, 4);
                jTable1.setValueAt(false, i, 5);
                jTable1.setValueAt(false, i, 6);
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo ha ido mal.");
        }
        
    }
    public boolean IsSelected(int row, int column, JTable table){
        return table.getValueAt(row, column) !=null;
    }
    
    
    
    
   
    
    
    
   
    public void infoTutorComboBox (String usuario, String pass, javax.swing.JComboBox c, String tabla){
        Clase clase = new Clase();
        String SQL = "SELECT * FROM "+ tabla;
        try {
            Connection con = getConexion(usuario, pass);
            Statement S = con.createStatement();
            ResultSet rs = S.executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("idTutor");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String apellido2 = rs.getString("Apellido2");
                String direccion = rs.getString("Direccion");
                String email = rs.getString("Email");
                String telefono = rs.getString("Telefono");
                Tutor tutor = new Tutor(id,nombre,apellido,apellido2,direccion, email, telefono);
                clase.addTutor(tutor);
                
            }
            for (Tutor tutor : clase.getTutor()){
                c.addItem(tutor);
            }
        } catch (SQLException ex) {
            
        }
        
    }
    
    
    
    
    
    
    public void infoComboBox (String usuario, String pass, javax.swing.JComboBox c, String tabla){
        Clase clase = new Clase();
        String SQL = "SELECT * FROM "+ tabla;
        try {
            Connection con = getConexion(usuario, pass);
            Statement S = con.createStatement();
            ResultSet rs = S.executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("idAlumno");
                int idt=rs.getInt("IdTutor");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String apellido2 = rs.getString("Apellido2");
                String direccion = rs.getString("Direccion");
                Alumno alumno = new Alumno(id,nombre,apellido,apellido2,direccion);
                alumno.setIdTutor(idt);
                clase.addAlumno(alumno);
                
            }
            for (Alumno alumno : clase.getAlumno()){
                c.addItem(alumno);
            }
        } catch (SQLException ex) {
            
        }
        
    }
    
}

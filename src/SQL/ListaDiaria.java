/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SQL;
import Model.*;
import static Model.Conexion.getConexion;
import java.sql.*;
import javax.swing.*;

public class ListaDiaria extends javax.swing.JFrame {

    
    public ListaDiaria() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        btnCargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCargar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCargar.setText("Cargar datos");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "APellido2", "Asistencia", "MediaAsistencia", "Falta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnCargar1.setText("<<Atras");
        btnCargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargar1ActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargar1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnCargar1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCargar1ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        String u= "root";
        String p= "muslon2022";
        Conexion c=new Conexion();
        Object[][] datos = new String[0][0];
        c.AlumnosBBDD(u, p, 1, jTable1);
    }//GEN-LAST:event_btnCargarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Clase clase = new Clase();
        Conexion cx=new Conexion();
        String u="root";
        String p="muslon2022";
        String SQL = "SELECT * FROM Alumnos where Aula = 1";
        int alu=0;
        try {
            Connection con = getConexion(u, p);
            Statement S = con.createStatement();
            ResultSet rs = S.executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("idAlumno");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String apellido2 = rs.getString("Apellido2");
                String direccion = rs.getString("Direccion");
                Alumno alumno = new Alumno(id,nombre,apellido,apellido2,direccion);
                clase.addAlumno(alumno);
                alu++;
            }
            String Sql= "";
            System.out.println("");
            System.out.println("primera opcion = " +jTable1.getValueAt(0, 4).toString() );
            System.out.println("");
            for( int i =1; i< jTable1.getRowCount()+1;i++){
                if ((boolean)jTable1.getValueAt(i-1, 4)){
                    Object valueAt = jTable1.getValueAt(i-1, 0);
                    int Id =(int)valueAt;
                    System.out.println( Id+"= Ha venido 100%");
                    Sql="UPDATE Alumnos SET AsistenciaTotal= AsistenciaTotal+1 WHERE IdAlumno= "+Id+";";
                    cx.sentenciaBBDD(u, p, Sql);
                    
                } else if ((boolean)jTable1.getValueAt(i-1, 5)){
                    Object valueAt = jTable1.getValueAt(i-1, 0);
                    int Id =(int)valueAt;
                    System.out.println( Id+"= Ha venido 50%");
                    Sql="UPDATE Alumnos SET AsistenciaMedia= AsistenciaMedia+1 WHERE IdAlumno= "+Id+";";
                    cx.sentenciaBBDD(u, p, Sql);
                    
                } else if ((boolean)jTable1.getValueAt(i-1, 6)){
                    Object valueAt = jTable1.getValueAt(i-1, 0);
                    int Id =(int)valueAt;
                    System.out.println( Id+"= Ha venido 0%");
                    Sql="UPDATE Alumnos SET AsistenciaNula= AsistenciaNula+1 WHERE IdAlumno= "+Id+";";
                    cx.sentenciaBBDD(u, p, Sql);
                }else{
                    JOptionPane.showMessageDialog(null, "Faltan asistencias por rellenar (ALUMNO ID="+jTable1.getValueAt(i-1,0).toString()+").\nLos siguientes al alumno, no se han registrado");
                    
                }
            }
            
            JOptionPane.showMessageDialog(null, "Se ha pasado lista correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo ha ido mal.");
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDiaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnCargar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

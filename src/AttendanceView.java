
import SQLConnection.ConnectionProvider;
import java.awt.Font;
import java.io.File;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class AttendanceView extends javax.swing.JFrame {

    /**
     * Creates new form ViewTable
     */
    public AttendanceView() {
        initComponents();
        Load_Stuname();

            
          try {
            File fontStyle = new File("src/ttf/RobofanFree.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            jButton1.setFont(font);
            btnDelete.setFont(font);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    PreparedStatement pst;
    ResultSet rs;
    
   public void Load_Stuname()
    {        
        Connection con=ConnectionProvider.getCon();
       try {
        pst = con.prepareStatement("select Distinct stunamee from stuname");
        rs = pst.executeQuery();
        CboStudName.removeAllItems();
    
        while(rs.next())
        {
            CboStudName.addItem(rs.getString("stunamee"));
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
       }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CboStudName = new javax.swing.JComboBox<>();
        Cbodays = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setBackground(new java.awt.Color(204, 204, 255));
        jTable3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Stuname", "Subject", "Status", "Time"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 760, 320));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("-");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Attendance View");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stuname");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Day");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        CboStudName.setBackground(new java.awt.Color(255, 204, 204));
        CboStudName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(CboStudName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, 30));

        Cbodays.setBackground(new java.awt.Color(255, 204, 204));
        Cbodays.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cbodays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sunday", "monday", "tuesday", "wednesday", "friday", "saturday" }));
        Cbodays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbodaysActionPerformed(evt);
            }
        });
        getContentPane().add(Cbodays, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 143, 30));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 155, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/neon-lights-city.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 980, 560));

        setSize(new java.awt.Dimension(980, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CbodaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbodaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbodaysActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Connection con=ConnectionProvider.getCon();
        try {
            String studentnamee = (String)CboStudName.getSelectedItem();
            String days = (String)Cbodays.getSelectedItem();
            pst = con.prepareStatement("select * from attendance where stuname=? && days=?");
            pst.setString(1, studentnamee);
            pst.setString(2, days);
            
            rs = pst.executeQuery();
            
            DefaultTableModel model =(DefaultTableModel)jTable3.getModel();
            ResultSetMetaData RSMD = rs.getMetaData();
            int CC = RSMD.getColumnCount();
            DefaultTableModel DFT =(DefaultTableModel)jTable3.getModel();     
            DFT.setRowCount(0);
             
            while(rs.next()){
        
                Vector v2 = new Vector();

                for(int ii=1; ii<=CC; ii++){
                     v2.add(rs.getString("date"));
                    v2.add(rs.getString("stuname"));
                     v2.add(rs.getString("subjects"));
                     v2.add(rs.getString("status"));
                     v2.add(rs.getString("time"));

                }
             
             DFT.addRow(v2);  
            }
            
            jTable3.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       Connection con=ConnectionProvider.getCon();
        try {
        String textToDelete = jTextField1.getText();
        if (textToDelete.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value to delete.");
            return;
        }

        pst = con.prepareStatement("DELETE FROM attendance WHERE date=? OR stuname=? OR subjects=? OR status=? OR time=?");
        pst.setString(1, textToDelete);
        pst.setString(2, textToDelete);
        pst.setString(3, textToDelete);
        pst.setString(4, textToDelete);
        pst.setString(5, textToDelete);

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Record(s) deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "No matching record found.");
        }

        // Refresh the table to reflect changes
        String studentnamee = (String)CboStudName.getSelectedItem();
        String days = (String) Cbodays.getSelectedItem();
        pst = con.prepareStatement("SELECT * FROM attendance WHERE stuname=? AND days=?");
        pst.setString(1, studentnamee);
        pst.setString(2, days);

        rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        ResultSetMetaData RSMD = rs.getMetaData();
        int CC = RSMD.getColumnCount();
        DefaultTableModel DFT = (DefaultTableModel) jTable3.getModel();
        DFT.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();

            for (int ii = 1; ii <= CC; ii++) {
                         v2.add(rs.getString("date"));
                    v2.add(rs.getString("stuname"));
                     v2.add(rs.getString("subjects"));
                     v2.add(rs.getString("status"));
                     v2.add(rs.getString("time"));
            }

            DFT.addRow(v2);
        }

        jTable3.setModel(model);

    } catch (SQLException ex) {
        Logger.getLogger(AttendanceView.class.getName()).log(Level.SEVERE, null, ex);
    }
        jTextField1.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboStudName;
    private javax.swing.JComboBox<String> Cbodays;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

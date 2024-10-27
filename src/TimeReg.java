import SQLConnection.ConnectionProvider;
import java.awt.Font;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class TimeReg extends javax.swing.JFrame {

    /**
     * Creates new form TimeReg
     */
    public TimeReg() {
        initComponents();
        Load_Class();
        Load_Subject();
        
          try {
            File fontStyle = new File("src/ttf/RobofanFree.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            jButton4.setFont(font);
            jButton7.setFont(font);
            jButton1.setFont(font);
            jButton5.setFont(font);
            jButton6.setFont(font);
            btnClear.setFont(font);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    PreparedStatement pst;
    ResultSet rs; 
        
     public void Load_Class() {
         Connection con=ConnectionProvider.getCon();
    try {
        pst = con.prepareStatement("select Distinct name from class");
        rs = pst.executeQuery();
        CboClass.removeAllItems();

        while (rs.next()) {
            CboClass.addItem(rs.getString("name"));
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

public void Load_Subject() {
    Connection con=ConnectionProvider.getCon();
    try {
        String query = "SELECT DISTINCT subject FROM subject";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();

        CboSubj.removeAllItems(); // Clear existing items

        while (rs.next()) {
            String subject = rs.getString("subject");
            CboSubj.addItem(subject); // Add each subject to the ComboBox
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        CboClass = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        CboSubj = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Cbodays = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtSub = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        txtClass = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtclass = new javax.swing.JTextField();
        txtsubject = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Class");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        CboClass.setBackground(new java.awt.Color(255, 204, 204));
        CboClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CboClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboClassActionPerformed(evt);
            }
        });
        getContentPane().add(CboClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Subject");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        CboSubj.setBackground(new java.awt.Color(255, 204, 204));
        CboSubj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(CboSubj, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Days");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, -1, -1));

        Cbodays.setBackground(new java.awt.Color(255, 204, 204));
        Cbodays.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cbodays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        getContentPane().add(Cbodays, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Time");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, -1, -1));
        getContentPane().add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 200, 36));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, -1, -1));

        txtSub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubActionPerformed(evt);
            }
        });
        getContentPane().add(txtSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 130, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Subject");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        jButton7.setText("ADD");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 110, 40));

        txtClass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassActionPerformed(evt);
            }
        });
        getContentPane().add(txtClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Class");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 110, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("-");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("X");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Schedules");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));
        getContentPane().add(txtclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 160, 30));

        txtsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubjectActionPerformed(evt);
            }
        });
        getContentPane().add(txtsubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 160, 30));

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        jButton5.setText("Delete Class");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 190, -1));

        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        jButton6.setText("Delete Subject");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 190, -1));

        btnClear.setBackground(new java.awt.Color(255, 204, 204));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add Class & Subject");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wallpaperflare2.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 690));

        setSize(new java.awt.Dimension(1230, 679));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CboClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CboClassActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          Connection con=ConnectionProvider.getCon();
        try {
        String name = txtclass.getText();

        pst = con.prepareStatement("DELETE FROM class WHERE name=?");
        pst.setString(1, name);

        int deletedRows = pst.executeUpdate();
        if (deletedRows > 0) {
            JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            Load_Class(); // Reload class list after deletion
        } else {
            JOptionPane.showMessageDialog(this, "No record found for the given Class Name.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        Logger.getLogger(TimeReg.class.getName()).log(Level.SEVERE, null, ex);
    }
          txtclass.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         Connection con=ConnectionProvider.getCon();
        try {
        String subject = txtsubject.getText();

        pst = con.prepareStatement("DELETE FROM subject WHERE subject=?");
        pst.setString(1, subject);

        int deletedRows = pst.executeUpdate();
        if (deletedRows > 0) {
            JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            Load_Subject(); // Reload subject list after deletion
        } else {
            JOptionPane.showMessageDialog(this, "No record found for the given Subject Name.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        Logger.getLogger(TimeReg.class.getName()).log(Level.SEVERE, null, ex);
    }
         txtsubject.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassActionPerformed

    private void txtSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubActionPerformed

    private void txtsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubjectActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        txtclass.setText("");
        txtsubject.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String classname = (String)CboClass.getSelectedItem();
            String subject = (String)CboSubj.getSelectedItem();
            String days = (String)Cbodays.getSelectedItem();
            String time = txtTime.getText();

            pst = con.prepareStatement("INSERT INTO timetable(class,subject,days,time) VALUES (?,?,?,?)");
            pst.setString(1, classname);
            pst.setString(2, subject);
            pst.setString(3, days);
            pst.setString(4, time);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Timetable Registration Successful");

            CboClass.setSelectedIndex(-1);
            CboSubj.setSelectedIndex(-1);
            Cbodays.setSelectedIndex(-1);
            txtTime.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(TimeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String subj = txtSub.getText();

            pst = con.prepareStatement("INSERT INTO subject(subject) VALUES (?)");
            pst.setString(1, subj);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Subject Registration Successful");
            txtSub.setText("");
            Load_Subject();
        } catch (SQLException ex) {
            Logger.getLogger(TimeReg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String classname = txtClass.getText();

            pst = con.prepareStatement("INSERT INTO class(name) VALUES(?)");
            pst.setString(1, classname);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Class Registration Successfully");
            txtClass.setText("");
            Load_Class();
        } catch (SQLException ex) {
            Logger.getLogger(TimeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TimeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboClass;
    private javax.swing.JComboBox<String> CboSubj;
    private javax.swing.JComboBox<String> Cbodays;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtclass;
    private javax.swing.JTextField txtsubject;
    // End of variables declaration//GEN-END:variables
}

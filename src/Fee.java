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
public class Fee extends javax.swing.JFrame {

    public Fee() {
        initComponents();
        FeeData();
        
        try {
            File fontStyle = new File("src/ttf/RobofanFree.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            btnInsert.setFont(font);
            btnUpdate.setFont(font);
            btnDelete.setFont(font);
            jButton1.setFont(font);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    PreparedStatement pst;
    
           private void FeeData(){
               Connection con=ConnectionProvider.getCon();
        try {
            int QQ;
            pst = con.prepareStatement("SELECT * FROM fee");
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();

            QQ = RSMD.getColumnCount();
            
            DefaultTableModel DFG =(DefaultTableModel)table1.getModel(); 
            
            DFG.setRowCount(0);
             
            while(Rs.next()){
        
            Vector v2 = new Vector();
             
            for(int aa=1; aa<=QQ; aa++){
                v2.add(Rs.getString("fid"));
                v2.add(Rs.getString("studentname"));
                v2.add(Rs.getString("amount") + "$");
             }
             
             DFG.addRow(v2);  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Fee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFId = new javax.swing.JTextField();
        txtFStudentName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtAmount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fee.png"))); // NOI18N
        jLabel6.setText("Fee");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fees.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fee ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Amount");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        txtFId.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtFId, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 200, -1));

        txtFStudentName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtFStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFStudentNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 200, -1));

        table1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FId", "StudentName", "Amount"
            }
        ));
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 810, 250));

        btnInsert.setBackground(new java.awt.Color(255, 204, 204));
        btnInsert.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/insert.png"))); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));
        getContentPane().add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 200, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("-");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, 40));

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wallpaperflare1.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 680));

        setSize(new java.awt.Dimension(1000, 663));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String fid = txtFId.getText();
            String studentname = txtFStudentName.getText();
            String amountStr = txtAmount.getText();

            if (fid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fee ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!fid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Fee ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (amountStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Amount cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!amountStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Amount should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int amount = Integer.parseInt(amountStr);

            pst = con.prepareStatement("SELECT COUNT(*) FROM fee WHERE fid = ?");
            pst.setString(1, fid);
            ResultSet rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Duplicate Fee ID. Please use a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("INSERT INTO fee (fid, studentname, amount) VALUES (?, ?, ?)");
            pst.setString(1, fid);
            pst.setString(2, studentname);
            pst.setInt(3, amount);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
            FeeData();

        } catch (SQLException ex) {
            Logger.getLogger(Fee.class.getName()).log(Level.SEVERE, null, ex);
        } 
        txtFId.setText("");
           txtFStudentName.setText("");
           txtAmount.setText("");
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String fid = txtFId.getText();
            String studentname = txtFStudentName.getText();
            String amountStr = txtAmount.getText();

            if (fid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fee ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!fid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Fee ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (amountStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Amount cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!amountStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Amount should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int amount = Integer.parseInt(amountStr);

            pst = con.prepareStatement("SELECT COUNT(*) FROM fee WHERE fid = ?");
            pst.setString(1, fid);
            ResultSet rs = pst.executeQuery();
            if (!rs.next() || rs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "Fee ID not found. Update failed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("UPDATE fee SET studentname = ?, amount = ? WHERE fid = ?");
            pst.setString(1, studentname);
            pst.setInt(2, amount);
            pst.setString(3, fid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated Successfully");
            FeeData();

        } catch (SQLException ex) {
            Logger.getLogger(Fee.class.getName()).log(Level.SEVERE, null, ex);
        }           
        txtFId.setText("");
           txtFStudentName.setText("");
           txtAmount.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String fid = txtFId.getText();

            if (fid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a Fee ID to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!fid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Fee ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("DELETE FROM fee WHERE fid=?");
            pst.setString(1, fid);

            int deletedRows = pst.executeUpdate();
            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                FeeData();
            } else {
                JOptionPane.showMessageDialog(this, "No record found for the given Fee ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Fee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFIdActionPerformed

    private void txtFStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFStudentNameActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         txtFId.setText("");
           txtFStudentName.setText("");
           txtAmount.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtFId;
    private javax.swing.JTextField txtFStudentName;
    // End of variables declaration//GEN-END:variables
}

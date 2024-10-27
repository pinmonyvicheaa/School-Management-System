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
public class Course extends javax.swing.JFrame {

    public Course() {
        initComponents();
        CourseData();
        
          try {
            File fontStyle = new File("src/ttf/RobofanFree.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            btnInsert.setFont(font);
            btnUpdate.setFont(font);
            btnDelete.setFont(font);
            jButton1.setFont(font);
            btnTotal.setFont(font);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    PreparedStatement pst;
        
       private void CourseData(){
           Connection con=ConnectionProvider.getCon();
       try {
            int QQ;
            pst = con.prepareStatement("SELECT * FROM course");
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();

            QQ = RSMD.getColumnCount();

            DefaultTableModel DFG =(DefaultTableModel)table1.getModel(); 

            DFG.setRowCount(0);

            while(Rs.next()){
                Vector v2 = new Vector();

                String courseid = Rs.getString("courseid");
                String course = Rs.getString("course");
                String duration = Rs.getString("duration");

                if (duration.equals("1")) {
                    duration += " Month";
                } else {
                    duration += " Months";
                }

                v2.add(courseid);
                v2.add(course);
                v2.add(duration);

                DFG.addRow(v2);  
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCId = new javax.swing.JTextField();
        txtCourse = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtDuration = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();
        txtSum2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 120, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/course.png"))); // NOI18N
        jLabel5.setText("Course");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Duration");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        txtCId.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtCId, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 210, -1));

        txtCourse.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseActionPerformed(evt);
            }
        });
        getContentPane().add(txtCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 210, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/courses.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 360, -1));

        table1.setBackground(new java.awt.Color(204, 204, 255));
        table1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CourseId", "Course", "Duration"
            }
        ));
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 860, 200));

        btnInsert.setBackground(new java.awt.Color(255, 204, 204));
        btnInsert.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/insert.png"))); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 130, -1));
        getContentPane().add(txtDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 210, -1));

        btnTotal.setBackground(new java.awt.Color(255, 204, 204));
        btnTotal.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/total.png"))); // NOI18N
        btnTotal.setText("Total Courses:");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        getContentPane().add(btnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, 40));

        txtSum2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSum2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(txtSum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 180, 40));

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
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 40));

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
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wallpaperflare.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 680));

        setSize(new java.awt.Dimension(1000, 662));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String courseid = txtCId.getText();
            String course = txtCourse.getText();
            String duration = txtDuration.getText();

            if (courseid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Course ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!courseid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Course ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (duration.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Duration cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }

            pst = con.prepareStatement("SELECT COUNT(*) FROM course WHERE courseid = ?");
            pst.setString(1, courseid);
            ResultSet rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Duplicate Course ID. Please use a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("INSERT INTO course (courseid, course, duration) VALUES (?, ?, ?)");
            pst.setString(1, courseid);
            pst.setString(2, course);
            pst.setString(3, duration);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
            CourseData();

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }   
         txtCId.setText("");
           txtCourse.setText("");
           txtDuration.setText("");
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String courseid = txtCId.getText();
            String course = txtCourse.getText();
            String duration = txtDuration.getText();
            
            if (duration.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Duration cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }

            pst = con.prepareStatement("SELECT COUNT(*) FROM course WHERE courseid = ?");
            pst.setString(1, courseid);
            ResultSet rs = pst.executeQuery();
            if (!rs.next() || rs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "Course ID not found. Update failed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("UPDATE course SET course = ?, duration = ? where courseid = ?");
            pst.setString(1, course);
            pst.setString(2, duration);
            pst.setString(3, courseid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated Successfully");
            CourseData();

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
         txtCId.setText("");
           txtCourse.setText("");
           txtDuration.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String courseid = txtCId.getText();

            if (courseid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a course ID to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!courseid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Course ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("DELETE FROM course WHERE courseid=?");
            pst.setString(1, courseid);

            int deletedRows = pst.executeUpdate();
            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                CourseData();
            } else {
                JOptionPane.showMessageDialog(this, "No record found for the given course ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtCIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIdActionPerformed

    private void txtCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String sql="select count(course) from course";
            pst=con.prepareStatement(sql);
            ResultSet Rs = pst.executeQuery();
            if(Rs.next()){
            String sum=Rs.getString("count(course)");
            txtSum2.setText(sum);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           txtCId.setText("");
           txtCourse.setText("");
           txtDuration.setText("");
           txtSum2.setText("");
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
                new Course().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnTotal;
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
    private javax.swing.JTextField txtCId;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtSum2;
    // End of variables declaration//GEN-END:variables
}

import SQLConnection.ConnectionProvider;
import java.awt.Font;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane; 
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Student extends javax.swing.JFrame {
      
      public Student() {
        initComponents();
        StudentData();
        
         try {
            File fontStyle = new File("src/ttf/RobofanFree.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
            btnInsert.setFont(font);
            btnUpdate.setFont(font);
            btnDelete.setFont(font);
            btnReset.setFont(font);
            btnPrint.setFont(font);
            btnTotal.setFont(font);
            jButton2.setFont(font);
                    btnRefresh.setFont(font);
                    Jbutton2.setFont(font);
                            btnClearImage.setFont(font);

        }catch(Exception e){
            e.printStackTrace();
        }
        
        // Add listener to the table selection
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table1.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the photo bytes from the selected row
                        byte[] photoBytes = (byte[]) table1.getModel().getValueAt(selectedRow, 7); // Assuming the photo is in column index 4
                        if (photoBytes != null) {
                            ImageIcon imageIcon = new ImageIcon(photoBytes);
                            Image image = imageIcon.getImage(); // Transform it
                            Image newimg = image.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_SMOOTH); // Scale it the smooth way
                            imageIcon = new ImageIcon(newimg);  // Transform it back
                            jLabel13.setIcon(imageIcon); // Update jLabel13 with selected image
                        } else {
                            jLabel13.setIcon(null); // Clear the label if there's no photo
                        }
                    }
                }
            }
        });
    }
    
    PreparedStatement pst;
    
     private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);  // Clear all rows
    }

    // Method to refresh the JTable
    private void refreshTable() {
        clearTable();  // First, clear the table
        StudentData(); // Then, reload the data from the database
    }

    // Method to load student data into JTable
        
       private void StudentData(){
           Connection con=ConnectionProvider.getCon();
        try {
            pst = con.prepareStatement("SELECT * FROM student");
            ResultSet Rs = pst.executeQuery();

            // Get metadata to determine column count
            ResultSetMetaData RSMD = Rs.getMetaData();
            int QQ = RSMD.getColumnCount();
            
            DefaultTableModel DFG =(DefaultTableModel)table1.getModel(); 
            DFG.setRowCount(0);
             
            while(Rs.next()){
                Vector v2 = new Vector();
                
                // Assuming photo is stored as a BLOB in the database
                byte[] imgData = Rs.getBytes("photo");
                v2.add(Rs.getString("studentid"));
                v2.add(Rs.getString("studentname"));
                v2.add(Rs.getString("sex"));
                v2.add(Rs.getString("enrolldate"));
                v2.add(Rs.getString("phonenum"));
                v2.add(Rs.getString("email"));
                v2.add(Rs.getString("address"));
                v2.add(imgData);  // Add the photo bytes to the table as a hidden column
                
                DFG.addRow(v2);  
            }
            
            // Hide the photo column
            table1.getColumnModel().getColumn(7).setMinWidth(0);
            table1.getColumnModel().getColumn(7).setMaxWidth(0);
            table1.getColumnModel().getColumn(7).setWidth(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        txtSum1 = new javax.swing.JTextField();
        Jbutton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnClearImage = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtphonenum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("-");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student.png"))); // NOI18N
        jLabel1.setText("Student");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        txtId.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 167, -1));

        txtName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 167, -1));

        txtEmail.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 170, -1));

        txtAddress.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 170, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.jpg"))); // NOI18N
        jLabel13.setMaximumSize(new java.awt.Dimension(208, 212));
        jLabel13.setMinimumSize(new java.awt.Dimension(208, 212));
        jLabel13.setPreferredSize(new java.awt.Dimension(208, 212));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 236, 223));

        table1.setBackground(new java.awt.Color(204, 204, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Sex", "Date of Birth", "Phone Number", "Email", "Address", "Photo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 467, 1140, 210));

        btnInsert.setBackground(new java.awt.Color(255, 204, 204));
        btnInsert.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/insert.png"))); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        btnTotal.setBackground(new java.awt.Color(255, 204, 204));
        btnTotal.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/total.png"))); // NOI18N
        btnTotal.setText("Total Students:");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        getContentPane().add(btnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, 40));

        txtSum1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSum1.setForeground(new java.awt.Color(255, 0, 0));
        txtSum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSum1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtSum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 170, 40));

        Jbutton2.setBackground(new java.awt.Color(255, 204, 204));
        Jbutton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Jbutton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upload.png"))); // NOI18N
        Jbutton2.setText("Upload");
        Jbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbutton2ActionPerformed(evt);
            }
        });
        getContentPane().add(Jbutton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 410, 110, -1));

        jTextField5.setText("Select Images:");
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 160, 40));

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 120, 40));

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 280, 40));

        btnRefresh.setBackground(new java.awt.Color(255, 204, 204));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 120, -1));

        btnClearImage.setBackground(new java.awt.Color(255, 204, 204));
        btnClearImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        btnClearImage.setText("Clear");
        btnClearImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearImageActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 410, -1, -1));

        btnReset.setBackground(new java.awt.Color(255, 204, 204));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        btnReset.setText("Clear");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 110, 40));

        btnPrint.setBackground(new java.awt.Color(255, 204, 204));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 110, 40));

        buttonGroup1.add(male);
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, -1, -1));

        buttonGroup1.add(female);
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date of Birth");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));
        getContentPane().add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 170, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Phone Number");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));
        getContentPane().add(txtphonenum, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 170, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sex:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 120, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/neon-scenery.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 690));

        setSize(new java.awt.Dimension(1230, 679));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
       Connection con=ConnectionProvider.getCon();
        try {
            String studentid = txtId.getText();
            String studentname = txtName.getText();
            String sex = male.isSelected() ? "Male" : "Female";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String enrolldate = sdf.format(dob.getDate());
            String phonenum = txtphonenum.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            if (studentid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Student ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!studentid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Student ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            

            // Check for duplicate student ID
            pst = con.prepareStatement("SELECT COUNT(*) FROM student WHERE studentid = ?");
            pst.setString(1, studentid);
            ResultSet rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Duplicate Student ID. Please use a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Insert student record with photo
            pst = con.prepareStatement("INSERT INTO student (studentid, studentname, sex, enrolldate, phonenum, email, address, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, studentid);
            pst.setString(2, studentname);
            if (male.isSelected()) {
                            sex = "M";
                        } else if (female.isSelected()) {
                            sex = "F";
                        }
                        pst.setString(3, sex);
            pst.setString(4, enrolldate);
            pst.setString(5, phonenum);
            pst.setString(6, email);
            pst.setString(7, address);
            pst.setBytes(8, photo);  // Assuming `photo` is a byte array of the image data

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
            StudentData();  // Method to refresh student data in your UI

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error inserting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        photo = null;
        jTextField5.setText("");
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
       buttonGroup1.clearSelection();
        dob.setDate(null);
        txtphonenum.setText("");
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
       String studentid = txtId.getText();
            String studentname = txtName.getText();
            String sex = male.isSelected() ? "Male" : "Female";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String enrolldate = sdf.format(dob.getDate());
            String phonenum = txtphonenum.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

        // Check if the student ID exists
        pst = con.prepareStatement("SELECT COUNT(*) FROM student WHERE studentid = ?");
        pst.setString(1, studentid);
        ResultSet rs = pst.executeQuery();
        if (!rs.next() || rs.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "Student ID not found. Update failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if a new photo is selected
        if (photo != null) {
            pst = con.prepareStatement("UPDATE student SET studentname = ?, sex = ?, enrolldate = ?, phonenum = ?, email = ?, address = ?, photo = ? WHERE studentid = ?");
     
            pst.setString(1, studentname);
            if (male.isSelected()) {
                            sex = "M";
                        } else if (female.isSelected()) {
                            sex = "F";
                        }
                        pst.setString(2, sex);
            pst.setString(3, enrolldate);
            pst.setString(4, phonenum);
            pst.setString(5, email);
            pst.setString(6, address);
            pst.setBytes(7, photo);  // Update with new photo
            pst.setString(8, studentid);

        } else {
             pst = con.prepareStatement("UPDATE student SET studentname = ?, sex = ?, enrolldate = ?, phonenum = ?, email = ?, address = ?, photo = ? WHERE studentid = ?");
             pst.setString(1, studentname);
            if (male.isSelected()) {
                            sex = "M";
                        } else if (female.isSelected()) {
                            sex = "F";
                        }
                        pst.setString(2, sex);
            pst.setString(3, enrolldate);
            pst.setString(4, phonenum);
            pst.setString(5, email);
            pst.setString(6, address);
            pst.setString(7, studentid);

        }

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Record Updated Successfully");
        StudentData();

    } catch (SQLException ex) {
        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Update error insertting record: Column 'photo' cannot be null ", "Error", JOptionPane.ERROR_MESSAGE);
    }
        jLabel13.setIcon(null);
        photo = null;
        jTextField5.setText("");
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
       buttonGroup1.clearSelection();
        dob.setDate(null);
        txtphonenum.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       Connection con=ConnectionProvider.getCon();
        try {
            String studentid = txtId.getText();

            if (studentid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a student ID to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!studentid.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Student ID should only contain digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("DELETE FROM student WHERE studentid=?");
            pst.setString(1, studentid);

            int deletedRows = pst.executeUpdate();
            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                StudentData();
            } else {
                JOptionPane.showMessageDialog(this, "No record found for the given student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel13.setIcon(null);
        photo = null;
        jTextField5.setText("");
        txtId.setText("");
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSum1ActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        Connection con=ConnectionProvider.getCon();
        try {
            String sql="select count(studentname) from student";
            pst=con.prepareStatement(sql);
            ResultSet Rs = pst.executeQuery();
            if(Rs.next()){
            String sum=Rs.getString("count(studentname)");
            txtSum1.setText(sum);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }//GEN-LAST:event_btnTotalActionPerformed

    private void Jbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbutton2ActionPerformed
     JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        if (f != null) {
            filename = f.getAbsolutePath();
            jTextField5.setText(filename);
            
            try {
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                
                int readNum;
                while ((readNum = fis.read(buf)) != -1) {
                    bos.write(buf, 0, readNum);
                }
                
                photo = bos.toByteArray();
                ImageIcon imageIcon = new ImageIcon(photo);
                Image img = imageIcon.getImage();
                Image scaledImg = img.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_SMOOTH);
                jLabel13.setIcon(new ImageIcon(scaledImg)); // Update jLabel13 with the selected image
                
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file selected");
        }
    }//GEN-LAST:event_Jbutton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     if (searchField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Search field is empty");
    } else {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Student ID", "Student Name", "Sex", "Date of Birth", "Phone Number", "Email", "Address", "Photo"}, 0);
        table1.setModel(model);
        getStudentValue(model, searchField.getText());
        searchField.setText(null);
    }
} 

private void getStudentValue(DefaultTableModel model, String searchQuery) {
   Connection con=ConnectionProvider.getCon();
    try {
        pst = con.prepareStatement("SELECT * FROM student WHERE studentid LIKE ? OR studentname LIKE ? OR sex LIKE ? OR enrolldate LIKE? OR phonenum LIKE? OR email LIKE ? OR address LIKE ?");
        pst.setString(1, "%" + searchQuery + "%");
        pst.setString(2, "%" + searchQuery + "%");
        pst.setString(3, "%" + searchQuery + "%");
        pst.setString(4, "%" + searchQuery + "%");
        pst.setString(5, "%" + searchQuery + "%");
         pst.setString(6, "%" + searchQuery + "%");
          pst.setString(7, "%" + searchQuery + "%");


        ResultSet Rs = pst.executeQuery();

        while (Rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(Rs.getString("studentid"));
            row.add(Rs.getString("studentname"));
            row.add(Rs.getString("sex"));
             row.add(Rs.getString("enrolldate"));
              row.add(Rs.getString("phonenum"));
            row.add(Rs.getString("email"));
            row.add(Rs.getString("address"));
            row.add(Rs.getBytes("photo"));  // Add the photo bytes to the table as a hidden column

            model.addRow(row);
        }

        // Hide the photo column
        table1.getColumnModel().getColumn(7).setMinWidth(0);
        table1.getColumnModel().getColumn(7).setMaxWidth(0);
        table1.getColumnModel().getColumn(7).setWidth(0);

    } catch (SQLException ex) {
        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error retrieving search results: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable(); 
        jLabel13.setIcon(null);
        photo = null;
        jTextField5.setText("");
        txtSum1.setText("");
        searchField.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnClearImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearImageActionPerformed
        jLabel13.setIcon(null);
        photo = null;
        jTextField5.setText("");
    }//GEN-LAST:event_btnClearImageActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
      buttonGroup1.clearSelection();
        dob.setDate(null);
        txtphonenum.setText("");
        txtSum1.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
      try {
        boolean complete = table1.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("STUDENT NAME LIST"), null);
        if (complete) {
            JOptionPane.showMessageDialog(this, "Printing Complete", "Print Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Printing Cancelled", "Print Result", JOptionPane.WARNING_MESSAGE);
        }
    } catch (PrinterException ex) {
        JOptionPane.showMessageDialog(this, "Error printing: " + ex.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed
  
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
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbutton2;
    private javax.swing.JButton btnClearImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTotal;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSum1;
    private javax.swing.JTextField txtphonenum;
    // End of variables declaration//GEN-END:variables
byte[] photo=null;
String filename=null;
}

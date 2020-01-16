/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.DataBase;
import model.*;


/**
 *
 * @author Regmi
 */
public class Home extends javax.swing.JFrame {
    DataBase database = new DataBase();
    ArrayList<Department> departmentList = new ArrayList<>();
    ArrayList<Employee> employeeList = new ArrayList<>();
    int mode = 0;
    int selectedID;
    int selectedempID;
    int selectedrow;
    
    //modes
    // 1 for new entry
    // 2 for edit
    // 3 for delete
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        populateEmpTable();
    }
    
    public void populateEmpTable() {
         try {
            ResultSet myrs = database.getStatement().executeQuery("select * from employee_detail");
            Employee tableEmployee;
            while (myrs.next()){
                tableEmployee = new Employee(myrs.getInt("employee_id"), 
                        myrs.getString("name"), myrs.getString("last_name"),
                        myrs.getInt("dep_id"),myrs.getDate("hire_date"));
                employeeList.add(tableEmployee);
            }
        } catch (Exception e){
            System.out.println("Error");
        }
        
        try {
            ResultSet myrs = database.getStatement().executeQuery("select * from department");
            Department tableDepartment;
            while (myrs.next()){
                tableDepartment = new Department(myrs.getInt("department_id"), 
                myrs.getString("name"), myrs.getInt("num_employees"));
                departmentList.add(tableDepartment);
            }
        } catch (Exception e){
            System.out.println("Error");
        }
        
        DefaultTableModel model = (DefaultTableModel)jTableEmpDetail.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < employeeList.size(); i++) {
            row[0] = employeeList.get(i).getFirstName();
            row[1] = employeeList.get(i).getLastName();
            int depID = employeeList.get(0).getDepID();
            for (Department d: departmentList) {
            if (d.getID() == depID) {
                row[2] = d.getName();
            }
        }
            row[3] = employeeList.get(i).getHireDate();
            model.addRow(row);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmpDetail = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jTextEmployee = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Department = new javax.swing.JTable();
        jButtonNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableEmpDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Department", "Date Hired"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmpDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmpDetail);
        if (jTableEmpDetail.getColumnModel().getColumnCount() > 0) {
            jTableEmpDetail.getColumnModel().getColumn(0).setResizable(false);
            jTableEmpDetail.getColumnModel().getColumn(1).setResizable(false);
            jTableEmpDetail.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpDetail.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/delete.png")); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/create.png")); // NOI18N
        jButton2.setText("New Employee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/report.png")); // NOI18N
        jButton3.setText("Reports");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(272, 272, 272)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Main", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Details:"));

        jLabel1.setText("Name:");

        jLabel2.setText("Number of Employees:");

        jTextName.setEnabled(false);
        jTextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameActionPerformed(evt);
            }
        });

        jTextEmployee.setEditable(false);
        jTextEmployee.setEnabled(false);

        jButtonDelete.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/delete.png")); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/save.png")); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseClicked(evt);
            }
        });
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextEmployee)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable_Department.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Department", "Number of Employees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Department.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DepartmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Department);
        if (jTable_Department.getColumnModel().getColumnCount() > 0) {
            jTable_Department.getColumnModel().getColumn(0).setResizable(false);
            jTable_Department.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonNew.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/add.png")); // NOI18N
        jButtonNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNewMouseClicked(evt);
            }
        });

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButtonNew, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
   
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 1) {
            departmentList = new ArrayList<>();
            populateDepartmentTable();
        } else {
            departmentList = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel)jTable_Department.getModel();
            model.setRowCount(0);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTable_DepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DepartmentMouseClicked
        int row = jTable_Department.getSelectedRow();
        TableModel model = jTable_Department.getModel();
        jTextName.setText(model.getValueAt(row, 0).toString());
        jTextEmployee.setText(model.getValueAt(row, 1).toString());
        jTextName.setEnabled(true);
        selectedID = departmentList.get(row).getID();
        mode = 2;
    }//GEN-LAST:event_jTable_DepartmentMouseClicked

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (Integer.parseInt(jTextEmployee.getText()) > 0) {
            JOptionPane.showMessageDialog(null, "Department cannot be deleted if it is still associated with an employee.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            mode = 3;
            String sql = "delete from department where department_id = " + selectedID;
        try {
            database.getStatement().execute(sql);
            departmentList = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel)jTable_Department.getModel();
            model.setRowCount(0);
            populateDepartmentTable();
            jTextName.setText("");
            jTextEmployee.setText("");
            jTextName.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Department has been deleted!", "Attention", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNewMouseClicked
        jTextName.setEnabled(true);
        jTextName.setText("");
        jTextEmployee.setText("0");
        jTextName.grabFocus();
        mode = 1;
    }//GEN-LAST:event_jButtonNewMouseClicked

    private void jButtonSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveMouseClicked
        if (mode == 1) { //new entry
            String sql = "insert into department " + " (name)" + " values ('" +
                    jTextName.getText() + "')";
            try {
                database.getStatement().executeUpdate(sql);
                departmentList = new ArrayList<>();
                DefaultTableModel model = (DefaultTableModel)jTable_Department.getModel();
                model.setRowCount(0);
                populateDepartmentTable();
                jTextName.setEnabled(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (mode == 2) { // edit mode
            String sql = "update department " + " set name = '" + jTextName.getText() + "'" 
                    + " where department_id=" + selectedID;
            try {
                database.getStatement().execute(sql);
                departmentList = new ArrayList<>();
                DefaultTableModel model = (DefaultTableModel)jTable_Department.getModel();
                model.setRowCount(0);
                populateDepartmentTable();
                jTextName.setEnabled(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButtonSaveMouseClicked

    private void jTextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "delete from employee_detail where employee_id = " + selectedempID;
        try {
            int dep = employeeList.get(selectedrow).getDepID();
            for (Department d: departmentList){
                if (d.getID() == dep) {
                    int i = d.getNumEmployees();
                    i = i - 1;
                    String depsql = "UPDATE department SET num_employees = " + Integer.toString(i)
                    + " WHERE department_id = " + Integer.toString(d.getID());
                        try {
                            database.getStatement().execute(depsql);
                            d.setNumEmployees(i);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        database.getStatement().execute(sql);
                        employeeList = new ArrayList<>();
                        DefaultTableModel model = (DefaultTableModel)jTableEmpDetail.getModel();
                        model.setRowCount(0);
                        populateEmpTable();
                }
            }
            JOptionPane.showMessageDialog(null, "The Employee record has been deleted!", "Attention", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableEmpDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpDetailMouseClicked
        int row = jTableEmpDetail.getSelectedRow();
        selectedempID = employeeList.get(row).getID();
        selectedrow = row;
        int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the selected record?", "Select an Option..." ,JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0){
             EmployeeDetail employeeDetail = new EmployeeDetail();
            employeeDetail.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_jTableEmpDetailMouseClicked

    
    private void populateDepartmentTable() {
        try {
            ResultSet myrs = database.getStatement().executeQuery("select * from department");
            Department tableDepartment;
            while (myrs.next()){
                tableDepartment = new Department(myrs.getInt("department_id"), 
                        myrs.getString("name"), myrs.getInt("num_employees"));
                departmentList.add(tableDepartment);
            }
        } catch (Exception e){
            System.out.println("Error");
        }
        
        DefaultTableModel model = (DefaultTableModel)jTable_Department.getModel();
        model.setRowCount(0);
        Object[] row = new Object[2];
        for (int i = 0; i < departmentList.size(); i++) {
            row[0] = departmentList.get(i).getName();
            row[1] = departmentList.get(i).getNumEmployees();
            model.addRow(row);
        }
    }
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEmpDetail;
    private javax.swing.JTable jTable_Department;
    private javax.swing.JTextField jTextEmployee;
    private javax.swing.JTextField jTextName;
    // End of variables declaration//GEN-END:variables
}

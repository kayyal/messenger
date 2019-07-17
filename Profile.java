import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.*;
import java.util.Random;
import java.util.stream.IntStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author Amir
 */
public class Profile extends javax.swing.JDialog {
    public String name;
    public String pass;

    /**
     * Creates new form Profile
     */
    public Profile(java.awt.Frame parent, boolean modal, String name,String pass) {
        this.name=name;
        this.pass=pass;
        initComponents();
        buttonAction();
    }
   public void initcom(){
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               Profile dialog = new Profile(new javax.swing.JFrame(), true,name,pass);
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                   @Override
                   public void windowClosing(java.awt.event.WindowEvent e) {
                       System.exit(0);
                   }
               });
               dialog.setVisible(true);
           }
       });
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        DeletAccountjButton = new javax.swing.JButton();
        editUsernamejButton = new javax.swing.JButton();
        editPasswordjButton = new javax.swing.JButton();
        jTextFieldEditUsername = new javax.swing.JTextField();
        jTextFieldEditPassword = new javax.swing.JTextField();
        BackjButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        PicturejLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 255, 204));

        jLabel1.setText("username");

        jLabel2.setText("password");

        jLabelUsername.setText(name);

        jLabelPassword.setText(pass);


        DeletAccountjButton.setText("Delete Account");
        DeletAccountjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletAccountjButtonActionPerformed(evt);
            }
        });

        editUsernamejButton.setText("Edit Username");

        editPasswordjButton.setText("Edit Password");
        editPasswordjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordjButtonActionPerformed(evt);
            }
        });

        jTextFieldEditUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEditUsernameActionPerformed(evt);
            }
        });

        jTextFieldEditPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEditPasswordActionPerformed(evt);
            }
        });

        BackjButton.setText("Back");
        BackjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                jButtonActionPerformed(evt);
            }
        });
        Random r=new Random();
       int i= r.nextInt(13);
      String a= String.valueOf(i);
        PicturejLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("resourses\\"+a+".png")));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PicturejLabel)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PicturejLabel)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldEditUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldEditPassword))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(editUsernamejButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(editPasswordjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(BackjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(DeletAccountjButton)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabelUsername))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabelPassword)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabelUsername))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabelPassword)))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editUsernamejButton)
                                        .addComponent(jTextFieldEditUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editPasswordjButton)
                                        .addComponent(jTextFieldEditPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeletAccountjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BackjButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void DeletAccountjButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void editPasswordjButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void jTextFieldEditPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void jTextFieldEditUsernameActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */

    }

    public void   buttonAction() {


        this.editUsernamejButton.addActionListener(e -> {

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/massanger_db", "root", "");

                String query = "update users set user_name=? where user_name = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString   (1, jTextFieldEditUsername.getText());
                preparedStmt.setString(2, name);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();

                con.close();
            }
            catch (Exception e2)
            {
                System.err.println(e2.getMessage());
            }
            jLabelUsername.setText(name);
        });
        this.editPasswordjButton.addActionListener(e -> {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/massanger_db", "root", "");

                String query = "update users set user_name=? where user_name = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString   (1, jTextFieldEditPassword.getText());
                preparedStmt.setString(2, pass);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();

                con.close();
            }
            catch (Exception e3)
            {
                System.err.println("Got an exception! ");
                System.err.println(e3.getMessage());
            }
            jLabelPassword.setText(pass);
        });
        this.DeletAccountjButton.addActionListener(e -> {
            String sql = "DELETE FROM users WHERE user_name=?";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/massanger_db", "root", "");
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // set the corresponding param

            pstmt.setString(1, name);
            // execute the delete statement
            pstmt.executeUpdate();


        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }
    System.exit(0);
        });


    }
    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BackjButton;
    private javax.swing.JButton DeletAccountjButton;
    private javax.swing.JButton editPasswordjButton;
    private javax.swing.JButton editUsernamejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JTextField jTextFieldEditPassword;
    private javax.swing.JTextField jTextFieldEditUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel PicturejLabel;

    // End of variables declaration
}

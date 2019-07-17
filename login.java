import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.System.out;
import static java.lang.System.setOut;


public class login extends javax.swing.JFrame {
    // Variables declaration - do not modify
    private javax.swing.JButton jButton_login;
    private javax.swing.JButton jbottom_insert;
    private javax.swing.JLabel jLabel_IP;
    private javax.swing.JLabel jLabel_PASSWORD;
    private javax.swing.JLabel jLabel_PA;
    private javax.swing.JLabel jLabel_real_name;
    private javax.swing.JLabel jLabel_PORT;
    private javax.swing.JLabel jLabel_USERNAME;
    protected javax.swing.JTextField jTextField_ip;
    private javax.swing.JTextField jTextField_password;
    private javax.swing.JTextField jTextField_pa;
    private javax.swing.JTextField jTextField_real_name;
    private javax.swing.JTextField jTextField_port;
    private javax.swing.JTextField jTextField_username;
    public static Connection con;

    /**
     * Creates new form Login
     */
    public login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel_IP = new javax.swing.JLabel();
        jLabel_PORT = new javax.swing.JLabel();
        jLabel_USERNAME = new javax.swing.JLabel();
        jLabel_PASSWORD = new javax.swing.JLabel();
        jLabel_PA = new javax.swing.JLabel();
        jLabel_PA = new javax.swing.JLabel();
        jLabel_real_name = new javax.swing.JLabel();
        jTextField_password = new javax.swing.JTextField();
        jTextField_pa = new javax.swing.JTextField();
        jTextField_real_name = new javax.swing.JTextField();
        jTextField_ip = new javax.swing.JTextField();
        jTextField_port = new javax.swing.JTextField();
        jTextField_username = new javax.swing.JTextField();
        jButton_login = new javax.swing.JButton();
        jbottom_insert=new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        jLabel_IP.setText("IP:");

        jLabel_PORT.setText("PORT:");

        jLabel_USERNAME.setText("USERNAME:");

        jLabel_PASSWORD.setText("PASSWORD:");
        jLabel_PA.setText("");

        jLabel_real_name.setText("REAL_NAME:");


        jButton_login.setText("Login");
        jbottom_insert.setText("Insert");
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });
        {
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel_PASSWORD)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel_real_name)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jTextField_real_name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel_USERNAME)
                                                                            .addComponent(jLabel_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(23, 23, 23)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(jTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                           // .addComponent(jTextField_real_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap(38, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextField_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(38, 38, 38))))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(105, 105, 105)
                                    .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_IP)
                                            .addComponent(jTextField_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_PORT)
                                            .addComponent(jTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_USERNAME)
                                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_PASSWORD)
                                            .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_real_name)
                                            .addComponent(jTextField_real_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addComponent(jButton_login, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                    .addContainerGap())
            );
        }
        pack();







        jbottom_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertAction(evt);
            }
        });
        {
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel_PASSWORD)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel_real_name)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jTextField_real_name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel_USERNAME)
                                                                            .addComponent(jLabel_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(23, 23, 23)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(jTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addContainerGap(38, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextField_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(38, 38, 38))))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(190, 190, 190)
                                    .addComponent(jbottom_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_IP)
                                            .addComponent(jTextField_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_PORT)
                                            .addComponent(jTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_USERNAME)
                                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_PASSWORD)
                                            .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_real_name)
                                            .addComponent(jTextField_real_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addComponent(jbottom_insert, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                    .addContainerGap())
            );
        }
        pack();
    }

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {

        //send data to server
        String user = jTextField_username.getText();
        String pass = jTextField_password.getText();



        try {
            Socket socket = new Socket(jTextField_ip.getText(), 8880);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            int port = socket.getLocalPort();
            String userPass = user + ":" + pass + ":" + port + ":" + socket;

            outputStream.writeUTF(userPass);

            if (inputStream.readBoolean()){

                ClientGUI2 clientGUI = new ClientGUI2(socket);
                clientGUI.setName(user);
                clientGUI.setTitle(user);
                setVisible(true);
//
         //       client.sendMessage(socket,inputStream,outputStream);
            }else{
                JOptionPane.showMessageDialog( null,"Invalid user/pass");

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog( null,"Invalid user/pass");

        }

        //Client client = new Client();

    }//end of jButton_loginActionPerformed



    private void jButton_InsertAction(java.awt.event.ActionEvent evt)  {

        //send data to server
        String user = jTextField_username.getText();
        String pass = jTextField_password.getText();
        String real=jTextField_real_name.getText();
        int n=1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/massanger_db", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users ");
            while (rs.next()) {
             n++;
            }
        }catch (ClassNotFoundException e){
            e.getMessage();
        }
        catch (SQLException e1){
            e1.getMessage();
        }
        int a=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/massanger_db", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users ");
            while (rs.next()) {
                    if (rs.getString(2).equals(user)) {
                        JOptionPane.showMessageDialog(null, "This username already define");
                        a = 1;
                         break;
                    }
            }
            if (a==0){

                insert(n, user, pass, real);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






        //Client client = new Client();

    public static void insert (Integer n,String s,String a,String b) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String t=sdf.format(cal.getTime());
        String sql = "INSERT INTO users(user_id,user_name,user_pass,user_real_name,user_last_seen) VALUES(?,?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getStackTrace());
        }
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/massanger_db", "root", "");

             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1,n);
            pstmt.setString(2,s);
            pstmt.setString(3, a);
            pstmt.setString(4, b);
            pstmt.setString(5,t);
            pstmt.execute();



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);

            }
        });
    }



    // End of variables declaration
}

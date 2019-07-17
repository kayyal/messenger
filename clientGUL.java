//
//
//import javax.swing.*;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.sql.*;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//import static java.lang.System.*;
//
//
//class clientGUI extends javax.swing.JFrame {
//
//    private String name;
//    private String port;
//    private Socket socket;
//    public String mmmm;
//
//    // constructor
//    public clientGUI(Socket socket) {
//        this.socket = socket;
//        initComponents();
//        this.messageHandler();
//        setVisible(true);
//    }
//
//    public  clientGUI(String name, String port) {
//        this.name = name;
//        this.port = port;
//    }
//
//    @Override
//    public String getName() {
//       // System.out.println(name);
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//    //    System.out.println(name);
//        this.name = name;
//    }
//
//    public String getPort() {
//        return port;
//    }
//
//    public void setPort(String port) {
//        this.port = port;
//    }
//
//
//
//    // initComponents method
//    private void initComponents() {
//
//        jScrollPane1 = new javax.swing.JScrollPane();
//        jTextArea_client = new javax.swing.JTextArea();
//        jTextField_client = new javax.swing.JTextField();
//        jButton_client = new javax.swing.JButton();
//        jButton_client1 = new javax.swing.JButton();
//        jButton_client2 = new javax.swing.JButton();
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        jTextArea_client.setColumns(20);
//        jTextArea_client.setRows(5);
//        jScrollPane1.setViewportView(jTextArea_client);
//
//        jTextField_client.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
//
//        jButton_client.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
//        jButton_client.setText("Send");
//        jTextArea_client.setEditable(false);
//
//        jButton_client1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
//        jButton_client1.setText("Profile");
//
//        jButton_client2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
//        jButton_client2.setText("LastSeen");
//
//
//
//
//        {
//            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//            getContentPane().setLayout(layout);
//            layout.setHorizontalGroup(
//                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                    .addContainerGap()
//                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                            .addComponent(jScrollPane1)
//                                            .addGroup(layout.createSequentialGroup()
//                                                    .addComponent(jTextField_client, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                    .addComponent(jButton_client, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
//                                    .addComponent(jButton_client1, GroupLayout.DEFAULT_SIZE,60,Short.MAX_VALUE)
//                                    .addComponent(jButton_client2, GroupLayout.DEFAULT_SIZE,30,Short.MAX_VALUE)
//
//                                    .addContainerGap())
//            );
//            layout.setVerticalGroup(
//                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                    .addContainerGap()
//                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                            .addComponent(jTextField_client)
//                                            .addComponent(jButton_client, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
//                                    .addComponent(jButton_client1, GroupLayout.DEFAULT_SIZE,44,Short.MAX_VALUE)
//                                    .addComponent(jButton_client2, 100,100,100)
//                            .addContainerGap())
//            );
////            javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(getContentPane());
////            getContentPane().setLayout(layout1);
////            layout1.setHorizontalGroup(
////                    layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////                            .addGroup(layout1.createSequentialGroup()
////                                    .addContainerGap()
////                                    .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////                                            .addComponent(jScrollPane1)
////                                            .addGroup(layout1.createSequentialGroup()
////                                                    .addComponent(jTextField_client, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
////                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
////                                                    .addComponent(jButton_client1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
////
////                                    .addContainerGap())
////            );
////            layout1.setVerticalGroup(
////                    layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////                            .addGroup(layout1.createSequentialGroup()
////                                    .addContainerGap()
////                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
////                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
////                                    .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////                                            .addComponent(jTextField_client)
////                                            .addComponent(jButton_client1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
////
////                                    .addContainerGap())
////            );
//        }
//
//        pack();
//    }// </editor-fold>
//
//
//
//    // main method
//    public static void main(String args[]) {
//
//    } // end of main method
//
//
//    // added action to button
//    public void test() throws IOException {
//        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//       // out.println("tse");
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/massanger_db", "root", "");
//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from chat ");
//            while (rs.next()) {
//                //    out.println(rs.getString(1)+" "+mmmm);
//                if (rs.getString(1).equals(mmmm)) {
//                    String s = rs.getString(2);
//                    if (s != null) {
//                        output.writeUTF(s);
//                    }
//                }
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public void   buttonAction(DataOutputStream output) {
//
//
//        this.jButton_client.addActionListener(e -> {
//
//            try {
//                String  message = jTextField_client.getText();
//                jTextField_client.setText("");
//                String [] splitMessage = message.split("#");
//                jTextArea_client.append("\nI said: " + splitMessage[1]);
//                //test(input,splitMessage[1]);
//                insert(splitMessage[1]);
//                sendMessage(output,message);
//            } catch (IOException | ArrayIndexOutOfBoundsException ex) {
//                jTextArea_client.append("\nMessage format wrong" + "\nYour message format look like this--> user#your message");
//
//            }
//
//        });
//        this.jButton_client1.addActionListener(e -> {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/massanger_db", "root", "");
//
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("select * from users ");
//                while (rs.next()) {
//                    if (rs.getString(2).equals(name)) {
//                        String s = rs.getString(5);
//                        Profile pro = new Profile(new javax.swing.JFrame(), true, name, s);
//                        pro.initcom();
//
//
//                    }
//                }
//
//            } catch (SQLException e2) {
//                e2.printStackTrace();
//            } catch (ClassNotFoundException e3) {
//                e3.printStackTrace();
//            }
//        });
//        this.jButton_client2.addActionListener(e -> {
//           connectionHandler connect=new connectionHandler(socket);
//           LastSeenList last=new LastSeenList();
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/massanger_db", "root", "");
//
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("select * from users ");
//                while (rs.next()) {
//
//                        if (!rs.getString(2).equals(name))
//                        //last.jTextArea1.append("\n"+rs.getString(2)+"\t\t"+rs.getString(4));
//
//
//                    }
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//
//            } catch (ClassNotFoundException e2) {
//                e2.printStackTrace();
//            }
//        });
//    }
//
//    //this method handler input message and out put message
//    public void messageHandler(){
//
//        //you must prevent use try with resources because of used thread
//        //if you used try with resources each time socket closed and
//        //give a close socket Exception
//        try {
//            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
//            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//
//
//            //this thread handel output message
//            Thread thread1 = new Thread(() -> {
//
//                buttonAction(outputStream);
//                try {
//                    test();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            });
//            thread1.start();
//
//            //this thread handel input message
//            Thread thread = new Thread(() -> {
//                try {
//                    this.getMessage(inputStream);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread.start();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //this method send message to server
//    public void sendMessage(DataOutputStream output,String message) throws IOException {
//
//
//
//        if(message != null) {
//            output.writeUTF(message);
//
//
//        }
////        }//end of while loop
//
//    }//end of sendMessage method
//
//
//    //this method get message from server
//    public void getMessage(DataInputStream input) throws IOException{
//
//        while (true) {
//
//            String messageIn = input.readUTF();
//            if (messageIn.charAt(0)=='['){
//                  mmmm=messageIn;}
//
//            jTextArea_client.append("\n" + messageIn);
//        }
//
//    }//end of// get message
//
//
//
//    public  void insert (String b) {
//        String sql = "INSERT INTO chat(pm,message) VALUES(?,?)";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        }catch (ClassNotFoundException e){
//            System.out.println(e.getStackTrace());
//        }
//        try (Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/massanger_db", "root", "");
//
//             PreparedStatement pstmt = con.prepareStatement(sql)) {
//            pstmt.setString(1, mmmm);
//            pstmt.setString(2, b);
//            pstmt.execute();
//
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//
//    @Override
//    public String toString() {
//        return "ClientGUI{" +
//                "name='" + name + '\'' +
//                ", port='" + port + '\'' +
//                '}';
//    }
//
//    // Variables declaration - do not modify
//    private javax.swing.JButton jButton_client;
//    private javax.swing.JButton jButton_client1;
//    private javax.swing.JButton jButton_client2;
//
//    static javax.swing.JScrollPane jScrollPane1;
//    static javax.swing.JTextArea jTextArea_client;
//    static javax.swing.JTextField jTextField_client;
//    // End of variables declaration
//}
//

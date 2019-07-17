



import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class connectionHandler implements Runnable {

    private Socket socket;
    private Socket socketUser;
    private static int clientNumber;
    public static Map<String ,Socket> onlineUser = new HashMap<>();
    private String user;
    private server server;

    public connectionHandler(Socket socket) {
        this.socket = socket;
//
    }

    @Override
    public void run() {

        //getting data from the client by inputStream and giving data to the client by outputStream
        try ( DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
              DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());) {

            //before check whether a user is in the list of users in server
            //keep sever's socket in a non static field
            server = new server();
            socketUser = server.getClientSocket();



            //check whether the user is in the users map or not
           // if (!user.equals("null")){
            if(loginHandler(dataInputStream,dataOutputStream)) {

                //count how many client connected to the server
                clientNumber++;
                System.out.println(user + " " + clientNumber + " connected.");

                //keep current client number(client in current thread)
                int num = clientNumber;

                //put user and socket in onlineUser map
                online(socketUser);

                sendToAll(socket);

                while (true) {

                    sendTo(dataInputStream, dataOutputStream);
                }
            }//}


        } catch (IOException  e) {
            System.out.println(user + " disconnected from server");


            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/massanger_db", "root", "");
//here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();



                String sql1 = "UPDATE users SET user_last_seen=? WHERE user_name=?";
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");



                PreparedStatement statement1 = con.prepareStatement(sql1);
                statement1.setString(2, user);

                statement1.setString(1, sdf.format(cal.getTime()));
            } catch (Exception e1) {
                System.out.println(e1);
            }


            onlineUser.remove(user);
        }

    }//end of run method

    //this method check whether user is in the users map's or not
    public boolean loginHandler(DataInputStream input, DataOutputStream output) throws IOException {
        int a = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/massanger_db", "root", "");

            String userinput = input.readUTF();
            String[] check = userinput.split(":");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users ");

            if (a == 0) {
                while (rs.next()) {
                    if (rs.getString(2).equals(check[0]) && rs.getString(5).equals(check[1])) {
                        output.writeBoolean(true);
                        this.user = check[0];
                        return true;
                    }
                }
            }

                if (a != 0) {
                    output.writeBoolean(false);
                    return false;
                }



        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
         return true;
    }



    //this method puts user and socket in the map
    public void online(Socket socket){

        if (!user.equals("null")){
        onlineUser.put(user,socket);}




    }//end of online method

    //this method sends message to the specified user
    public void sendTo(DataInputStream input, DataOutputStream output) throws IOException{

        DataOutputStream outputTo;
        Socket socket;
        String messageIn = input.readUTF();
        String [] messageTo = messageIn.split("#");
        boolean isUser = onlineUser.containsKey(messageTo[0]);


        if(isUser) {
            if (!user.equalsIgnoreCase(messageTo[0])) {
                socket = onlineUser.get(messageTo[0]);
                outputTo = new DataOutputStream(socket.getOutputStream());
                outputTo.writeUTF(user + " said: " + messageTo[1]);
            } else {
                output.writeUTF("Do you want send message to yourself !!!!");
            }
        }
        else {output.writeUTF(messageTo[0] +" doesn't account in server/dont login until now.");}
    }//end of sendTo method

    public static void sendToAll(Socket socket) throws IOException{
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        Set user = onlineUser.keySet();
        output.writeUTF(user.toString());
    }
}//end of class

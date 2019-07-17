

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class client {
    private Socket clientSocket;
    private String userName;
    private String password;

    public client(Socket socket) {
        this.clientSocket = socket;
    }
    public static void func(){
        login login=new login();
        String host=login.jTextField_ip.getText();
        try {
            Socket socket = new Socket(host, 8880);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            client client = new client(socket);

            //if client is in the server
            if (client.userHandler(inputStream, outputStream)) {

                //this thread handel output message
                Thread thread1 = new Thread(() -> {
                    try {
                        client.sendMessage(inputStream, outputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                thread1.start();

                //this thread handel input message
                Thread thread = new Thread(() -> {
                    try {
                        client.getMessage(inputStream);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            } else
                System.out.println("Invalid username/password");

        } catch (IOException e){
            System.out.println("Invalid username/password try again");
            func();
        }
    }
    public static void main(String[] args) {
            func();


    }//end of main method

    //this method send message to server
    public void sendMessage(DataInputStream input, DataOutputStream output) throws IOException {
        System.out.println("Enter your message: ");

        while (true) {
            //System.out.print(userName + ": ");
            Scanner scanner = new Scanner(System.in);
            String msgOut = scanner.nextLine();
            output.writeUTF(msgOut);
            if ("quit".equalsIgnoreCase(msgOut)) {
                System.out.println("you disconnected from server.");
                break;
            }
        }//end of while loop

    }//end of sendMessage method
    //this method get message from server
    public void getMessage(DataInputStream input) throws IOException {

        while (true) {
            String messageIn = input.readUTF();
            System.out.println(messageIn);



        }


    }//end of get message




    //this method check whether the user is in the list of the users in server or not
    public boolean userHandler(DataInputStream input, DataOutputStream output) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your user name: ");
        this.userName = scanner.nextLine();
        System.out.println("Please enter your password");
        this.password = scanner.nextLine();
        String userPass = userName + ":" + password;
        output.writeUTF(userPass);
        if (input.readBoolean())
            return true;
        return false;
    }//end of userHandler method

}//end of class

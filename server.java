


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    private static Socket clientSocket;

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8880)){

            System.out.println("Sever listening for client...");
            while (true){

                Socket socket = serverSocket.accept();
                //after each accept, a copy of created socket puts in static field
                clientSocket = socket;
                connectionHandler connectionHandler = new connectionHandler(socket);
                Thread thread = new Thread(connectionHandler);
                thread.start();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }//end of main method

    //getter for clientSocket
    public Socket getClientSocket(){
        return clientSocket;
    }
}

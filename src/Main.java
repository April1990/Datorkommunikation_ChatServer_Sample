import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        try
        {
            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("Waiting For Connection...");
            //Wait for connection
            Socket clientSocket = serverSocket.accept();
            //Got connection
            System.out.println("Got connection from" + clientSocket.getInetAddress());
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream());
            while (true) {
                String message = input.readLine();
                System.out.println("Got a message:" + message);
                if (message.equals("exit")) {
                    break;
                }
                //Send a message to Client
                output.println("You said:" + message);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
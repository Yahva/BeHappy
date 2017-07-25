import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yahva on 05.07.2017.
 */
public class Server {
    public static void main(String[] args){
        final int PORT=5555;

        ServerSocket socketServer = null;
        Socket socketClient = null;

        BufferedReader in = null;
        PrintWriter out = null;

        String input, output;

        System.out.println("Starting Server");
        try{
            socketServer = new ServerSocket(PORT);
        }catch(IOException e){
            System.out.println("Can not creast socket server");
            System.exit(-1);
        }

        System.out.println("Waiting connection client...");
        try{
            socketClient = socketServer.accept();
            System.out.println("Got connected"+socketClient);
        }catch(IOException e){
            System.out.println("Can not creast socket client");
            System.exit(-1);
        }

        System.out.println("Client Connected!");

        try{
            in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            out = new PrintWriter(socketClient.getOutputStream(),true);

            while ((input=in.readLine())!=null){
                if(input.equalsIgnoreCase("exit")) {
                    break;
                }


                output="Poka";
                out.println(output);
                System.out.println(input);
            }

            in.close();
            out.close();

            socketClient.close();
            socketServer.close();
        }catch(IOException e){
            System.out.println("Can not creast socket client");
            System.exit(-1);
        }

    }
}

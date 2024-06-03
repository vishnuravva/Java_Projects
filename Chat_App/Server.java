package Chat_App;
import java.net.*;
import java.io.*;

public class Server {

    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Server(){
        try{
            server = new ServerSocket(7777);
            System.out.println("Server is ready to accept connection");
            System.out.println("Waiting...");
            socket = server.accept(); // accepts client request / socket object useful for retreiving input stream

            // Buffer reader accepts input from client from one end
            /*
            socket.getInputStream() provides a stream of raw bytes from the client.
new InputStreamReader(socket.getInputStream()) converts these bytes into characters.
new BufferedReader(new InputStreamReader(socket.getInputStream())) buffers the characters and provides methods to read text efficiently.
            * */
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // output will be send from another end to client
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void startReading(){
        Runnable r1 = () -> {
            System.out.println("reader started...");
            try {
                while (true) {


                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client disconnected from chat");
                        socket.close();
                        break;
                    }
                    System.out.println("Client :" + msg);

                }
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("Connection closed");
            }
        };
        new Thread(r1).start();
    }
    public void startWriting(){

        Runnable r2 = () -> {
            System.out.println("Writer started");
            try{
            while(!socket.isClosed()){

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                    if(content.equals("exit")){
                        socket.close();
                        break;
                    }

            }
                System.out.println("COnnection closed");
            }
            catch(Exception e){
                e.printStackTrace();
//                System.out.println("Connection closed");
            }
        };
        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is server");
        new Server();
    }
}

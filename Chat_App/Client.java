package Chat_App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;

public class Client extends JFrame {
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    // GUI code
    private JLabel heading = new JLabel("Client Area");
    private JTextArea messageArea = new JTextArea();
    private JTextField messageInput = new JTextField();
    private Font font = new Font("Roboto",Font.PLAIN,20);

    public Client(){
        try{
            System.out.println("Sending requets ton srevr");
            socket = new Socket("127.0.0.1",7777);
            System.out.println("Connection successful");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // output will be send from another end to client
            out = new PrintWriter(socket.getOutputStream());

            createGui();
            handleEvents();
            startReading();
//            startWriting();
        }catch(Exception e){

        }
    }

    // private because we will call in the class itself
    private void createGui(){

        this.setTitle("Client Messenger");
        this.setSize(600,700);
        this.setLocationRelativeTo(null); // brings window in the center
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when clicked on cross btn of window it closes

        heading.setFont(font);
        heading.setIcon(new ImageIcon("/home/ravva/IdeaProjects/Core_Java_1/src/Networking/chatapp/client.png"));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        messageArea.setEditable(false);
        messageArea.setFont(font);
        messageInput.setFont(font);
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);

        // setting frame's layout
        this.setLayout(new BorderLayout());

        // adding components on the window
        this.add(heading,BorderLayout.NORTH);
        JScrollPane text_area_scroller = new JScrollPane(messageArea);
        this.add(text_area_scroller,BorderLayout.CENTER);
        this.add(messageInput,BorderLayout.SOUTH);

        this.setVisible(true);

    }
    private void handleEvents(){
        messageInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("Key released "+e.getKeyCode()); // for checking key codes
                if(e.getKeyCode() == 10){
                    System.out.println("You have pressed ENTER btn");

                    String contentToSend = messageInput.getText();
                    messageArea.append("Me: "+contentToSend+"\n");
                    out.println(contentToSend);
                    out.flush();
                    messageInput.setText("");
                    messageInput.requestFocus();
                }
            }
        });
    }

    public void startReading(){
        Runnable r1 = () -> {
            System.out.println("reader started...");
            try {
            while(true){

                    String msg = br.readLine();
                    if(msg.equals("exit")){
//                        System.out.println("Server disconnected from chat");
                        JOptionPane.showMessageDialog(this,"Server Terminated the chat");
                        messageInput.setEnabled(false);

                        socket.close();
                        break;
                    }
                    System.out.println("Server :" + msg);
messageArea.append("Server: " + msg + "\n");
            }
                System.out.println("Connection closed");

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
            }
            catch(Exception e){
//                e.printStackTrace();
                System.out.println("Connection closed");
            }
        };
        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is client ");
        new Client();
    }
}

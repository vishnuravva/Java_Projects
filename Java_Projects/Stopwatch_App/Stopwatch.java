package Java_Projects.Stopwatch_App;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame {

    JLabel heading, timeLabel;
    Font font = new Font("Roboto",Font.BOLD,20);
JButton startBtn, stopBtn, resetBtn;
private Timer timer;
private  int elapseSeconds = 0;

    Stopwatch(){
components();
events();
    }

    private void components(){
        setTitle("Stopwatch");
        setLayout(new BorderLayout());
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        heading = new JLabel("Stopwatch");
        heading.setFont(font);

        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(font);
        timeLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        startBtn = new JButton("Start");
        startBtn.setFont(font);

        stopBtn = new JButton("Stop");
        stopBtn.setFont(font);

        resetBtn = new JButton("Reset");
        resetBtn.setFont(font);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                elapseSeconds++;
                System.out.println("elapsed seoonds: " + elapseSeconds);

                int hours = elapseSeconds / 3600;
                int minutes = ( elapseSeconds % 3600 ) / 60;
                int  seconds = elapseSeconds % 60;
                timeLabel.setText(String.format("%02d:%02d:%02d",hours,minutes,seconds));
            }
        });

        JPanel headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headingPanel.setBackground(Color.LIGHT_GRAY); // Set background color
        headingPanel.setOpaque(true);
        headingPanel.add(heading);


        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(timeLabel);


        add(centerPanel,BorderLayout.CENTER);
        add(headingPanel,BorderLayout.NORTH);
        add(startBtn,BorderLayout.WEST);
        add(stopBtn,BorderLayout.EAST);
        add(resetBtn,BorderLayout.SOUTH);

setLocationRelativeTo(null);
        setVisible(true);
    }

    private void events(){
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timer.start();
            }
        });
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timer.stop();
            }
        });
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timer.stop();
                elapseSeconds = 0;
                timeLabel.setText("00:00:00");
            }
        });
    }
}

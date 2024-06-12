package com.mycompany.lms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

    private JPanel reg_heading_panel, nextPanel, btnPanels;
    private Font font = new Font("Arial", Font.BOLD, 25);
    private JLabel heading_label, image_label;
    private JButton reg_nextBtn, loginButton;

    Home() {

        gui();
        events();
    }

    private void gui() {
        setTitle("Libralink - A LMS Platform");
        setSize(900, 750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        heading_label = new JLabel("Libralink - A LMS Platform");
        heading_label.setFont(font);
        heading_label.setBorder(new EmptyBorder(20, 20, 20, 20));

        image_label = new JLabel(new ImageIcon("/home/ravva/NetBeansProjects/LMS/src/main/java/com/mycompany/images/lms.png"));
        image_label.setHorizontalAlignment(JLabel.CENTER);
        reg_heading_panel = new JPanel(new GridLayout(1, 2));
        reg_heading_panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        reg_heading_panel.add(image_label);
        reg_heading_panel.add(heading_label);

        btnPanels = new JPanel();
        nextPanel = new JPanel(new BorderLayout());

        reg_nextBtn = new JButton("Next");

        loginButton = new JButton("Login");

        nextPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        btnPanels.add(reg_nextBtn, BorderLayout.EAST);
        btnPanels.add(loginButton, BorderLayout.WEST);
        nextPanel.add(btnPanels,BorderLayout.EAST);

        add(reg_heading_panel);
        add(nextPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null); // Setting it to null centers the JFrame window on the screen.
        setVisible(true);
    }

    private void events() {
        reg_nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Registration();
                dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Login(Home.this);
                dispose();
            }
        });
    }

}

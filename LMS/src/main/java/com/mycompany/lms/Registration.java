package com.mycompany.lms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ravva
 */
public class Registration extends JFrame {

    private JPanel header_panel, emailPanel, member_details_panel, fullNamePanel, addressPanel, mobilenoPanel, coursePanel,btnLabelPanel;
    private JLabel header_panel_text, emailLabel, details_header, fullnameLabel, addressLabel, mobilenoLabel, courseLabel;
    private Font font = new Font("Arial", Font.BOLD, 25);
    private Font font_small = new Font("Roboto",Font.PLAIN,20);
    private JTextField fullnameField, addressField, mobilenoField, courseField, emailField;

    public Registration() {
        gui();
    }

    private void gui() {
        setTitle("Libralink - A LMS Platform");
        setSize(1000, 750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        header_panel = new JPanel();
        fullNamePanel = new JPanel(new GridLayout(2, 1));
                emailPanel = new JPanel(new GridLayout(2, 1));

        addressPanel = new JPanel(new GridLayout(2, 1));
        mobilenoPanel = new JPanel(new GridLayout(2, 1));
        coursePanel = new JPanel(new GridLayout(2, 1));
        btnLabelPanel =  new JPanel(new GridLayout(2, 1));

        member_details_panel = new JPanel(new GridLayout(6, 2,20,20));

        fullnameLabel = new JLabel("Full Name: ");
                emailLabel = new JLabel("Email Address: ");

        addressLabel = new JLabel("Address: ");
        mobilenoLabel = new JLabel("Mobile No: ");
        courseLabel = new JLabel("Course Enrolled");

        header_panel_text = new JLabel("New Member Registration");
        header_panel_text.setFont(font);

        fullnameField = new JTextField();
         fullnameField.setFont(font_small);
         emailField = new JTextField();
         emailField.setFont(font_small);
         
        addressField = new JTextField();
         addressField.setFont(font_small);
                mobilenoField = new JTextField();
                 mobilenoField.setFont(font_small);
        courseField = new JTextField();
         courseField.setFont(font_small);

        member_details_panel.add(fullNamePanel);
        member_details_panel.setBorder(new EmptyBorder(30,30,30,30));
        
        fullNamePanel.add(fullnameLabel);
        fullNamePanel.add(fullnameField);
        
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        
        addressPanel.add(addressLabel);
                addressPanel.add(addressField);
                mobilenoPanel.add(mobilenoLabel);
                mobilenoPanel.add(mobilenoField);
                 coursePanel.add(courseLabel);
                coursePanel.add(courseField);

        
        
        member_details_panel.add(fullNamePanel);
                member_details_panel.add(emailPanel);

                member_details_panel.add(addressPanel);
        member_details_panel.add(mobilenoPanel);
        member_details_panel.add(coursePanel);

        header_panel.add(header_panel_text);
        header_panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(header_panel, BorderLayout.NORTH);
        add(member_details_panel);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

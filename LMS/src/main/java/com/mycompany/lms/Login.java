/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lms;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login extends JFrame {

    public Login(JFrame parent) {
         setTitle("Libralink - A LMS Platform");
        setSize(1000, 750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        
          setLocationRelativeTo(null); // Setting it to null centers the JFrame window on the screen.
        setVisible(true);
    }
    
    
}

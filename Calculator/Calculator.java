package Java_Projects.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class Calculator extends JFrame {

    private JButton OBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, decimalBtn, backspaceBtn, acBtn, addBtn, subBtn, divBtn, mulBtn, modBtn, equalBtn;
    private JLabel heading;
    private JTextField screen_field;
    private JTextArea result_field;
    private Font font = new Font("Roboto",Font.PLAIN,20);
String screen_value = "";
    Calculator(){
        // initialising components
        gui_components();
        events();

    }
    private void gui_components(){
        setTitle("Basic Calculator");
        setLayout(null);
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        heading = new JLabel("Basic Calculator");
        heading.setBounds(200,0,300,100);

        screen_field = new JTextField("");
        screen_field.setBounds(20,100,460,50);
        screen_field.setFont(font);

        result_field = new JTextArea();
        result_field.setBounds(20,180,460,60);
        result_field.setFont(font);
        result_field.setBorder(null);
        result_field.setEnabled(false);


        acBtn = new JButton("AC");
        acBtn.setBounds(20,300,100,40);

        modBtn = new JButton("%");
        modBtn.setBounds(130,300,100,40);

        divBtn = new JButton("÷");
        divBtn.setBounds(240,300,100,40);


        mulBtn = new JButton("X");
        mulBtn.setBounds(350,300,100,40);

        addBtn = new JButton("+");
        addBtn.setBounds(350,350,100,40);

        subBtn = new JButton("-");
        subBtn.setBounds(350,400,100,40);

        equalBtn = new JButton("=");
        equalBtn.setBounds(350,450,100, 40);


        oneBtn = new JButton("1");
        oneBtn.setBounds(20,350,100,40);

        twoBtn = new JButton("2");
        twoBtn.setBounds(130,350,100, 40);

        threeBtn = new JButton("3");
        threeBtn.setBounds(240,350,100, 40);


        fourBtn = new JButton("4");
        fourBtn.setBounds(20,400,100, 40);

        fiveBtn = new JButton("5");
        fiveBtn.setBounds(130,400,100, 40);

        sixBtn = new JButton("6");
        sixBtn.setBounds(240,400,100, 40);


        sevenBtn = new JButton("7");
        sevenBtn.setBounds(20,450,100, 40);

        eightBtn = new JButton("8");
        eightBtn.setBounds(130,450,100, 40);

        nineBtn = new JButton("9");
        nineBtn.setBounds(240,450,100, 40);


        OBtn = new JButton("0");
        OBtn.setBounds(20,500,100, 40);

        decimalBtn = new JButton(".");
        decimalBtn.setBounds(130,500,100,40);

        backspaceBtn = new JButton("<-");
        backspaceBtn.setBounds(240,500,100,40);


        add(heading);
        add(screen_field);
        add(result_field);
        add(acBtn);
        add(modBtn);
        add(divBtn);
        add(mulBtn);
        add(addBtn);
        add(subBtn);
        add(equalBtn);
        add(oneBtn);
        add(twoBtn);
        add(threeBtn);
        add(fourBtn);
        add(fiveBtn);
        add(sixBtn);
        add(sevenBtn);
        add(eightBtn);
        add(nineBtn);
        add(OBtn);
        add(decimalBtn);
        add(backspaceBtn);

setLocationRelativeTo(null);
        setVisible(true);
    }
    private void events(){
        OBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "0";
                screen_field.setText(screen_value);
            }
        });
        oneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "1";
                screen_field.setText(screen_value);
            }
        });
        twoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "2";
                screen_field.setText(screen_value);
            }
        });
        threeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "3";
                screen_field.setText(screen_value);
            }
        });
        fourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "4";
                screen_field.setText(screen_value);
            }
        });
        fiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "5";
                screen_field.setText(screen_value);
            }
        });
        sixBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "6";
                screen_field.setText(screen_value);
            }
        });
        sevenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "7";
                screen_field.setText(screen_value);
            }
        });
        eightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "8";
                screen_field.setText(screen_value);
            }
        });
        nineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "9";
                screen_field.setText(screen_value);
            }
        });
        modBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "%";
                screen_field.setText(screen_value);
            }
        });
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "/";
                screen_field.setText(screen_value);
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "+";
                screen_field.setText(screen_value);

            }
        });
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "-";
                screen_field.setText(screen_value);
            }
        });
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += "*";
                screen_field.setText(screen_value);
            }
        });
        acBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value = "";
                screen_field.setText(screen_value);
                result_field.setText("");
            }
        });
        decimalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                screen_value += ".";
                screen_field.setText(screen_value);

            }
        });
        equalBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                if(screen_value != null && !screen_value.isEmpty()){
                try {

                    result_field.setText(engine.eval(screen_value).toString());

                } catch (ScriptException e) {
                    result_field.setText("Invalid Expression");
                }
                }else {
                    result_field.setText("");
                }

            }
        });
        backspaceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!screen_value.isEmpty()){
                    screen_field.setText(screen_value.substring(0,screen_value.length() - 1));
                    screen_value = screen_value.substring(0,screen_value.length() - 1);
                }
            }
        });
    }
    public static void main(String[] args) {
        new Calculator();
    }
}

package Java_Projects.Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Todo extends JFrame{
    int task;

    private JTextField task_field;
    private JLabel heading;
    Font font = new Font("Roboto",Font.PLAIN,20);
    private JButton addTaskBtn;
    private JTextArea alltasks;
    ArrayList<String> tasks;
    private JPanel taskPanel;

    Todo(){
        tasks = new ArrayList<String>();
        components();
        events();
//        display();


    }
    private void components(){
        setTitle("Todo App");
        setLayout(null);
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        task_field = new JTextField();
        task_field.setBounds(20,100,550,40);
        task_field.setFont(font);

        addTaskBtn = new JButton("+");
        addTaskBtn.setBounds(580,100,100,40);
        addTaskBtn.setFont(font);

        heading = new JLabel("Todo");
        heading.setBounds(325,20,200,40);
        heading.setFont(font);

//        alltasks = new JTextArea();
//        alltasks.setBounds(20,170,660,450);
//        alltasks.setFont(font);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBounds(20, 150, 660, 500);
        taskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));




        add(heading);
        add(task_field);
        add(addTaskBtn);
        add(taskPanel);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    private void events(){
        addTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!task_field.getText().isEmpty()){
                    tasks.add(task_field.getText());
                    System.out.println(task_field.getText());
                    display();
                    task_field.setText("");
                    System.out.println("tasks : " + tasks );
                }

            }
        });
    }
    private void display(){
        taskPanel.removeAll();
        int size = 170;
        for (int i = 0; i < tasks.size(); i++) {

            JPanel taskItemPanel = new JPanel();
            taskItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel task = new JLabel(tasks.get(i));
            task.setBounds(20,size,580,30);
            task.setFont(font);

            JButton delBtn = new JButton("Del");
            delBtn.setBounds(590,size,75,30);
            delBtn.setFont(font);
            final int index = i;
            delBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    tasks.remove(index);
                    display(); // Refr

                }
            });
            taskItemPanel.add(task);
            taskItemPanel.add(delBtn);
            taskPanel.add(taskItemPanel);
            size+=40;
        }
        taskPanel.revalidate();
        taskPanel.repaint();
    }
    public static void main(String[] args) {
        new Todo();
    }
}



/* ----------------- Version 2 of Todo App ---------- */

//package Swing_Projects;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//public class Todo extends JFrame {
//    private JTextField taskField;
//    private JLabel heading;
//    private Font font = new Font("Roboto", Font.PLAIN, 20);
//    private JButton addTaskBtn;
//    private JPanel taskPanel;
//    private ArrayList<String> tasks;
//
//    public Todo() {
//        tasks = new ArrayList<>();
//        initializeComponents();
//        registerEvents();
//        setVisible(true);
//    }
//
//    private void initializeComponents() {
//        setTitle("Todo App");
//        setLayout(new BorderLayout());
//        setSize(700, 700);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        heading = new JLabel("Todo");
//        heading.setFont(font);
//        heading.setHorizontalAlignment(JLabel.CENTER);
//
//        taskField = new JTextField();
//        taskField.setFont(font);
//
//        addTaskBtn = new JButton("+");
//        addTaskBtn.setFont(font);
//
//        JPanel inputPanel = new JPanel(new BorderLayout());
//        inputPanel.add(taskField, BorderLayout.CENTER);
//        inputPanel.add(addTaskBtn, BorderLayout.EAST);
//
//        taskPanel = new JPanel();
//        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
//
//        add(heading, BorderLayout.NORTH);
//        add(inputPanel, BorderLayout.CENTER);
//        add(taskPanel, BorderLayout.SOUTH);
//    }
//
//    private void registerEvents() {
//        addTaskBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                if (!taskField.getText().isEmpty()) {
//                    String taskText = taskField.getText();
//                    tasks.add(taskText);
//                    addTaskLabel(taskText);
//                    taskField.setText("");
//                    System.out.println("tasks: " + tasks);
//                }
//            }
//        });
//    }
//
//    private void addTaskLabel(String taskText) {
//        JLabel taskLabel = new JLabel(taskText);
//        taskLabel.setFont(font);
//        taskPanel.add(taskLabel);
//        taskPanel.revalidate();
//        taskPanel.repaint();
//    }
//
//    public static void main(String[] args) {
//        new Todo();
//    }
//}

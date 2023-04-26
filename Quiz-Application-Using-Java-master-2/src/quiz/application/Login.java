package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
 
    // Declare instance variables for GUI components
    JButton rules, back; // buttons for navigating to rules and going back to main menu
    JTextField tfname; // text field for entering user's name
    
    Login() {
        // Set background color and layout of JFrame
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        // Add image to JLabel and add to JFrame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500); // set size and position of image label
        add(image);
        
        // Add heading to JFrame
        JLabel heading = new JLabel("Exam Management System");
        heading.setBounds(750, 60, 300, 45); // set size and position of heading label
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        heading.setForeground(new Color(0, 0, 0));
        add(heading);
        
        // Add name label and text field to JFrame
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20); // set size and position of name label
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(0, 0, 0));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25); // set size and position of text field
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        // Add rules and back buttons to JFrame
        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25); // set size and position of rules button
        rules.setBackground(Color.BLACK);
        rules.setForeground(Color.RED);
        rules.addActionListener(this); // add action listener to rules button
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25); // set size and position of back button
        back.setBackground(Color.BLACK);
        back.setForeground(Color.RED);
        back.addActionListener(this); // add action listener to back button
        add(back);
        
        // Set size and location of JFrame and make it visible
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Handle button clicks
        if (ae.getSource() == rules) {
            // If rules button is clicked, retrieve name and create new Rules screen
            String name = tfname.getText();
            setVisible(false); // hide login screen
            new Rules(name); // create new Rules screen with user's name
        } else if (ae.getSource() == back) {
            // If back button is clicked, simply hide login screen
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        // Create new instance of Login class, which launches login screen
        new Login();
    }
}

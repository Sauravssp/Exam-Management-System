package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name; // string variable to store the name of the user
    JButton start, back; // buttons to start the quiz and go back to the previous screen
    
    Rules(String name) { // constructor that takes in the name of the user
        this.name = name; // assign the name passed to the variable
        
        getContentPane().setBackground(Color.WHITE); // set the background color of the frame
        setLayout(null); // set layout to null for custom layout
        
        // add a label to display the welcome message with user's name
        JLabel heading = new JLabel("Welcome " + name + " Online Quiz");
        heading.setBounds(50, 20, 700, 30); // set the position and size of the label
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28)); // set the font of the label
        heading.setForeground(new Color(30, 144, 254)); // set the foreground color of the label
        add(heading); // add the label to the frame
        
        // add a label to display the rules of the quiz
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350); // set the position and size of the label
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16)); // set the font of the label
        rules.setText(
    "<html>" + 
        "1. Focus on providing concise and relevant answers as a programmer." + "<br><br>" +
        "2. Maintain a professional demeanor and avoid unnecessary interactions." + "<br><br>" +
        "3. All questions are compulsory, so give your best effort." + "<br><br>" +
        "4. If you feel overwhelmed, take a moment to compose yourself quietly." + "<br><br>" +
        "5. Remember, it's wise to ask questions and seek clarification when needed." + "<br><br>" +
        "6. Don't compare yourself to others; focus on your own progress." + "<br><br>" +
        "7. Stay strong and determined; this challenge is not for the faint-hearted." + "<br><br>" +
        "8. May your knowledge surpass that of Jon Snow. Good luck!" + "<br><br>" +
    "<html>"
);
add(rules);
 // add the label to the frame
        
        // add a button to go back to the previous screen
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30); // set the position and size of the button
        back.setBackground(new Color(30, 144, 254)); // set the background color of the button
        back.setForeground(Color.RED); // set the foreground color of the button
        back.addActionListener(this); // add an action listener to the button
        add(back); // add the button to the frame
        
        // add a button to start the quiz
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30); // set the position and size of the button
        start.setBackground(new Color(30, 144, 254)); // set the background color of the button
        start.setForeground(Color.RED); // set the foreground color of the button
        start.addActionListener(this); // add an action listener to the button
        add(back);
        
        start = new JButton("Start");  // creates a new JButton object with the text "Start"
start.setBounds(400, 500, 100, 30); // sets the button's size and location on the frame
start.setBackground(new Color(30, 144, 254)); // sets the button's background color
start.setForeground(Color.RED); // sets the button's text color
start.addActionListener(this); // adds an action listener to the button
add(start); // adds the button to the frame

setSize(800, 650); // sets the size of the JFrame to 800x650 pixels
setLocation(350, 100); // sets the location of the JFrame on the screen
setVisible(true); // sets the visibility of the JFrame to true so it can be seen on the screen

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}

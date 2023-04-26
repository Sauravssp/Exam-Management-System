package quiz.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    // Constructor to set the properties of the score window
    Score(String name, int score) {
        setBounds(400, 150, 750, 550); // Setting the bounds of the window
        getContentPane().setBackground(Color.WHITE); // Setting the background color of the window to white
        setLayout(null); // Setting the layout of the window to null
        
        // Adding an image to the window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png")); 
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Creating a label to hold the image
        image.setBounds(0, 200, 300, 250); // Setting the bounds of the label
        add(image); // Adding the label to the window
        
        // Adding a label to display the player's name and a thank you message
        JLabel heading = new JLabel("Thank you " + name + " for playing ");
        heading.setBounds(45, 30, 700, 30); // Setting the bounds of the label
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26)); // Setting the font style and size of the label
        add(heading); // Adding the label to the window
        
        // Adding a label to display the player's score
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30); // Setting the bounds of the label
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26)); // Setting the font style and size of the label
        add(lblscore); // Adding the label to the window
        
        // Adding a button to allow the player to play again
        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30); // Setting the bounds of the button
        submit.setBackground(new Color(30, 144, 255)); // Setting the background color of the button
        submit.setForeground(Color.RED); // Setting the font color of the button
        submit.addActionListener(this); // Adding an action listener to the button
        add(submit); // Adding the button to the window
        
        setVisible(true); // Making the window visible
    }
    
    // Method to handle the button click event
    public void actionPerformed(ActionEvent ae) {
        setVisible(false); // Hiding the current window
        new Login(); // Creating a new instance of the login window
    }

    // Main method to create an instance of the score window
    public static void main(String[] args) {
        new Score("User", 0); // Creating a new instance of the score window with default values
    }
}

package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
       // Create a new JRadioButton object called "opt1"
         opt1 = new JRadioButton();
        // Set the bounds of the opt1 radio button
         opt1.setBounds(170, 520, 700, 30);
         // Set the background color of the opt1 radio button to white
         opt1.setBackground(Color.WHITE);
        // Set the font of the opt1 radio button to "Dialog" with a plain style and a size of 20
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        // Add the opt1 radio button to the Quiz object
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.BLUE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.GREEN);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.RED);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
 public void actionPerformed(ActionEvent ae) {
    // If the "next" button was clicked
    if (ae.getSource() == next) {
        // Repaint the GUI and enable all answer options
        repaint();
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        
        // Record the user's answer
        ans_given = 1;
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
        
        // If this is the last question, disable the "next" button and enable the "submit" button
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        
        // Move on to the next question
        count++;
        start(count);
    }
    // If the "lifeline" button was clicked
    else if (ae.getSource() == lifeline) {
        // Disable two answer options based on the question number
        if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
            opt2.setEnabled(false);
            opt3.setEnabled(false);
        } else {
            opt1.setEnabled(false);
            opt4.setEnabled(false);
        }
        // Disable the "lifeline" button
        lifeline.setEnabled(false);
    }
    // If the "submit" button was clicked
    else if (ae.getSource() == submit) {
        // Record the user's answer
        ans_given = 1;
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }

        // Calculate the user's score by comparing their answers to the correct answers
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            } else {
                score += 0;
            }
        }
        // Hide the current GUI and display the user's score in a new window
        setVisible(false);
        new Score(name, score);
    }
}

  public void paint(Graphics g) {
    super.paint(g); // Calls the superclass paint method to paint the GUI components before painting custom content

    // Create a string for the time left and set the font and color for the text
    String time = "Time left - " + timer + " seconds"; // 15
    g.setColor(Color.RED);
    g.setFont(new Font("Tahoma", Font.BOLD, 25));

    // If the timer is greater than 0, draw the time left text at position (1100, 500), otherwise draw "Times up!!" text
    if (timer > 0) { 
        g.drawString(time, 1100, 500);
    } else {
        g.drawString("Times up!!", 1100, 500);
    }

    // Decrement the timer by 1
    timer--; // 14

    try {
        // Pause the thread for 1 second
        Thread.sleep(1000);
        // Call repaint to trigger a repaint of the GUI components
        repaint();
    } catch (Exception e) {
        // Print the stack trace of any exceptions that occur during the sleep or repaint
        e.printStackTrace();
    }

    // If an answer has been given, reset the timer and set the given answer flag to 0
    if (ans_given == 1) {
        ans_given = 0;
        timer = 15;
    } else if (timer < 0) { // If the timer has reached 0, handle the next or submit button
        timer = 15; // Reset the timer to 15 seconds

        // Enable all the answer options
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);

        // If this is the last question, disable the next button and enable the submit button
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        // If this is the submit button, calculate the score and create a new Score GUI
        if (count == 9) { // submit button
            // Set the user's answer for this question
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            // Calculate the score based on the user's answers and display the Score GUI
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        } else { // If this is the next button, go to the next question
            // Set the user's answer for this question
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            // Increment the question count and start the next question
            count++; // 0 // 1
            start(count);
        }
    }
}

    
   public void start(int count) {
    // Set the question number label to the current question number
    qno.setText("" + (count + 1) + ". ");

    // Set the question label to the current question text
    question.setText(questions[count][0]);

    // Set the text and action command for the first answer option radio button
    opt1.setText(questions[count][1]);
    opt1.setActionCommand(questions[count][1]);

    // Set the text and action command for the second answer option radio button
    opt2.setText(questions[count][2]);
    opt2.setActionCommand(questions[count][2]);

    // Set the text and action command for the third answer option radio button
    opt3.setText(questions[count][3]);
    opt3.setActionCommand(questions[count][3]);

    // Set the text and action command for the fourth answer option radio button
    opt4.setText(questions[count][4]);
    opt4.setActionCommand(questions[count][4]);

    // Clear any previously selected answer option
    groupoptions.clearSelection();
}

    
    public static void main(String[] args) {
        new Quiz("User");
    }
}

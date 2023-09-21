package _00_JButtons_with_Lambdas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LambdaButtons {
    private JFrame window = new JFrame();
    private JButton addNumbers = new JButton("ADD 2 Numbers");
    private JButton randNumber = new JButton("RANDOM NUMBER");
    private JButton tellAJoke = new JButton("TELL A JOKE");

    public LambdaButtons() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        window.add(addNumbers);
        window.add(randNumber);
        window.add(tellAJoke);

        // 1. Call the addActionListener methods for each button. Use lambdas
        //    to define the functionality of the buttons.

        addNumbers.addActionListener(e -> {
            // Define the functionality for the "ADD 2 Numbers" button here
            System.out.println("Adding 2 Numbers");
        });

        randNumber.addActionListener(e -> {
            // Define the functionality for the "RANDOM NUMBER" button here
            System.out.println("Generating a Random Number");
        });

        tellAJoke.addActionListener(e -> {
            // Define the functionality for the "TELL A JOKE" button here
            System.out.println("Telling a Joke");
        });

        window.setVisible(true);
        window.pack();
    }

    public static void main(String[] args) {
        new LambdaButtons();
    }
}

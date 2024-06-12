import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuess extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel messageLabel;
    private JLabel promptLabel;
    private int numberToGuess;
    private int numberOfTries;

    public NumberGuess() {
        // Set up the frame
        setTitle("Guess the Number Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize the random number
        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;
        numberOfTries = 0;

        // Create components
        promptLabel = new JLabel("Enter a number between 1 and 100:");
        guessField = new JTextField(5);
        guessButton = new JButton("Guess");
        messageLabel = new JLabel("");

        // Add components to the frame
        add(promptLabel);
        add(guessField);
        add(guessButton);
        add(messageLabel);

        // Add action listener to the button
        guessButton.addActionListener(new GuessButtonListener());

        // Make the frame visible
        setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int userGuess = Integer.parseInt(guessField.getText());
                numberOfTries++;

                if (userGuess < 1 || userGuess > 100) {
                    messageLabel.setText("Please enter a number between 1 and 100.");
                } else if (userGuess < numberToGuess) {
                    messageLabel.setText("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    messageLabel.setText("Too high! Try again.");
                } else {
                    messageLabel.setText("Correct! You guessed the number in " + numberOfTries + " tries.");
                    guessButton.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number.");
            }
            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        new NumberGuess();
    }
}


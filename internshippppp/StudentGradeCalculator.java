import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {

    private JTextField textFieldMath, textFieldScience, textFieldEnglish;
    private JLabel labelResult;

    public StudentGradeCalculator() {
        // Set up the frame
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Labels and text fields for grades
        JLabel labelMath = new JLabel("Math:");
        labelMath.setBounds(50, 50, 100, 25);
        add(labelMath);

        textFieldMath = new JTextField();
        textFieldMath.setBounds(150, 50, 150, 25);
        add(textFieldMath);

        JLabel labelScience = new JLabel("Science:");
        labelScience.setBounds(50, 100, 100, 25);
        add(labelScience);

        textFieldScience = new JTextField();
        textFieldScience.setBounds(150, 100, 150, 25);
        add(textFieldScience);

        JLabel labelEnglish = new JLabel("English:");
        labelEnglish.setBounds(50, 150, 100, 25);
        add(labelEnglish);

        textFieldEnglish = new JTextField();
        textFieldEnglish.setBounds(150, 150, 150, 25);
        add(textFieldEnglish);

        // Calculate button
        JButton buttonCalculate = new JButton("Calculate Grade");
        buttonCalculate.setBounds(50, 200, 150, 25);
        add(buttonCalculate);

        // Result label
        labelResult = new JLabel("Average Grade: ");
        labelResult.setBounds(50, 250, 300, 25);
        add(labelResult);

        // Button action listener
        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        try {
            double mathGrade = Double.parseDouble(textFieldMath.getText());
            double scienceGrade = Double.parseDouble(textFieldScience.getText());
            double englishGrade = Double.parseDouble(textFieldEnglish.getText());

            double average = (mathGrade + scienceGrade + englishGrade) / 3;

            String grade;
            if (average >= 90) {
                grade = "A";
            } else if (average >= 80) {
                grade = "B";
            } else if (average >= 70) {
                grade = "C";
            } else if (average >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            labelResult.setText(String.format("Average Grade: %.2f (%s)", average, grade));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all grades.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentGradeCalculator().setVisible(true);
            }
        });
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationSystemGUI extends JFrame {
    private JLabel nameLabel, courseLabel;
    private JTextField nameField;
    private JComboBox<String> courseComboBox;
    private JButton registerButton;

    private String[] courses = {"Math", "Science", "History"};

    public StudentRegistrationSystemGUI() {
        setTitle("Student Course Registration System");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        courseLabel = new JLabel("Select Course:");
        add(courseLabel);
        courseComboBox = new JComboBox<>(courses);
        add(courseComboBox);

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                // You can implement the registration logic here
                JOptionPane.showMessageDialog(null, "Registration successful for " + name + " in " + selectedCourse);
            }
        });
        add(registerButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRegistrationSystemGUI();
            }
        });
    }
}

public class StudentManagementSystemGUI {
    private JFrame frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagementSystemGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel rollNumberLabel;
    private JTextField rollNumberTextField;
    private JLabel gradeLabel;
    private JTextField gradeTextField;
    private JButton addButton;
    private JButton removeButton;
    private JButton searchButton;
    private JButton displayButton;
    private JTextArea displayArea;

    private StudentManagementSystem sms;

    public StudentManagementSystemGUI() {
        sms = new StudentManagementSystem();

        frame = new JFrame("Student Management System");

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        rollNumberLabel = new JLabel("Roll Number:");
        rollNumberTextField = new JTextField();

        gradeLabel = new JLabel("Grade:");
        gradeTextField = new JTextField();

        addButton = new JButton("Add Student");
        addButton.addActionListener(new AddButtonListener());

        removeButton = new JButton("Remove Student");
        removeButton.addActionListener(new RemoveButtonListener());

        searchButton = new JButton("Search Student");
        searchButton.addActionListener(new SearchButtonListener());

        displayButton = new JButton("Display All Students");
        displayButton.addActionListener(new DisplayButtonListener());

        displayArea = new JTextArea();

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(rollNumberLabel);
        panel.add(rollNumberTextField);
        panel.add(gradeLabel);
        panel.add(gradeTextField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchButton);
        panel.add(displayButton);
        panel.add(new JScrollPane(displayArea));

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameTextField.getText();
            int rollNumber = Integer.parseInt(rollNumberTextField.getText());
            String grade = gradeTextField.getText();

            Student student = new Student(name, rollNumber, grade);
            sms.addStudent(student);

            nameTextField.setText("");
            rollNumberTextField.setText("");
            gradeTextField.setText("");
        }
    }

    private class RemoveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int rollNumber = Integer.parseInt(rollNumberTextField.getText());
            sms.removeStudent(rollNumber);

            rollNumberTextField.setText("");
        }
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int rollNumber

        public JFrame getFrame() {
            return frame;
        }
}
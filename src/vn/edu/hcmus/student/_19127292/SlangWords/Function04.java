package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import javax.swing.border.EmptyBorder;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 21-Dec-21 - 07:59
 * Description: Function 04 Class
 */
public class Function04 extends JPanel {
    public Function04(HashMap<String, String> dictionary) {
        // Information panel
        JTextField slangTextField = new JTextField();
        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.X_AXIS));
        slangPanel.add(new JLabel("Slang:"));
        slangPanel.add(Box.createHorizontalStrut(21));
        slangPanel.add(slangTextField);

        JTextField meaningTextField = new JTextField();
        JPanel meaningPanel = new JPanel();
        meaningPanel.setLayout(new BoxLayout(meaningPanel, BoxLayout.X_AXIS));
        meaningPanel.add(new JLabel("Meaning:"));
        meaningPanel.add(Box.createHorizontalStrut(5));
        meaningPanel.add(meaningTextField);

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        informationPanel.setBorder(new EmptyBorder(0, 0, 0, 5));
        informationPanel.add(slangPanel);
        informationPanel.add(Box.createVerticalStrut(2));
        informationPanel.add(meaningPanel);

        // Add button
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addButtonEventHandler(
                dictionary, slangTextField.getText(), meaningTextField.getText()));

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JLabel("Add a slang"), BorderLayout.PAGE_START);
        panel.add(informationPanel, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.LINE_END);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 0, 5));
        setLayout(new BorderLayout());

        add(panel, BorderLayout.PAGE_START);
    }

    public void addButtonEventHandler(HashMap<String, String> dictionary, String slang, String meaning) {
        if (dictionary.containsKey(slang)) {
            String[] options = {"Overwrite it", "Only add meaning", "Cancel"};
            int choice = JOptionPane.showOptionDialog(this, "Slang is already existed!",
                    "Slang existed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, options[2]);

            switch (choice) {
                case 0 -> {
                    dictionary.put(slang, meaning);
                    JOptionPane.showMessageDialog(this, "A slang has been overwritten!");
                }
                case 1 -> {
                    dictionary.put(slang, dictionary.get(slang) + "| " + meaning);
                    JOptionPane.showMessageDialog(this, "A meaning has been added to a slang!");
                }
            }
        } else {
            dictionary.put(slang, meaning);
            JOptionPane.showMessageDialog(this, "A slang has been added!");
        }
    }
}

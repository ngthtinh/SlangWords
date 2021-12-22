package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import javax.swing.border.EmptyBorder;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 22-Dec-21 - 22:06
 * Description: Function 05
 */
public class Function05 extends JPanel {
    JTextField slangTextField;
    JTextField meaningTextField;

    public Function05(HashMap<String, String> dictionary) {
        // Find Panel
        JTextField findTextField = new JTextField();

        JButton findButton = new JButton("Find");
        findButton.addActionListener(e -> findButtonEventHandler(dictionary, findTextField.getText()));

        JPanel findPanel = new JPanel();
        findPanel.setLayout(new BoxLayout(findPanel, BoxLayout.X_AXIS));

        findPanel.add(findTextField);
        findPanel.add(Box.createHorizontalStrut(5));
        findPanel.add(findButton);

        // Information Panel
        slangTextField = new JTextField("");
        slangTextField.setEditable(false);
        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.X_AXIS));
        slangPanel.add(new JLabel("Slang:"));
        slangPanel.add(Box.createHorizontalStrut(21));
        slangPanel.add(slangTextField);

        meaningTextField = new JTextField();
        JPanel meaningPanel = new JPanel();
        meaningPanel.setLayout(new BoxLayout(meaningPanel, BoxLayout.X_AXIS));
        meaningPanel.add(new JLabel("Meaning:"));
        meaningPanel.add(Box.createHorizontalStrut(5));
        meaningPanel.add(meaningTextField);

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        informationPanel.setBorder(new EmptyBorder(0, 0, 0, 5));
        informationPanel.add(slangPanel);
        informationPanel.add(Box.createVerticalStrut(5));
        informationPanel.add(meaningPanel);

        // Edit button
        JButton editButton = new JButton("Edit slang");
        editButton.addActionListener(e -> editButtonEventHandler(dictionary, meaningTextField.getText()));

        // Edit Panel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(informationPanel, BorderLayout.CENTER);
        containerPanel.add(editButton, BorderLayout.LINE_END);

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BorderLayout());
        editPanel.setBorder(new EmptyBorder(5, 0, 0, 0));
        editPanel.add(containerPanel, BorderLayout.PAGE_START);

        // Settings and Add components to containerPanel
        setBorder(new EmptyBorder(5, 5, 0, 5));
        setLayout(new BorderLayout());

        add(findPanel, BorderLayout.PAGE_START);
        add(editPanel, BorderLayout.CENTER);
    }

    void findButtonEventHandler(HashMap<String, String> dictionary, String str) {
        String ans = dictionary.get(str);
        slangTextField.setText(ans != null ? str : "");
        meaningTextField.setText(ans != null ? ans : "No slang!");
    }

    void editButtonEventHandler(HashMap<String, String> dictionary, String meaning) {
        if (slangTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please find a correct slang!");
        } else {
            dictionary.put(slangTextField.getText(), meaning);
            JOptionPane.showMessageDialog(this, "Slang edited!");
        }
    }
}

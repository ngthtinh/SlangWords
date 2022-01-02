package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import javax.swing.border.EmptyBorder;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 23-Dec-21 - 23:48
 * Description: Function 06 Class - Delete a Slang Word
 */
public class Function06 extends JPanel {
    /**
     * Default constructor: Add components to Funtion06 JPanel
     * @param dictionary HashMap
     */
    public Function06(HashMap<String, String> dictionary) {
        // Find Panel
        JTextField deleteTextField = new JTextField();

        JButton deleteButton = new JButton("Delete slang");
        deleteButton.addActionListener(e -> deleteButtonEventHandler(dictionary, deleteTextField.getText()));

        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.X_AXIS));

        deletePanel.add(deleteTextField);
        deletePanel.add(Box.createHorizontalStrut(5));
        deletePanel.add(deleteButton);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 0, 5));
        setLayout(new BorderLayout());

        add(deletePanel, BorderLayout.PAGE_START);
    }

    /**
     * Hit Delete Button Event Handler: Change dictionary
     * @param dictionary HashMap
     * @param str String
     */
    void deleteButtonEventHandler(HashMap<String, String> dictionary, String str) {
        String ans = dictionary.get(str);

        if (ans != null) {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Slang: " + str + "\nMeanng: " + ans +
                            "\nDo you really want to delete this slang?",
                    "Delete slang",
                    JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                dictionary.remove(str);
                JOptionPane.showMessageDialog(this, "Deleted: " + str);
            }
        } else JOptionPane.showMessageDialog(this, "No slang: " + str + " to delete.");
    }
}

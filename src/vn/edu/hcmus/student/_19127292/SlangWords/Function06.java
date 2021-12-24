package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 23-Dec-21 - 23:48
 * Description: Function 06 Class
 */
public class Function06 extends JPanel {
    JLabel slangLabel;
    JLabel meaningLabel;

    public Function06(HashMap<String, String> dictionary) {
        // Find Panel
        JTextField findTextField = new JTextField();

        JButton findButton = new JButton("Find");
        findButton.addActionListener(e -> findButtonEventHandler(dictionary, findTextField.getText()));

        JPanel findPanel = new JPanel();
        findPanel.setLayout(new BoxLayout(findPanel, BoxLayout.X_AXIS));

        findPanel.add(findTextField);
        findPanel.add(Box.createHorizontalStrut(5));
        findPanel.add(findButton);

        // Slang Panel
        slangLabel = new JLabel();
        slangLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        slangLabel.setForeground(Color.BLUE);

        meaningLabel = new JLabel();

        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.Y_AXIS));
        slangPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        slangPanel.add(slangLabel);
        slangPanel.add(meaningLabel);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 0, 5));
        setLayout(new BorderLayout());

        add(findPanel, BorderLayout.PAGE_START);
        add(slangPanel, BorderLayout.CENTER);
    }

    void findButtonEventHandler(HashMap<String, String> dictionary, String str) {
        String ans = dictionary.get(str);
        slangLabel.setText(ans != null ? str : "No slang!");
        meaningLabel.setText(ans != null ? "➥ " + ans : "Try another slang!");

        if (ans != null) Function03.addHistory(str);
    }
}

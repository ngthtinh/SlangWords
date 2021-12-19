package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.util.HashMap;
import java.util.Vector;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 18-Dec-21 - 16:43
 * Description: Function 02 Class
 */
public class Function02 extends JPanel {
    JList<String> resultList;

    JLabel slangLabel;
    JLabel meaningLabel;

    public Function02(HashMap<String, String> dictionary) {
        // Find Panel
        JTextField findTextField = new JTextField();

        JButton findButton = new JButton("Find");
        findButton.addActionListener(e -> findButtonEventHandler(dictionary, findTextField.getText()));

        JPanel findPanel = new JPanel();
        findPanel.setLayout(new BoxLayout(findPanel, BoxLayout.X_AXIS));

        findPanel.add(findTextField);
        findPanel.add(Box.createHorizontalStrut(5));
        findPanel.add(findButton);

        // Search results panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBorder(new EmptyBorder(5, 0, 0, 0));
        resultPanel.add(new JLabel("Search results:"), BorderLayout.PAGE_START);
        resultPanel.add(new JScrollPane(resultList = new JList<>()), BorderLayout.CENTER);

        resultList.addListSelectionListener(e -> displaySlang(dictionary, resultList.getSelectedValue()));

        // Slang Panel
        slangLabel = new JLabel();
        slangLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        slangLabel.setForeground(Color.BLUE);

        meaningLabel = new JLabel();

        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.Y_AXIS));
        slangPanel.setBorder(new EmptyBorder(5, 0, 0, 0));

        slangPanel.add(slangLabel);
        slangPanel.add(meaningLabel);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 0, 5));
        setLayout(new BorderLayout());

        add(findPanel, BorderLayout.PAGE_START);
        add(resultPanel, BorderLayout.CENTER);
        add(slangPanel, BorderLayout.PAGE_END);
    }

    void findButtonEventHandler(HashMap<String, String> dictionary, String str) {
        Vector<String> results = new Vector<>();

        dictionary.forEach((slang, meaning) -> {
            if (meaning.contains(str))
                results.add(slang);
        });

        if (results.isEmpty()) {
            slangLabel.setText("No slang!");
            meaningLabel.setText("Try another slang!");
        } else resultList.setListData(results);
    }

    void displaySlang(HashMap<String, String> dictionary, String str) {
        slangLabel.setText(str);
        meaningLabel.setText("➥ " + dictionary.get(str));
    }
}

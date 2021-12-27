package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import java.util.*;
import javax.swing.border.EmptyBorder;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 27-Dec-21 - 23:38
 * Description: Function 08 Class
 */
public class Function08 extends JPanel {
    public Function08(HashMap<String, String> dictionary) {
        Random random = new Random();
        String randomKey = dictionary.keySet().toArray()[
                random.nextInt(dictionary.keySet().toArray().length)].toString();

        // Random Slang Panel
        JLabel randomSlangLabel = new JLabel(randomKey);
        randomSlangLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        randomSlangLabel.setForeground(Color.BLUE);

        JLabel meaningLabel = new JLabel("➥ " + dictionary.get(randomKey));

        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.Y_AXIS));
        slangPanel.add(randomSlangLabel);
        slangPanel.add(Box.createVerticalStrut(5));
        slangPanel.add(meaningLabel);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 0, 5));
        setLayout(new BorderLayout());

        add(slangPanel, BorderLayout.CENTER);
    }
}

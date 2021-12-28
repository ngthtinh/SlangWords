package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.HashMap;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 28-Dec-21 - 21:49
 * Description: Function 09 Class
 */
public class Function09 extends JPanel {
    JLabel questionLabel;
    JButton[] answerButton;

    public Function09(HashMap<String, String> dictionary) {
        // Question Panel
        questionLabel = new JLabel("A?");

        JPanel questionPanel = new JPanel();
        questionPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        questionPanel.add(questionLabel);

        // Answers Panel
        JPanel answersPanel = new JPanel(new GridLayout(2, 2, 5, 5 ));

        answerButton = new JButton[4];
        for (int i = 0; i < 4; i++) {
            answerButton[i] = new JButton("B");
            answersPanel.add(answerButton[i]);
        }

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        add(questionPanel, BorderLayout.PAGE_START);
        add(answersPanel, BorderLayout.CENTER);
    }
}

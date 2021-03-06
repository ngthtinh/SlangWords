package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import javax.swing.border.EmptyBorder;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 30-Dec-21 - 23:16
 * Description: Function 10 Class - Guess Slang
 */
public class Function10 extends JPanel{
    /**
     * Attribute: Dictionary
     */
    HashMap<String, String> dictionary;

    /**
     * Attribute: Question Label
     */
    JLabel questionLabel;

    /**
     * Attribute: Answer Buttons
     */
    JButton[] answerButton;

    /**
     * Attribute: Answer - Integer of 0 1 2 3 for A B C D
     */
    int answer;

    /**
     * Default Constructor: Add components to Function10 JPanel
     * @param dictionary HashMap
     */
    public Function10(HashMap<String, String> dictionary) {
        // Save dictionary
        this.dictionary = dictionary;

        // Question Panel
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        questionLabel.setForeground(Color.BLUE);

        JPanel questionPanel = new JPanel();
        questionPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        questionPanel.add(questionLabel);

        // Answers Panel
        JPanel answersPanel = new JPanel(new GridLayout(2, 2, 5, 5 ));

        answerButton = new JButton[4];

        answerButton[0] = new JButton();
        answerButton[0].addActionListener(e -> answerButtonEventHandler(0));

        answerButton[1] = new JButton();
        answerButton[1].addActionListener(e -> answerButtonEventHandler(1));

        answerButton[2] = new JButton();
        answerButton[2].addActionListener(e -> answerButtonEventHandler(2));

        answerButton[3] = new JButton();
        answerButton[3].addActionListener(e -> answerButtonEventHandler(3));

        answersPanel.add(answerButton[0]);
        answersPanel.add(answerButton[1]);
        answersPanel.add(answerButton[2]);
        answersPanel.add(answerButton[3]);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        add(questionPanel, BorderLayout.PAGE_START);
        add(answersPanel, BorderLayout.CENTER);

        // Create question
        createQuestion();
    }

    /**
     * Create Question
     */
    void createQuestion() {
        Random random = new Random();

        answer = random.nextInt(0, 4);

        for (int i = 0; i < 4; i++) {
            String randomKey = dictionary.keySet().toArray()[
                    random.nextInt(dictionary.keySet().toArray().length)].toString();

            if (i == answer) questionLabel.setText(dictionary.get(randomKey));
            answerButton[i].setText(randomKey);
        }
    }

    /**
     * Hit Answer Button Event Handler
     * @param choice User choice
     */
    void answerButtonEventHandler(int choice) {
        if (choice == answer) {
            JOptionPane.showMessageDialog(this,
                    "Correct!",
                    "Correct answer",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Wrong! The answer is " + answerButton[answer].getText(),
                    "Wrong answer",
                    JOptionPane.ERROR_MESSAGE);
        }

        createQuestion();
    }
}

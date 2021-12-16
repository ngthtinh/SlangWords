package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;


/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 16-Dec-21 - 20:48
 * Description: Main Frame
 */
public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        addComponents();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Slang Words");
        setVisible(true);
    }

    public void addComponents() {
        // Content Pane Layout
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Title Label
        JLabel titleLabel = new JLabel("Slang Words", JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(5, 5, 5 ,5));

        // About Label
        JLabel aboutLabel = new JLabel("Nguyễn Thanh Tình - 19127292 - Introduction to Java - 19KTPM3", JLabel.RIGHT);
        aboutLabel.setBorder(new EmptyBorder(5, 5, 5, 5));

        // View Panel
        JPanel viewPanel = new JPanel();

        // Menu Panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton functionButton1 = new JButton("Function 1");
        functionButton1.addActionListener(e -> {});

        JButton functionButton2 = new JButton("Function 2");
        functionButton2.addActionListener(e -> {});

        JButton functionButton3 = new JButton("Function 3");
        functionButton3.addActionListener(e -> {});

        JButton functionButton4 = new JButton("Function 4");
        functionButton4.addActionListener(e -> {});

        JButton functionButton5 = new JButton("Function 5");
        functionButton5.addActionListener(e -> {});

        JButton functionButton6 = new JButton("Function 6");
        functionButton6.addActionListener(e -> {});

        JButton functionButton7 = new JButton("Function 7");
        functionButton7.addActionListener(e -> {});

        JButton functionButton8 = new JButton("Function 8");
        functionButton8.addActionListener(e -> {});

        JButton functionButton9 = new JButton("Function 9");
        functionButton9.addActionListener(e -> {});

        JButton functionButton10 = new JButton("Function 10");
        functionButton10.addActionListener(e -> {});

        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(10, 0, 0, 5));

        buttonContainer.add(functionButton1);
        buttonContainer.add(functionButton2);
        buttonContainer.add(functionButton3);
        buttonContainer.add(functionButton4);
        buttonContainer.add(functionButton5);
        buttonContainer.add(functionButton6);
        buttonContainer.add(functionButton7);
        buttonContainer.add(functionButton8);
        buttonContainer.add(functionButton9);
        buttonContainer.add(functionButton10);

        menuPanel.add(buttonContainer, BorderLayout.PAGE_START);

        // Add components to Content Pane and settings
        contentPane.add(titleLabel, BorderLayout.PAGE_START);
        contentPane.add(aboutLabel, BorderLayout.PAGE_END);
        contentPane.add(viewPanel, BorderLayout.CENTER);
        contentPane.add(menuPanel, BorderLayout.LINE_START);

        setContentPane(contentPane);
        pack();
    }
}

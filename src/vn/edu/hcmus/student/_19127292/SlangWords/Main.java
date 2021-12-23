package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.util.HashMap;
import javax.swing.border.EmptyBorder;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 16-Dec-21 - 20:48
 * Description: Main Frame
 */
public class Main extends JFrame {
    HashMap<String, String> dictionary;
    JPanel viewPanel;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        loadDictionary();
        addComponents();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Slang Words");
        setVisible(true);
    }

    public void loadDictionary() {
        dictionary = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("slang.txt"));
            bufferedReader.readLine(); // Skip first line

            String line;
            while ((line = bufferedReader.readLine())!= null) {
                String[] str = line.split("`");
                if (str.length == 2)
                    dictionary.put(str[0], str[1]); // Only add lines in correct format
            }
        } catch (Exception exception) {
            System.out.println("Error: "+ exception);
        }
    }

    public void addComponents() {
        // Content Pane Layout
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Title Label
        JLabel titleLabel = new JLabel("S L A N G       W O R D S", JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(5, 5, 5 ,5));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // About Label
        JLabel aboutLabel = new JLabel("Nguyễn Thanh Tình - 19127292 - Introduction to Java - 19KTPM3", JLabel.RIGHT);
        aboutLabel.setBorder(new EmptyBorder(5, 5, 5, 5));

        // View Panel
        viewPanel = new JPanel();

        // Menu Panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton functionButton01 = new JButton("Find by slang");
        functionButton01.addActionListener(e -> changeView(new Function01(dictionary)));

        JButton functionButton02 = new JButton("Find by definition");
        functionButton02.addActionListener(e -> changeView(new Function02(dictionary)));

        JButton functionButton03 = new JButton("History");
        functionButton03.addActionListener(e -> changeView(new Function03(dictionary)));

        JButton functionButton04 = new JButton("Add a slang");
        functionButton04.addActionListener(e -> changeView(new Function04(dictionary)));

        JButton functionButton05 = new JButton("Edit a slang");
        functionButton05.addActionListener(e -> changeView(new Function05(dictionary)));

        JButton functionButton06 = new JButton("Delete a slang");
        functionButton06.addActionListener(e -> changeView(new Function06(dictionary)));

        JButton functionButton07 = new JButton("Function 07");
        functionButton07.addActionListener(e -> {});

        JButton functionButton08 = new JButton("Function 08");
        functionButton08.addActionListener(e -> {});

        JButton functionButton09 = new JButton("Function 09");
        functionButton09.addActionListener(e -> {});

        JButton functionButton10 = new JButton("Function 10");
        functionButton10.addActionListener(e -> {});

        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(10, 0, 0, 5));

        buttonContainer.add(functionButton01);
        buttonContainer.add(functionButton02);
        buttonContainer.add(functionButton03);
        buttonContainer.add(functionButton04);
        buttonContainer.add(functionButton05);
        buttonContainer.add(functionButton06);
        buttonContainer.add(functionButton07);
        buttonContainer.add(functionButton08);
        buttonContainer.add(functionButton09);
        buttonContainer.add(functionButton10);

        menuPanel.add(buttonContainer, BorderLayout.PAGE_START);

        // Add components to Content Pane and settings
        contentPane.add(titleLabel, BorderLayout.PAGE_START);
        contentPane.add(aboutLabel, BorderLayout.PAGE_END);
        contentPane.add(viewPanel, BorderLayout.CENTER);
        contentPane.add(menuPanel, BorderLayout.LINE_START);

        setPreferredSize(new Dimension(700, 500));
        setContentPane(contentPane);
        pack();
    }

    void changeView(JPanel newView) {
        remove(viewPanel);
        add(viewPanel = newView);
        validate();
    }
}

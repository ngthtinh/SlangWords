package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 20-Dec-21 - 02:32
 * Description: Function 03 Class
 */
public class Function03 extends JPanel {
    JLabel slangLabel;
    JLabel meaningLabel;

    private static Vector<String> historySlangs = new Vector<>();

    public static void addHistory(String str) {
        if (!historySlangs.contains(str)) historySlangs.add(str);
    }

    @SuppressWarnings("unchecked")
    public static void loadHistory() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("History.DAT"));
            historySlangs = (Vector<String>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception exception) {
            assert true;
        }
    }

    public static void saveHistory() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("History.DAT"));
            objectOutputStream.writeObject(historySlangs);
            objectOutputStream.close();
        } catch (Exception exception) {
            assert true;
        }
    }

    public Function03(HashMap<String, String> dictionary) {
        // History List
        JList<String> historyList = new JList<>(historySlangs);
        historyList.addListSelectionListener(e -> displaySlang(dictionary, historyList.getSelectedValue()));

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

        add(new JLabel("Slang words you searched:"), BorderLayout.PAGE_START);
        add(new JScrollPane(historyList), BorderLayout.CENTER);
        add(slangPanel, BorderLayout.PAGE_END);
    }

    void displaySlang(HashMap<String, String> dictionary, String str) {
        slangLabel.setText(str);
        meaningLabel.setText("➥ " + dictionary.get(str));
    }
}

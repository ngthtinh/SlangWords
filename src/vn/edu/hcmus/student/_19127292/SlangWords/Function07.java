package vn.edu.hcmus.student._19127292.SlangWords;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.util.HashMap;

/**
 * vn.edu.hcmus.student._19127292.SlangWords
 * Created by 19127292 - Nguyen Thanh Tinh
 * Date 26-Dec-21 - 21:20
 * Description: Function 07 Class
 */
public class Function07 {
    public static void resetDictionary(Component parentComponent, HashMap<String, String> dictionary) {
        int choice = JOptionPane.showConfirmDialog(parentComponent,
                "Do you really want to reset dictionary?",
                "Reset dictionary",
                JOptionPane.YES_NO_OPTION);

        if (choice == 0) {
            dictionary.clear();

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

            JOptionPane.showMessageDialog(parentComponent, "Dictionary reset!");
        }
    }
}

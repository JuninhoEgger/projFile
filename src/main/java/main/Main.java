package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        String[] lines = new String[]{"Good morning", "Good afternoon", "Good night"};
        String path = "C:\\temp\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            showMessageDialog(null, "DEU TUDO CERTO!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            StringBuilder response = new StringBuilder();
            while (line != null) {
                response.append(line).append("\n");
                line = br.readLine();
            }
            showMessageDialog(null, response);
        } catch (IOException e) {
            showMessageDialog(null, "ERROR: " + e.getMessage());
        }
    }
}

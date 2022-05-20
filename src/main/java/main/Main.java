package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\temp\\in.txt");
        Scanner leia = null;

        try {
            leia = new Scanner(file);
            StringBuilder resposta = new StringBuilder();
            while (leia.hasNextLine()) {
                resposta.append(leia.nextLine() + "\n");
            }
            showMessageDialog(null, resposta);
        } catch (IOException e) {
            showMessageDialog(null, "ERROR: " + e.getMessage());
        } finally {
            if (leia != null) {
                leia.close();
            }
        }
    }
}

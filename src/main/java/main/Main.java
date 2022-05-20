package main;

import java.io.File;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {
        File path = new File(showInputDialog("ENTER A FILE PATH"));
        showMessageDialog(null, "getName: " + path.getName());
        showMessageDialog(null, "getParent: " + path.getParent());
        showMessageDialog(null, "getPath: " + path.getPath());
    }
}

package main;

import java.io.File;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        String strPath;
        strPath = showInputDialog("ENTER A FOLDER PATH: ");
        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        File[] files = path.listFiles(File::isFile);

        StringBuilder responseFolders = new StringBuilder();
        StringBuilder responseFiles = new StringBuilder();

        assert folders != null;
        for (File folder : folders) {
            responseFolders.append(folder).append("\n");
        }

        assert files != null;
        for (File file : files) {
            responseFiles.append(file).append("\n");
        }

        showMessageDialog(
                null,
                "FOLDERS\n" + responseFolders + "\n" +
                        "FILES\n" + responseFiles);

        boolean success = new File(strPath + "\\subdir").mkdir();
        showMessageDialog(null, "DIRECTORY CREATED SUCCESSFULLY: " + success);

    }
}

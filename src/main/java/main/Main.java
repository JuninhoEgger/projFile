package main;

import entities.product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        String sourceFileStr = showInputDialog("Enter file path: ");
        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();
        boolean success = new File(sourceFolderStr + "\\out").mkdir();
        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                for (Product item : list) {
                    bw.write(item.getName() + "," + format("%.2f", item.total()));
                    bw.newLine();
                }
                showMessageDialog(null, targetFileStr + " CREATED!");

            } catch (IOException e) {
                showMessageDialog(null, "Error writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ProductSalesApp extends JFrame {
    private JTextArea textArea;
    private JLabel yearsProcessedLabel;
    private int yearsProcessed = 0;
    private double[] salesData;
    private double salesLimit = 400; // Example sales limit

    public ProductSalesApp() {
        setLayout(new BorderLayout());

        // Menu setup
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadDataItem = new JMenuItem("Load Product Data");
        JMenuItem saveDataItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        loadDataItem.addActionListener(e -> loadProductData());
        saveDataItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());
        toolsMenu.add(loadDataItem);
        toolsMenu.add(saveDataItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem editSalesLimitItem = new JMenuItem("Edit Sales Limit");
        editSalesLimitItem.addActionListener(e -> editSalesLimit());
        JMenuItem editDataItem = new JMenuItem("Edit Data");
        editDataItem.addActionListener(e -> editData());
        editMenu.add(editSalesLimitItem);
        editMenu.add(editDataItem);
        menuBar.add(editMenu);

        // Format menu
        JMenu formatMenu = new JMenu("Format");
        JMenuItem fontSizeItem = new JMenuItem("Font Size");
        fontSizeItem.addActionListener(e -> changeFontSize());
        JMenuItem fontStyleItem = new JMenuItem("Font Style");
        fontStyleItem.addActionListener(e -> changeFontStyle());
        formatMenu.add(fontSizeItem);
        formatMenu.add(fontStyleItem);
        menuBar.add(formatMenu);

        // View menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem viewDataLogItem = new JMenuItem("View Data Log");
        viewDataLogItem.addActionListener(e -> viewDataLog());
        viewMenu.add(viewDataLogItem);
        menuBar.add(viewMenu);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAboutDialog());
        JMenuItem userGuideItem = new JMenuItem("User Guide");
        userGuideItem.addActionListener(e -> showUserGuide());
        helpMenu.add(aboutItem);
        helpMenu.add(userGuideItem);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Text area and label setup
        textArea = new JTextArea(10, 20);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        yearsProcessedLabel = new JLabel("Years Processed: 0");
        add(yearsProcessedLabel, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadProductData() {
        // Simulating loading data from memory
        salesData = new double[]{300, 450, 200, 500, 350, 250}; // Example data
        calculateAndDisplaySales();
    }

    private void calculateAndDisplaySales() {
        if (salesData == null) return;
        double totalSales = 0;
        int overLimit = 0, underLimit = 0;
        for (double sale : salesData) {
            totalSales += sale;
            if (sale > salesLimit) overLimit++;
            else underLimit++;
        }
        double avgSales = salesData.length > 0 ? totalSales / salesData.length : 0;
        yearsProcessed = salesData.length;
        String output = "DATA LOG\n";
        output += "\n";
        output += "Total Sales: " + totalSales + "\n";
        output += "Average Sales: " + avgSales + "\n";
        output += "Sales over limit: " + overLimit + "\n";
        output += "Sales under limit: " + underLimit;
        textArea.setText(output);
        yearsProcessedLabel.setText("Years Processed: " + yearsProcessed);
    }

    private void saveProductData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data");
        }
    }

    private void clearData() {
        textArea.setText("");
        yearsProcessedLabel.setText("Years Processed: 0");
        yearsProcessed = 0;
        salesData = null;
    }

    private void editSalesLimit() {
        String input = JOptionPane.showInputDialog(this, "Enter new sales limit:");
        try {
            salesLimit = Double.parseDouble(input);
            JOptionPane.showMessageDialog(this, "Sales limit updated to " + salesLimit);
            calculateAndDisplaySales();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }

    private void editData() {
        if (salesData == null) {
            JOptionPane.showMessageDialog(this, "No data to edit");
            return;
        }
        String input = JOptionPane.showInputDialog(this, "Enter new data (comma-separated values):");
        try {
            String[] values = input.split(",");
            salesData = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                salesData[i] = Double.parseDouble(values[i].trim());
            }
            calculateAndDisplaySales();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }

    private void changeFontSize() {
        String input = JOptionPane.showInputDialog(this, "Enter new font size:");
        try {
            int fontSize = Integer.parseInt(input);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }

    private void changeFontStyle() {
        String[] options = {"Plain", "Bold", "Italic"};
        int choice = JOptionPane.showOptionDialog(this, "Select font style:", "Font Style", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (choice) {
            case 0:
                textArea.setFont(new Font("Monospaced", Font.PLAIN, textArea.getFont().getSize()));
                break;
            case 1:
                textArea.setFont(new Font("Monospaced", Font.BOLD, textArea.getFont().getSize()));
                break;
            case 2:
                textArea.setFont(new Font("Monospaced", Font.ITALIC, textArea.getFont().getSize()));
                break;
        }
    }

    private void viewDataLog() {
        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data to view");
            return;
        }
        JOptionPane.showMessageDialog(this, textArea.getText(), "Data Log", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this, "Product Sales App\nVersion 1.0\nCopyright 2023", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showUserGuide() {
        String guide = "1. Load product data using the 'Load Product Data' option in the 'Tools' menu.\n" +
                "2. Edit sales limit using the 'Edit Sales Limit' option in the 'Edit' menu.\n" +
                "3. View data log using the 'View Data Log' option in the 'View' menu.\n" +
                "4. Save data using the 'Save Product Data' option in the 'Tools' menu.";
        JOptionPane.showMessageDialog(this, guide, "User Guide", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new ProductSalesApp();
    }
}

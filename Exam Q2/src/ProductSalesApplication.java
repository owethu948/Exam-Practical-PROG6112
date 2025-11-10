import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProductSalesApplication extends JFrame {

    private int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
    };
    private final int salesLimit = 500;

    private JTextArea displayArea;
    private JLabel yearsProcessedLabel;

    public ProductSalesApplication() {
        setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Display area for sales data
        displayArea = new JTextArea(10, 20);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Label for years processed
        yearsProcessedLabel = new JLabel("Years Processed: " + productSales.length);
        add(yearsProcessedLabel, BorderLayout.SOUTH);

        // Button actions
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySalesData();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });

        displaySalesData();

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Product Sales Application");
        setVisible(true);
    }

    private void displaySalesData() {
        int totalSales = 0;
        int count = 0;
        int overLimit = 0;
        int underLimit = 0;

        for (int[] year : productSales) {
            for (int sale : year) {
                totalSales += sale;
                count++;
                if (sale > salesLimit) {
                    overLimit++;
                } else {
                    underLimit++;
                }
            }
        }

        double averageSales = (double) totalSales / count;

        displayArea.setText(
                "Total Sales: " + totalSales + "\n" +
                "Average Sales: " + Math.round(averageSales) + "\n" +
                "Sales over limit: " + overLimit + "\n" +
                "Sales under limit: " + underLimit
        );
    }

    private void saveProductData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("product_sales.txt"))) {
            writer.write("Total Sales: " + getTotalSales(productSales) + "\n");
            writer.write("Average Sales: " + Math.round(getAverageSales(productSales)) + "\n");
            writer.write("Sales over limit: " + getOverLimit(productSales) + "\n");
            writer.write("Sales under limit: " + getUnderLimit(productSales));
            JOptionPane.showMessageDialog(this, "Data saved to product_sales.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }
    }

    private int getTotalSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    private double getAverageSales(int[][] productSales) {
        int total = getTotalSales(productSales);
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return (double) total / count;
    }

    private int getOverLimit(int[][] productSales) {
        int overLimit = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > salesLimit) {
                    overLimit++;
                }
            }
        }
        return overLimit;
    }

    private int getUnderLimit(int[][] productSales) {
        int underLimit = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale <= salesLimit) {
                    underLimit++;
                }
            }
        }
        return underLimit;
    }

    public static void main(String[] args) {
        new ProductSalesApplication();
    }
}
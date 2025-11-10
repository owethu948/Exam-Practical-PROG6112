// Define the interface
interface IProductSales {
    int TotalSales(int[][] productSales);
    double AverageSales(int[][] productSales);
    int MaxSale(int[][] productSales);
    int MinSale(int[][] productSales);
}

// Implement the ProductSales class
class ProductSales implements IProductSales {
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return (double) total / count;
    }

    @Override
    public int MaxSale(int[][] productSales) {
        int max = Integer.MIN_VALUE;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        int min = Integer.MAX_VALUE;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
        };
        
        ProductSales sales = new ProductSales();
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("Total sales: " + sales.TotalSales(productSales));
        System.out.println("Average sales: " + Math.round(sales.AverageSales(productSales)));
        System.out.println("Maximum sale: " + sales.MaxSale(productSales));
        System.out.println("Minimum sale: " + sales.MinSale(productSales));
    }
}
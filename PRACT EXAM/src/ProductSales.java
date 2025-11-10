public class ProductSales implements IProduct {

    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                total += sale;
            }
        }
        return total;
    }

    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        return (double) total / count;
    }

    public int MaxSale(int[][] productSales) {
        int max = Integer.MIN_VALUE;
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    public int MinSale(int[][] productSales) {
        int min = Integer.MAX_VALUE;
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        ProductSales ps = new ProductSales();

        int[][] productSales = { {300,150,700}, {250,200,600} };

        System.out.println("Total Sales: " + ps.TotalSales(productSales));
        System.out.println("Average Sales: " + ps.AverageSales(productSales));
        System.out.println("Maximum Sale: " + ps.MaxSale(productSales));
        System.out.println("Minimum Sale: " + ps.MinSale(productSales));
    }
}

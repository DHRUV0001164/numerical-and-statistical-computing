import java.util.Scanner;

public class newtonforward {

    // Function to calculate factorial
    static double factorial(int n) {
        double fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of data points: ");
        int n = sc.nextInt();

        double[] x = new double[n];
        double[][] y = new double[n][n];

        // Input x values
        System.out.println("Enter x values:");
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
        }

        // Input y values
        System.out.println("Enter y values:");
        for(int i = 0; i < n; i++) {
            y[i][0] = sc.nextDouble();
        }

        // Check equal spacing (important)
        double h = x[1] - x[0];
        for(int i = 2; i < n; i++) {
            if(Math.abs((x[i] - x[i-1]) - h) > 1e-6) {
                System.out.println("Error: x values are not equally spaced.");
                return;
            }
        }

        // Build forward difference table
        for(int j = 1; j < n; j++) {
            for(int i = 0; i < n - j; i++) {
                y[i][j] = y[i+1][j-1] - y[i][j-1];
            }
        }

        // Input value to interpolate
        System.out.print("Enter value of x: ");
        double value = sc.nextDouble();

        double u = (value - x[0]) / h;

        // Apply Newton Forward formula
        double result = y[0][0];
        double uTerm = 1;

        for(int i = 1; i < n; i++) {
            uTerm *= (u - (i - 1));
            result += (uTerm * y[0][i]) / factorial(i);
        }

        // Output result
        System.out.println("Interpolated value = " + result);

        sc.close();
    }
}
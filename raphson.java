public class raphson {
    public static void main(String[] args) {
        double x0 = 1.0; // Initial guess
        double tolerance = 1e-6; // Tolerance for convergence
        int maxIterations = 100; // Maximum number of iterations

        double root = findRoot(x0, tolerance, maxIterations);
        System.out.println("Approximate root: " + root);
    }

    public static double findRoot(double x0, double tolerance, int maxIterations) {
        double x = x0;
        for (int i = 0; i < maxIterations; i++) {
            double fx = f(x);
            double dfx = df(x);

            if (dfx == 0) {
                System.out.println("Derivative is zero. No solution found.");
                return Double.NaN;
            }

            double x1 = x - fx / dfx; // Newton-Raphson formula

            if (Math.abs(x1 - x) < tolerance) {
                return x1; // Convergence achieved
            }

            x = x1; // Update for next iteration
        }
        System.out.println("Maximum iterations reached. Approximate root: " + x);
        return x;
    }

    // Example function: f(x) = x^2 - 2
    public static double f(double x) {
        return x * x - 2;
    }

    // Derivative of the example function: f'(x) = 2x
    public static double df(double x) {
        return 2 * x;
    }
    
}

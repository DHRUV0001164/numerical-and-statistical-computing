public class bisection {
    public static void main(String[] args) {
        double a = 0.0; // Start of interval
        double b = 2.0; // End of interval
        double tolerance = 1e-6; // Tolerance for convergence
        int maxIterations = 100; // Maximum number of iterations

        double root = findRoot(a, b, tolerance, maxIterations);
        System.out.println("Approximate root: " + root);
    }

    public static double findRoot(double a, double b, double tolerance, int maxIterations) {
        if (f(a) * f(b) >= 0) {
            System.out.println("The function has the same signs at the endpoints. No solution found.");
            return Double.NaN;
        }

        double c = a; // Midpoint
        for (int i = 0; i < maxIterations; i++) {
            c = (a + b) / 2; // Midpoint

            if (Math.abs(f(c)) < tolerance) {
                return c; // Convergence achieved
            }

            if (f(a) * f(c) < 0) {
                b = c; // The root is in [a, c]
            } else {
                a = c; // The root is in [c, b]
            }
        }
        System.out.println("Maximum iterations reached. Approximate root: " + c);
        return c;
    }

    // Example function: f(x) = x^2 - 2
    public static double f(double x) {
        return x * x - 2;
    }
    
}

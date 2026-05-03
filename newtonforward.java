public class newtonforward {
    public static void main(String[] args) {
        double x0 = 1; // Initial guess
        double tol = 1e-6; // Tolerance
        int maxIter = 100; // Maximum iterations

        double root = newtonForward(x0, tol, maxIter);
        System.out.println("Root: " + root);
    }

    public static double newtonForward(double x0, double tol, int maxIter) {
        double x = x0;
        for (int i = 0; i < maxIter; i++) {
            double fx = f(x);
            double dfx = df(x);

            if (Math.abs(dfx) < tol) {
                throw new IllegalArgumentException("Derivative is too small.");
            }

            double xNew = x - fx / dfx; // Newton's method formula

            if (Math.abs(xNew - x) < tol) {
                return xNew; // Found a root
            }

            x = xNew;
        }
        return x; // Return the best estimate after max iterations
    }

    public static double f(double x) {
        return x * x - 2; // Example function: f(x) = x^2 - 2
    }

    public static double df(double x) {
        return 2 * x; // Derivative: f'(x) = 2x
    }
}

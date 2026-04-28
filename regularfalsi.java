class regularfalsi {
    public static void main(String[] args) {
        double a = 0; // Initial guess
        double b = 1; // Initial guess
        double tol = 1e-6; // Tolerance
        int maxIter = 100; // Maximum iterations

        double root = regularFalsi(a, b, tol, maxIter);
        System.out.println("Root: " + root);
    }

    public static double regularFalsi(double a, double b, double tol, int maxIter) {
        double fa = f(a);
        double fb = f(b);

        if (fa * fb >= 0) {
            throw new IllegalArgumentException("The function must have different signs at a and b.");
        }

        for (int i = 0; i < maxIter; i++) {
            double c = (a * fb - b * fa) / (fb - fa); // Compute the new approximation
            double fc = f(c);

            if (Math.abs(fc) < tol) {
                return c; // Found a root
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }

        return (a + b) / 2; // Return the best estimate after max iterations
    }

    public static double f(double x) {
        return x * x - 2; // Example function: f(x) = x^2 - 2
    }
}
   
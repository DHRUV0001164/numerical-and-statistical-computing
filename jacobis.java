public class jacobis {
    public static void main(String[] args) {
        double[][] A = {
            {4, -1, 0, 0},
            {-1, 4, -1, 0},
            {0, -1, 4, -1},
            {0, 0, -1, 3}
        };
        double[] b = {15, 10, 10, 10};
        double[] x = new double[b.length];
        double tol = 1e-6;
        int maxIter = 100;

        jacobi(A, b, x, tol, maxIter);

        System.out.println("Solution:");
        for (double xi : x) {
            System.out.println(xi);
        }
    }

    public static void jacobi(double[][] A, double[] b, double[] x, double tol, int maxIter) {
        int n = b.length;
        for (int iter = 0; iter < maxIter; iter++) {
            double[] xOld = x.clone();
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= A[i][j] * xOld[j];
                    }
                }
                x[i] = sum / A[i][i];
            }
            if (converged(xOld, x, tol)) {
                break;
            }
        }
    }

    public static boolean converged(double[] xOld, double[] xNew, double tol) {
        for (int i = 0; i < xOld.length; i++) {
            if (Math.abs(xNew[i] - xOld[i]) > tol) {
                return false;
            }
        }
        return true;
    }
}

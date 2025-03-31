package dsaOverview.assignment1;

public class Polynomial {
    // Can you visualise the representation of a multivariate polynomial using a
    // nested list? Provide a function to find the degree of a multivariate
    // polynomial.
    // E.g. In this polynomial 3x2y4 - 5z2 + x - y + 20, the degree is 2+4 = 6

    public int highestDegree(int[][] polynomial) {
        int degree = 0;

        for (int i = 0; i < polynomial.length; i++) {
            int sum = 0;
            for (int j = 0; j < polynomial[i].length; j++) {
                sum += polynomial[i][j];
            }
            degree = Math.max(i, sum);
        }

        return degree;
    }

}

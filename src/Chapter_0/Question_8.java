package Chapter_0;

/**
 * Write a function to add two simple mathematical expressions which are of
 * the form Ax^a + Bx^b + ... (where the coefficients and exponents can be any positive or negative real
 * number). That is, the expression is a sequence of terms, where each term is simply a constant times an
 * exponent. You can use whatever data structure you'd like to hold the expressions.
 */
public class Question_8 {
    private static class ExprTerm {
        double coefficient;
        double exponent;
        ExprTerm(double coef, double exp) {
            coefficient = coef;
            exponent = exp;
        }
    }

    public static void main(String[] args) {
        double x = 1.0;
        ExprTerm[] exprA = {new ExprTerm(2, 2), new ExprTerm(3,4)};
        ExprTerm[] exprB = {new ExprTerm(2, 3), new ExprTerm(4,4)};
        System.out.println("The sum of the two expressions is " + sum(exprA, exprB, x));
    }

    private static double sum(ExprTerm[] exprA, ExprTerm[] exprB, double x) {
        double sumA = 0.0;
        double sumB = 0.0;

        // Get sum of expression A
        for (ExprTerm term : exprA)
            sumA += term.coefficient * (Math.pow(x, term.exponent));
        // Get sum of expression B
        for (ExprTerm term : exprB)
            sumB += term.coefficient * (Math.pow(x, term.exponent));

        return sumA + sumB;
    }
}

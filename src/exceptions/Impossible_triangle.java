package exceptions;

import java.util.Arrays;

public class Impossible_triangle extends Error {
    double[] sides;
    String message;

    public Impossible_triangle(double a, double b, double c, String msg) {
        sides = new double[3];
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;
        this.message = msg;
    }

    public Impossible_triangle(double a, double b, double c) {
        this(a, b, c, "Error: exception.Impossible_triangle was caught.");
    }

    public String getMessage() {
        return message + Arrays.toString(sides);
    }
}

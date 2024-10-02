package geometry2d;

import exceptions.Impossible_triangle;
import exceptions.Unexpected_value;

public class Triangle implements Figure {
    double a, b, c;

    public Triangle(double a, double b, double c) throws Unexpected_value, Impossible_triangle {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new Unexpected_value("Triangle sides must be a positive");
        if (a >= b + c || b >= a + c || c >= a + b)
            throw new Impossible_triangle(a, b, c, "Triangle not exists: ");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double p = this.perimeter() / 2;

        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public String toString() {
        return "Triangle with sides: " + a + ", " + b + ", " + c + ".\n";
    }
}

package geometry2d;

import exceptions.Unexpected_value;

public class Circle implements Figure {
    double radius;

    public Circle(double r) throws Unexpected_value {
        if(r <= 0) throw new Unexpected_value();
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return Math.PI * 2 * radius;
    }

    public String toString() {
        return "Circle with radius = " + radius + ".\n";
    }
}

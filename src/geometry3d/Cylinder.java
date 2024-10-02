package geometry3d;
import exceptions.Unexpected_value;
import geometry2d.Figure;

public class Cylinder {
    Figure base;
    double height;

    public Cylinder(Figure base, double h) throws Unexpected_value {
        if(h <= 0) throw new Unexpected_value("Cylinder(Figure, double): incorrect height value.");
        this.base = base;
        this.height = h;
    }

    public double volume() {
        return base.area() * height;
    }
}

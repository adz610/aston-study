package shapes;

public interface ShapeCalc {
    double getArea();

    default double getPerimeter(double[] sides) {
        double perimeter = 0;
        for (double side : sides)
            perimeter += side;
        return perimeter;
    }
}

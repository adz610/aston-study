package shapes;

public class Triangle extends Shape {
    private static int count = 0;
    private final int id;
    private final double[] sides;

    public Triangle(int fillColor, int borderColor, double side1, double side2, double side3) {
        super(fillColor, borderColor);

        sides = new double[] { side1, side2, side3 };

        count++;
        id = count;
    }

    public double getArea() {
        double p = getPerimeter(sides) / 2;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }
    
    public void getInfo() {
        System.out.println("Треугольник №" + id + ": площадь = " + getArea());
        System.out.println("Треугольник №" + id + ": периметр = " + getPerimeter(sides));
        System.out.printf("Треугольник №%d: цвет заливки = %06X\n", id, getFillColor());
        System.out.printf("Треугольник №%d: цвет границы = %06X\n", id, getBorderColor());
    }
}

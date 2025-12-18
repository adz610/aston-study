package shapes;

public class Circle extends Shape {
    private static int count = 0;
    private final int id;
    private final double radius;

    public Circle(int fillColor, int borderColor, double radius) {
        super(fillColor, borderColor);

        this.radius = radius;

        count++;
        id = count;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getPerimeter(double[] sides) {
        return getPerimeter();
    }

    public void getInfo() {
        System.out.println("Круг №" + id + ": площадь = " + getArea());
        System.out.println("Круг №" + id + ": периметр = " + getPerimeter());
        System.out.printf("Круг №%d: цвет заливки = %06X\n", id, getFillColor());
        System.out.printf("Круг №%d: цвет границы = %06X\n", id, getBorderColor());
    }
}

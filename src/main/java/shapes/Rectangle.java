package shapes;

public class Rectangle extends Shape {
    private static int count = 0;
    private final int id;
    private final double[] sides;
    private final double length;
    private final double width;

    public Rectangle(int fillColor, int borderColor, double length, double width) {
        super(fillColor, borderColor);

        sides = new double[] { length, width, length, width };
        this.length = length;
        this.width = width;

        count++;
        id = count;
    }

    public double getArea() {
        return length * width;
    }

    public void getInfo() {
        System.out.println("Прямоугольник №" + id + ": площадь = " + getArea());
        System.out.println("Прямоугольник №" + id + ": периметр = " + getPerimeter(sides));
        System.out.printf("Прямоугольник №%d: цвет заливки = %06X\n", id, getFillColor());
        System.out.printf("Прямоугольник №%d: цвет границы = %06X\n", id, getBorderColor());
    }
}

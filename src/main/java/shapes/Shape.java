package shapes;

public abstract class Shape implements ShapeCalc {
    protected int fillColor;
    protected int borderColor;

    public Shape(int fillColor, int borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public int getFillColor() {
        return fillColor;
    }

    public int getBorderColor() {
        return borderColor;
    }
}

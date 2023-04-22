package ch02.sec01;

public final class Point {
    private final double x;
    private final double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this(0, 0);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }
    public void scale(double factor) {
        x *= factor;
        y *= factor;
    }
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5);
        System.out.println("x = " + p.getX() + ", y = " + p.getY());
    }
}

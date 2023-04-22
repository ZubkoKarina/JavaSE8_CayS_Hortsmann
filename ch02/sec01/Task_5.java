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

    public Point translate(double dx, double dy) {
        return new Point(x + dx, y + dy);
    }

    public Point scale(double s) {
        return new Point(x * s, y * s);
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

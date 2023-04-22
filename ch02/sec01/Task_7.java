package ch02.sec01;
/**
 * Класс Point описывает точку на плоскости.
 * Точка имеет координаты x и y.
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * Конструктор, создающий точку с заданными координатами.
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Конструктор, создающий точку в начале координат.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Получает координату X точки.
     * @return координата X
     */
    public double getX() {
        return x;
    }

    /**
     * Получает координату Y точки.
     * @return координата Y
     */
    public double getY() {
        return y;
    }

    /**
     * Смещает точку на заданное расстояние по координатам X и Y.
     * @param dx расстояние по оси X
     * @param dy расстояние по оси Y
     */
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Изменяет масштаб точки по координатам X и Y на заданный коэффициент.
     * @param scale коэффициент масштабирования
     */
    public void scale(double scale) {
        x *= scale;
        y *= scale;
    }

    /**
     * Возвращает новую точку, смещенную на заданное расстояние по координатам X и Y.
     * @param dx расстояние по оси X
     * @param dy расстояние по оси Y
     * @return новая точка, смещенная на заданное расстояние
     */
    public Point translated(double dx, double dy) {
        return new Point(x + dx, y + dy);
    }

    /**
     * Возвращает новую точку, измененную в масштабе по координатам X и Y на заданный коэффициент.
     * @param scale коэффициент масштабирования
     * @return новая точка, измененная в масштабе на заданный коэффициент
     */
    public Point scaled(double scale) {
        return new Point(x * scale, y * scale);
    }
}

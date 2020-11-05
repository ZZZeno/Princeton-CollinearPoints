import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
    // constructs the point (x, y)
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        // draws this point
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        // draws the line segment from this point to that point
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        // string representation
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (that == null) {
            throw new NullPointerException();
        }
        // compare two points by y-coordinates, breaking ties by x-coordinates
        if (this.y > that.y) return 1;
        if (this.y < that.y) return -1;
        if (this.x > that.x) return 1;
        if (this.x < that.x) return -1;
        return 0;
    }

    public double slopeTo(Point that) {
        if (that == null) {
            throw new NullPointerException();
        }
        // the slope between this point and that point
        if (that.x - this.x == 0) {
            if (that.y != this.y) return Double.POSITIVE_INFINITY;
            return Double.NEGATIVE_INFINITY;
        }
        if (that.y - this.y == 0) return +0.0;
        return (double) (that.y - this.y) / (double) (that.x - this.x);
    }

    //    int compare(Key v, )
    private class BySlop implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a == null || b == null) {
                throw new NullPointerException();
            }
            return Double.compare(a.slopeTo(Point.this), b.slopeTo(Point.this));
        }
    }

    public Comparator<Point> slopeOrder() {
        return new BySlop();
    }

    public static void main(String[] args) {
        Point a = new Point(1, 2);
        a.draw();
        a.drawTo(new Point(5, 6));
//        Point b = new Point(1, 2);
//        Point c = new Point(1, 2);
//        Point d = new Point(1, 2);
    }
}

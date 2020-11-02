
public class Point implements Comparable<Point> {
    // constructs the point (x, y)
    public Point(int x, int y) {

    }

    public void draw() {
        // draws this point
    }

    public void drawTo(Point that) {
        // draws the line segment from this point to that point
    }

    public String toString() {
        // string representation
        return "";
    }

    public int compareTo(Point that) {
        // compare two points by y-coordinates, breaking ties by x-coordinates
        return 0;
    }

    public double slopeTo(Point that) {
        // the slope between this point and that point
        return 0.0;
    }
//    public Comparator<Point> slopeOrder() {
//
//    }
}

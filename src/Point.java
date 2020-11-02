
public class Point implements Comparable<Point> {
    // constructs the point (x, y)
    private final int INF = 99999999;
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
        if (this.y > that.y) return 1;
        if (this.y < that.y) return -1;
        if (this.x > that.x) return 1;
        if (this.x < that.x) return -1;
        return 0;
    }

    public double slopeTo(Point that) {
        // the slope between this point and that point
        if (that.x - this.x == 0) {
            if (that.y > this.y) return INF;
            return -INF;
        }
        if (that.y - this.y == 0) {
            return 0;
        }
        return (double) (that.y - this.y) / (double) (that.x - this.x);
    }
//    public Comparator<Point> slopeOrder() {
//
//    }
}

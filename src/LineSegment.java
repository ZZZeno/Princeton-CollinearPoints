public class LineSegment {
    private final Point p;
    private final Point q;
    public LineSegment(Point p, Point q) {
        if (q == null || p == null || p.toString().equals(q.toString())) {
            throw new IllegalArgumentException();
        }
        this.p = p;
        this.q = q;
    }
    public void draw() {
        this.p.drawTo(this.q);
    }
    public String toString() {
        return p + "->" + q;
    }
}

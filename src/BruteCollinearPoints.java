import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
//import edu.princeton.cs.algs4.

public class BruteCollinearPoints {
    private final ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();
    private int num = 0;
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException();
            }
        }
        Point[] copyPoints = new Point[points.length];
        System.arraycopy(points, 0, copyPoints, 0, points.length);
        Arrays.sort(copyPoints);
        for (int i = 0; i < copyPoints.length - 3; i++) {
            for (int j = i + 1; j < copyPoints.length - 2; j++) {
                for (int k = j + 1; k < copyPoints.length - 1; k++) {
                    for (int m = k + 1; m < copyPoints.length; m++) {
                        if (copyPoints[j].slopeTo(copyPoints[i]) == copyPoints[k].slopeTo(copyPoints[i])
                                && copyPoints[j].slopeTo(copyPoints[i]) == copyPoints[m].slopeTo(copyPoints[i])) {
                                    // in one line
                            Point leftUpMost = copyPoints[i];
                            Point rightBottomMost = copyPoints[m];
                            lineSegments.add(new LineSegment(leftUpMost, rightBottomMost));
                            num += 1;
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return num;
    }
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}

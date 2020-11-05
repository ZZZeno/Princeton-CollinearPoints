import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();
    private final List<Point> maxPoints = new ArrayList<Point>();
    private final List<Point> minPoints = new ArrayList<Point>();

    public FastCollinearPoints(Point[] points) {
        optionCheck(points);
        Point[] myPoints = new Point[points.length];
        System.arraycopy(points, 0, myPoints, 0, points.length);

        int length = myPoints.length;
        for (Point myPoint : myPoints) {
            int lastEqualIndex;
            Arrays.sort(myPoints, myPoint.slopeOrder());
            for (int j = 1; j < length; j += lastEqualIndex) {
                double k1 = myPoints[0].slopeTo(myPoints[j]);
                Point maxPoint = myPoints[0];
                Point minPoint = myPoints[0];
                lastEqualIndex = findEqualIndex(k1, j, length, myPoints, myPoints[0]);
                if (lastEqualIndex-j+1 < 3) {
                    continue;
                }
                for (int k = j; k < lastEqualIndex+1; k++) {
                    if (myPoints[k].compareTo(maxPoint) > 0) maxPoint = myPoints[k];
                    if (myPoints[k].compareTo(minPoint) < 0) minPoint = myPoints[k];
                }
                if (!hasDuplicateItem(maxPoint, minPoint)) {
                    maxPoints.add(maxPoint);
                    minPoints.add(minPoint);
                    lineSegments.add(new LineSegment(maxPoint, minPoint));
                }
            }
        }
    }

    private int findEqualIndex(double k, int start, int dest, Point[] copyPoints, Point base)
    {
        int mid = (dest+start)/2;
        while (mid > start) {
            mid = (dest+start)/2;
            if (copyPoints[mid].slopeTo(base) > k) dest = mid;
            if (copyPoints[mid].slopeTo(base) < k) start = mid;
            if (copyPoints[mid].slopeTo(base) == k) {
                if (copyPoints[mid].slopeTo(base) > k) {
                    return mid;
                }
                start = mid;
            }

        }
        return mid;
    }

    public int numberOfSegments() {
        return this.maxPoints.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }

    private boolean hasDuplicateItem(Point maxPoint, Point minPoint) {
        for (int i = 0; i < maxPoints.size(); i++)
            if (maxPoint.compareTo(maxPoints.get(i)) == 0 && minPoint.compareTo(minPoints.get(i)) == 0)
                return true;
        return false;
    }

    private void optionCheck(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        ArrayList<Point> pointArraylist = new ArrayList<Point>();
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException();
            }
            for (Point item : pointArraylist) {
                if (p.compareTo(item) == 0) throw new IllegalArgumentException();
            }
            pointArraylist.add(p);
        }
    }

}

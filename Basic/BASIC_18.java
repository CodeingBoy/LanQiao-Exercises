import java.util.ArrayList;
import java.util.Scanner;

public class BASIC_18 {

    public static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble(), y1 = scanner.nextDouble(), x2 = scanner.nextDouble(),
                y2 = scanner.nextDouble();
        double x3 = scanner.nextDouble(), y3 = scanner.nextDouble(), x4 = scanner.nextDouble(),
                y4 = scanner.nextDouble();

        Point[] points_A = { new Point(x1, y1), new Point(x1, y2), new Point(x2, y2), new Point(x2, y1) };
        Point[] points_B = { new Point(x3, y3), new Point(x3, y4), new Point(x4, y4), new Point(x4, y3) };

        ArrayList<Point> crossPoints_B = new ArrayList<>();
        for (Point point : points_B) {
            if (isInRect(points_A[0], points_A[2], point)) {
                crossPoints_B.add(point);
            }
        }

        ArrayList<Point> crossPoints_A = new ArrayList<>();
        for (Point point : points_A) {
            if (isInRect(points_B[0], points_B[2], point)) {
                crossPoints_A.add(point);
            }
        }

        if (crossPoints_B.size() < 1 && crossPoints_A.size() < 1) {
            System.out.println("0.00");
            System.exit(0);
        }

        // System.out.println(crossPoints_B);
        // System.out.println(crossPoints_A);

        ArrayList<Point> crossPoints = crossPoints_A;
        crossPoints.addAll(crossPoints_B);

        double min_x = Double.MAX_VALUE;
        double max_x = Double.MIN_VALUE;

        double min_y = Double.MAX_VALUE;
        double max_y = Double.MIN_VALUE;

        for (Point point : crossPoints) {
            double x = point.getX();
            double y = point.getY();
            if (x < min_x || x == min_x && y < min_y) {
                min_x = x;
                min_y = y;
            }
            if (x > max_x || x == max_x && y > max_y) {
                max_x = x;
                max_y = y;
            }
        }

        System.out.printf("%.2f", Math.abs((max_x - min_x) * (max_y - min_y)));
    }

    public static boolean isInRect(Point rect1, Point rect2, Point point) {
        double min_x = Math.min(rect1.getX(), rect2.getX());
        double max_x = Math.max(rect1.getX(), rect2.getX());

        double min_y = Math.min(rect1.getY(), rect2.getY());
        double max_y = Math.max(rect1.getY(), rect2.getY());

        if (point.getX() < min_x || point.getX() > max_x) {
            return false;
        }

        if (point.getY() < min_y || point.getY() > max_y) {
            return false;
        }

        return true;
    }
}

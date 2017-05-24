import java.util.Scanner;

public class ALGO_15 {
    private final static boolean DEBUG = false;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double distance = scanner.nextDouble(), fuelCapacity = scanner.nextDouble(),
                    distancePerFuel = scanner.nextDouble(), priceStart = scanner.nextDouble();
            int stationCount = scanner.nextInt();

            double[] stationDistance = new double[stationCount + 2];
            double[] stationPrice = new double[stationCount + 2];
            stationDistance[0] = 0;
            stationPrice[0] = priceStart;
            for (int i = 1; i < stationDistance.length - 1; i++) {
                stationDistance[i] = scanner.nextDouble();
                stationPrice[i] = scanner.nextDouble();
            }
            stationDistance[stationCount + 1] = distance;
            stationPrice[stationCount + 1] = Double.MAX_VALUE;

            double[] result = calcMinFee(stationDistance, stationPrice, 0, stationCount + 1, distancePerFuel,
                    fuelCapacity * distancePerFuel, 0);
            if (result[0] >= 0) {
                System.out.printf("%.2f\n", result[0]);
            } else {
                System.out.println("No Solution");
            }
        }
    }

    private static double[] calcMinFee(double[] stationDistance, double[] stationPrice, int start, int goal,
            double distancePerFuel, double maxDistance, double remainMileage) {
        if (start == goal) {
            return new double[] { 0, remainMileage };
        }

        int minIndex = -1;
        double minPrice = Double.MAX_VALUE;
        for (int i = start; i < goal; i++) {
            double curPrice = stationPrice[i];
            if (curPrice < minPrice) {
                minIndex = i;
                minPrice = stationPrice[minIndex];
            }
        }

        // double usedFuel = (stationDistance[minIndex] -
        // stationDistance[start]) / distancePerFuel;
        double[] leftFee = calcMinFee(stationDistance, stationPrice, start, minIndex, distancePerFuel, maxDistance,
                remainMileage);
        remainMileage = leftFee[1];

        double distance = 0, fuelFee = 0;
        int actualGoal = minIndex;
        double restrictedDistance = Math.min(maxDistance, maxDistance - remainMileage);
        for (int i = goal; i >= minIndex; i--) {
            distance = stationDistance[i] - stationDistance[minIndex];

            if (distance <= restrictedDistance) {
                actualGoal = i;
                break;
            } else {
                actualGoal = i - 1;
                distance = restrictedDistance;
                break;
            }
        }

        if (distance > restrictedDistance || distance <= 0) {
            return new double[] { Double.NEGATIVE_INFINITY, 0 };
        }

        distance -= remainMileage;
        double fuelCount = distance / distancePerFuel;
        fuelFee = minPrice * fuelCount;

        remainMileage += distance;
        remainMileage -= stationDistance[actualGoal] - stationDistance[minIndex];
        double[] rightFee = calcMinFee(stationDistance, stationPrice, actualGoal, goal, distancePerFuel, maxDistance,
                remainMileage);
        if (DEBUG) {
            System.out.printf("From %d to %d, min fuel fee %f(%d), fuel fee %f, left fee %f, right fee %f\n", start,
                    goal, minPrice, minIndex, fuelFee, leftFee[0], rightFee[0]);
        }

        return new double[] { fuelFee + leftFee[0] + rightFee[0], rightFee[1] };
    }
}

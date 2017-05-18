import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ALGO_6 {
    private static class Edge implements Comparable<Edge> {
        private int startNode, endNode;
        private int distance;

        public Edge(int startNode, int endNode, int distance) {
            super();
            this.startNode = startNode;
            this.endNode = endNode;
            this.distance = distance;
        }

        public int getStartNode() {
            return startNode;
        }

        public void setStartNode(int startNode) {
            this.startNode = startNode;
        }

        public int getEndNode() {
            return endNode;
        }

        public void setEndNode(int endNode) {
            this.endNode = endNode;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            if (distance == o.getDistance()) {
                return 0;
            } else if (distance < o.getDistance()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int farmCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();

        int[] talkTime = new int[farmCount + 1];
        Edge[] edges = new Edge[edgeCount];
        int minTalkTime = Integer.MAX_VALUE;
        int minTalkIndex = 0;

        for (int i = 1; i <= farmCount; i++) {
            talkTime[i] = scanner.nextInt();
            if (talkTime[i] < minTalkTime) {
                minTalkTime = Math.min(minTalkTime, talkTime[i]);
                minTalkIndex = i;
            }
        }

        for (int i = 0; i < edgeCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int dist = scanner.nextInt();
            edges[i] = new Edge(start, end, 2 * dist + talkTime[start] + talkTime[end]);
        }

        ArrayList<Edge> result = Kruskal(edges, farmCount);

        long  totalTime = 0;
        for (Edge edge : result) {
            totalTime += edge.getDistance();
            System.out.println(edge.getStartNode() + " " + edge.getEndNode() + " time: " + edge.getDistance());
            if (edge.getStartNode() == minTalkIndex || edge.getEndNode() == minTalkIndex) {
                //System.out.println(edge.getStartNode() + " " + edge.getEndNode() + " time: " + edge.getDistance());
                System.out.println("Start from " + minTalkIndex + " time: " + minTalkTime);
                totalTime += minTalkTime;
            }
        }
        totalTime -= minTalkTime;

        System.out.println(totalTime);
    }

    public static ArrayList<Edge> Kruskal(Edge[] edges, int nodeCount) {
        Arrays.sort(edges);
        ArrayList<Edge> result = new ArrayList<>();

        int[] jointSet = new int[nodeCount + 1];
        for (int i = 0; i < jointSet.length; i++) {
            jointSet[i] = i;
        }

        for (int j = 0; j < edges.length; j++) {
            int startNode = edges[j].getStartNode();
            int endNode = edges[j].getEndNode();
            // int distance = edges[j].getDistance();

            if (!merge(edges[j], jointSet)) {
                result.add(edges[j]);
            }
            if (result.size() == nodeCount - 1) {
                break;
            }
        }

        return result;
    }

    private static boolean merge(Edge edge, int[] result) {
        int startNode = edge.getStartNode();
        int endNode = edge.getEndNode();

        int startAncestor = getAncestor(startNode, result);
        int endAncestor = getAncestor(endNode, result);

        if (startAncestor != endAncestor) {
            result[endAncestor] = startAncestor;
            return false;
        }
        return true;
    }

    private static int getAncestor(int nodeIndex, int[] result) {
        if (result[nodeIndex] == nodeIndex) {
            return nodeIndex;
        }
        int ancestor = getAncestor(result[nodeIndex], result);
        result[nodeIndex] = ancestor;
        return ancestor;
    }
}

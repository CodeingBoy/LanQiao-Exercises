import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ALGO_5 {
    private static class Node implements Comparable<Node>, Comparator<Node> {
        private int node;
        private int distance;

        public Node(int node, int distance) {
            super();
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return compare(this, o);
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.distance == o2.getDistance()) {
                return 0;
            } else if (o1.distance < o2.getDistance()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private static class Edge {
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

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int edgeCount = scanner.nextInt();

        ArrayList<Edge>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        int[] start = new int[edgeCount];
        int[] end = new int[edgeCount];
        int[] dist = new int[edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            start[i] = scanner.nextInt();
            end[i] = scanner.nextInt();
            dist[i] = scanner.nextInt();
            edges[start[i]].add(new Edge(start[i], end[i], dist[i]));
        }

        int[] result = Dijkstra(edges, n);

        for (int i = 2; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] Dijkstra(ArrayList<Edge>[] edges, int nodeCount) {
        int[] result = new int[nodeCount + 1];
        for (int i = 2; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        boolean[] used = new boolean[nodeCount + 1];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (used[curNode.getNode()])
                continue;
            used[curNode.getNode()] = true;

            for (Edge edge : edges[curNode.getNode()]) {
                int startNode = edge.getStartNode();
                int endNode = edge.getEndNode();
                int distance = edge.getDistance();

                if (curNode.getNode() != startNode)
                    continue;

                if (result[endNode] > result[startNode] + distance) {
                    result[endNode] = result[startNode] + distance;
                    queue.add(new Node(endNode, distance));
                }
            }
        }

        return result;
    }

    public static int[] Dijkstra(int[] start, int[] end, int[] dist, int nodeCount) {
        int[] result = new int[nodeCount + 1];
        for (int i = 2; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        boolean[] used = new boolean[nodeCount + 1];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (used[curNode.getNode()])
                continue;
            used[curNode.getNode()] = true;

            for (int k = 0; k < start.length; k++) {
                int startNode = start[k];
                int endNode = end[k];
                int distance = dist[k];

                if (curNode.getNode() != startNode)
                    continue;

                if (result[endNode] > result[startNode] + distance) {
                    result[endNode] = result[startNode] + distance;
                    queue.add(new Node(endNode, distance));
                }

            }
        }

        return result;
    }

    public static int[] BellmanFord(int[] start, int[] end, int[] dist, int nodeCount) {
        int[] result = new int[nodeCount + 1];
        for (int i = 2; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        while (queue.size() > 0) {
            int curNode = queue.poll();
            for (int j = 0; j < start.length; j++) {
                int startNode = start[j];
                int endNode = end[j];
                int distance = dist[j];

                if (curNode != startNode)
                    continue;

                if (result[endNode] > result[startNode] + distance) {
                    result[endNode] = result[startNode] + distance;
                    if (!queue.contains(endNode)) {
                        queue.add(endNode);
                    }
                }
            }
        }

        return result;
    }
}

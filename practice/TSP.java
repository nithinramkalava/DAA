package practice;

public class TSP {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0},
        };

        System.out.println(tsp(graph, new boolean[graph.length], 0, 0, 0, 0, Integer.MAX_VALUE));

    }

    public static int tsp(int[][] graph, boolean[] visited, int count, int curr, int start, int cost, int ans) {

        if (!visited[start]) visited[start] = true;

        if (count == graph.length - 1) {
            if (graph[curr][start] > 0) {
                ans = Math.min(ans, cost + graph[curr][start]);
            }
        } else {
            for(int i = 0; i < graph.length; i++) {
                if (!visited[i] && graph[curr][i] > 0) {
                    visited[i] = true;
                    ans = tsp(graph, visited, count + 1, i, start, cost + graph[curr][i], ans);
                    visited[i] = false;
                }
            }
        }

        return ans;
    }
}

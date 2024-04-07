public class TSP {

    public static int tsp(int[][] graph, boolean[] visited, int n, int count, int cost, int currentNode, int source, int ans) {

        if (!visited[source]) visited[source] = true;
        
        if(count == n - 1 && graph[currentNode][source] > 0){
            ans = Math.min(ans, cost + graph[currentNode][source]);
        } else {
            for(int node = 0; node < n; node++) {
                if(!visited[node] && graph[currentNode][node] > 0) {
                    visited[node] = true;
                    ans = tsp(graph, visited, n, count + 1, cost + graph[currentNode][node], node, source, ans);
                    visited[node] = false;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int minCost = tsp(graph, new boolean[graph.length], graph.length, 0, 0, 0, 0, Integer.MAX_VALUE);

        System.out.println("Optimized Cost: " + minCost);
    }
}
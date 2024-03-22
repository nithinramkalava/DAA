import java.util.HashSet;

public class TravellingSalesman {

    public static Result travellingSalesman(int[][] graph, int mask, int current, int n, Result[][] dp) {
        // Base case: If all cities have been visited
        if (mask == (1 << n) - 1) {
            HashSet<Integer> path = new HashSet<>();
            path.add(0);
            path.add(current);
            return new Result(graph[current][0], path);
        }

        // Check if the result is already computed
        if (dp[mask][current] != null) {
            return dp[mask][current];
        }

        Result minCost = new Result(Integer.MAX_VALUE, new HashSet<>());

        // Try visiting unvisited cities
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newMask = mask | (1 << city);
                Result cost = travellingSalesman(graph, newMask, city, n, dp);
                cost.minCost += graph[current][city];

                if (cost.minCost < minCost.minCost) {
                    minCost.minCost = cost.minCost;
                    minCost.path = new HashSet<>(cost.path);
                    minCost.path.add(current);
                }
            }
        }

        // Save the result in the dp table
        dp[mask][current] = minCost;

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int n = graph.length;
        Result[][] dp = new Result[1 << n][n];

        // Start the TSP from city 0
        Result minCost = travellingSalesman(graph, 1, 0 , n, dp);
        System.out.println("Minimum cost of TSP: " + minCost.minCost);
    }
}

class Result {
    public int minCost;
    public HashSet<Integer> path;

    public Result(int minCost, HashSet<Integer> path) {
        this.minCost = minCost;
        this.path = path;
    }
}


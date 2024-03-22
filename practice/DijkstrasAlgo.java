package practice;

import java.util.Arrays;
import java.util.Scanner;

public class DijkstrasAlgo {

    public static void dijkstras(int[][] graph, int source) {
        int count = graph.length;
        int[] distance = new int[count];
        boolean[] visited = new boolean[count];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        distance[source] = 0;

        for (int i = 0; i < count; i++){
            int u = findMinDistance(distance, visited);
            visited[u] = true;
            
            for (int v = 0; v < count; v++) {
                if (
                    !visited[v] && graph[u][v] != 0 && distance[u] + graph[u][v] < distance[v]
                ) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
            
        }

        for(int i = 0; i < count; i++) {
            System.out.println(
                String.format("Distance from %s to %s is %s", source, i, distance[i])
              );
        }
        
    }
    public static int findMinDistance(int[] distance, boolean[] visited){
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
    public static void main(String[] args) {
        int[][] graph = GraphInput.getGraph();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source vertex: ");
        dijkstras(graph, sc.nextInt());
        sc.close();
    }
}

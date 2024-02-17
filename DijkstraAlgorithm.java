// Dijkstra's Algorithm in Java

import java.util.Scanner;

public class DijkstraAlgorithm {

  public static void dijkstra(int[][] graph, int source) {
    int count = graph.length;
    boolean[] visitedVertex = new boolean[count];
    int[] distance = new int[count];
    for (int i = 0; i < count; i++) {
      visitedVertex[i] = false;
      distance[i] = Integer.MAX_VALUE;
    }

    // Distance of self loop is zero
    distance[source] = 0;
    for (int i = 0; i < count; i++) {
      // Update the distance between neighbouring vertex and source vertex
      int u = findMinDistance(distance, visitedVertex);
      visitedVertex[u] = true;

      // Update all the neighbouring vertex distances
      for (int v = 0; v < count; v++) {
        if (
          !visitedVertex[v] &&
          graph[u][v] != 0 &&
          (distance[u] + graph[u][v] < distance[v])
        ) {
          distance[v] = distance[u] + graph[u][v];
        }
      }
    }
    for (int i = 0; i < distance.length; i++) {
      System.out.println(
        String.format("Distance from %s to %s is %s", source, i, distance[i])
      );
    }
  }

  // Finding the minimum distance
  private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
    int minDistance = Integer.MAX_VALUE;
    int minDistanceVertex = -1;
    for (int i = 0; i < distance.length; i++) {
      if (!visitedVertex[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of vertices: ");
    int vertices = sc.nextInt();
    int graph[][] = new int[vertices][vertices];

    System.out.println("Enter the adjacency matrix of the graph:");
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            graph[i][j] = sc.nextInt();
        }
    }

    System.out.print("Enter the source vertex: ");
    int source = sc.nextInt();
    sc.close();

    DijkstraAlgorithm.dijkstra(graph, source);
  }
}

package practice;

import java.util.Scanner;

public class GraphInput {
    public static int[][] getGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices of the graph: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) 
                graph[i][j] = sc.nextInt();
        
        return graph;

    }
}

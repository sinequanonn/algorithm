package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int MAX_VALUE = 5_000_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int V = Integer.parseInt(split[0]);
        int E = Integer.parseInt(split[1]);
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = MAX_VALUE;
            }
        }

        for (int i = 0; i < E; i++) {
            String[] path = br.readLine().split(" ");
            int from = Integer.parseInt(path[0]) - 1;
            int to = Integer.parseInt(path[1]) - 1;
            int cost = Integer.parseInt(path[2]);

            dist[from][to] = Math.min(dist[from][to], cost);
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = MAX_VALUE;
        for (int i = 0; i < V; i++) {
            answer = Math.min(answer, dist[i][i]);
        }
        System.out.println(answer == MAX_VALUE ? -1 : answer);
    }
}

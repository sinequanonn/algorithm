package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] canVisit = new boolean[N][N];

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || graph[i][j] == 1) {
                    canVisit[i][j] = true;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (canVisit[i][k] && canVisit[k][j]) {
                        canVisit[i][j] = true;
                    }
                }
            }
        }


        int[] destination = new int[M];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            destination[i] = Integer.parseInt(split[i]) - 1;
        }

        String answer = "YES";
        for (int i = 0; i < M - 1; i++) {
            if (!canVisit[destination[i]][destination[i + 1]]) {
                answer = "NO";
            }
        }
        System.out.println(answer);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
불!
-> F를 BFS해서 각 위치에 불이 퍼지는 최소 시간 계산
-> J를 BFS해서 각 위치에 도달하는 최소 시간 계산
 */
public class Main {
    private static int R;
    private static int C;
    private static String[][] grid;
    private static int[] x = {0, 0, 1, -1};
    private static int[] y = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        int MAX_DIST = 1_500_000;
        int answer = MAX_DIST;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        grid = new String[R][C];

        int[][] fireDist = new int[R][C];
        int[][] dist = new int[R][C];

        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                grid[i][j] = line[j];
                fireDist[i][j] = MAX_DIST;
                dist[i][j] = MAX_DIST;
                if (line[j].equals("J")) {
                    jQueue.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
                if (line[j].equals("F")) {
                    fireQueue.add(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
            }
        }

        bfs(fireQueue, fireDist);
        bfs(jQueue, dist);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                    if (dist[i][j] != MAX_DIST && dist[i][j] < fireDist[i][j]) {
                        answer = Math.min(answer, dist[i][j] + 1);
                    }
                }
            }
        }

        System.out.println(answer == MAX_DIST ? "IMPOSSIBLE" : answer);
    }

    private static void bfs(Queue<int[]> queue, int[][] dist) {
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int cx = position[1];
            int cy = position[0];

            for (int i = 0; i < 4; i++) {
                int nx = cx + x[i];
                int ny = cy + y[i];

                if (nx >= 0 && nx < C && ny >= 0 && ny < R && !grid[ny][nx].equals("#")) {
                    if (dist[ny][nx] > dist[cy][cx] + 1) {
                        queue.add(new int[]{ny, nx});
                        dist[ny][nx] = dist[cy][cx] + 1;
                    }
                }
            }
        }
    }
}

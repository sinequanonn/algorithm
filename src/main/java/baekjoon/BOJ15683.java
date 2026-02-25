package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[][] grid;
    private static int[][] show;
    private static List<int[]> cctv;
    private static int answer = 100_000;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        show = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] >= 1 && grid[i][j] <= 5) {
                    cctv.add(new int[]{j, i});
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int idx) {
        if (idx == cctv.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 0 && show[i][j] == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        int x = cctv.get(idx)[0];
        int y = cctv.get(idx)[1];
        int type = grid[y][x];

        for (int[] dirs : directions[type]) {
            for (int d : dirs) watch(x, y, d, 1);
            dfs(idx + 1);
            for (int d : dirs) watch(x, y, d, -1);
        }
    }

    private static void watch(int x, int y, int dir, int delta) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (nx >= 0 && nx < M && ny >= 0 && ny < N && grid[ny][nx] != 6) {
            show[ny][nx] += delta;
            nx += dx[dir];
            ny += dy[dir];
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] grid;
    private static boolean[][] visited;
    private static boolean changed;
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int answer = 0;

        grid = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                grid[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        bfs -> 좌표 모음 리스트 저장 -> 업데이트
        -> 모든 칸이 업데이트 안될때까지 반복
         */
        while (true) {
            changed = false;
            visited = new boolean[N][N];

            List<List<int[]>> changedList = new ArrayList<>();

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]) {
                        List<int[]> pos = bfs(x, y, N, L, R);

                        if (pos.size() >= 2) {
                            changedList.add(pos);
                        }
                    }
                }
            }

            for (List<int[]> positions : changedList) {
                int updateValue = 0;

                for (int[] pos : positions) {
                    updateValue += grid[pos[1]][pos[0]];
                }
                updateValue /= positions.size();

                for (int[] pos : positions) {
                    grid[pos[1]][pos[0]] = updateValue;
                }
            }

            if (!changed) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static List<int[]> bfs(int x, int y, int N, int L, int R) {
        List<int[]> union = new ArrayList<>();

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        visited[y][x] = true;

        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            int cx = pop[0];
            int cy = pop[1];
            union.add(new int[]{cx, cy});

            for (int i = 0; i < 4; i++) {
                int nx = cx + X[i];
                int ny = cy + Y[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                    int diff = Math.abs(grid[cy][cx] - grid[ny][nx]);
                    if (diff >= L && diff <= R) {
                        visited[ny][nx] = true;
                        deque.add(new int[]{nx, ny});
                    }
                }
            }
        }
        if (union.size() >= 2) {
            changed = true;
        }

        return union;
    }
}

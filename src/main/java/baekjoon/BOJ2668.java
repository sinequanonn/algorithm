package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//2668 숫자고르기 -> 사이클 찾기
public class Main {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int start, int current) {
        int next = arr[current];

        if (next == start) {
            result.add(start);
            return;
        }

        if (!visited[next]) {
            visited[next] = true;
            dfs(start, next);
            visited[next] = false;
        }
    }
}

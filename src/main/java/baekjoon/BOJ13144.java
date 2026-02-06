package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    1 2 3 1 2
    1 -> 1
    1 2 -> 2
    1 2 3 -> 3
    2 3 1 -> 3
    3 1 2 -> 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        boolean[] visited = new boolean[100001];
        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        int start = 0;
        int answer = 0;

        for (int end = 0; end < N; end++) {
            // 중복 포함되는 경우
            while (visited[numbers[end]]) {
                visited[numbers[start]] = false;
                start++;
            }

            visited[numbers[end]] = true;
            answer += (end - start + 1);
        }

        System.out.println(answer);
    }
}

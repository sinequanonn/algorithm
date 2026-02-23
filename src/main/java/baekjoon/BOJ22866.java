package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 탑 보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] buildings = new int[N + 1];
        int[][] infos = new int[N + 1][2]; // 0: 보이는 건물 개수, 1: 가장 가까운 건물 번호

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> stack = new ArrayDeque<>(); // {높이, 건물번호}

        for (int i = 1; i < N + 1; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= buildings[i]) {
                stack.pop();
            }
            infos[i][0] += stack.size();
            if (!stack.isEmpty()) {
                infos[i][1] = stack.peek()[1];
            }
            stack.push(new int[]{buildings[i], i});
        }

        stack.clear();

        for (int i = N; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= buildings[i]) {
                stack.pop();
            }
            infos[i][0] += stack.size();
            if (!stack.isEmpty()) {
                if (infos[i][1] == 0) {
                    infos[i][1] = stack.peek()[1];
                } else {
                    if (i - infos[i][1] > stack.peek()[1] - i) {
                        infos[i][1] = stack.peek()[1];
                    }
                }
            }
            stack.push(new int[]{buildings[i], i});
        }

        for (int i = 1; i < N + 1; i++) {
            if (infos[i][0] == 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(infos[i][0] + " " + infos[i][1]);
        }
    }
}

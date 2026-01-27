package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        boolean[][] visited = new boolean[S + 1][S + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0});
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int screen = cur[0];
            int clipboard = cur[1];
            int time = cur[2];

            if (screen == S) {
                System.out.println(time);
                return;
            }

            if (!visited[screen][screen]) {
                visited[screen][screen] = true;
                queue.offer(new int[]{screen, screen, time + 1});
            }

            int newScreen = screen + clipboard;
            if (clipboard > 0 && newScreen <= S && !visited[newScreen][clipboard]) {
                visited[newScreen][clipboard] = true;
                queue.offer(new int[]{newScreen, clipboard, time + 1});
            }

            if (screen > 0 && !visited[screen - 1][clipboard]) {
                visited[screen - 1][clipboard] = true;
                queue.offer(new int[]{screen - 1, clipboard, time + 1});
            }
        }
    }
}

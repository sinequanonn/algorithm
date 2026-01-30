package baekjoon;

import java.util.Scanner;

//0 만들기
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            dfs(N, 2, "1");
            System.out.println();
        }
    }

    private static void dfs(int N, int idx, String answer) {
        if (idx > N) {
            if (evaluate(answer) == 0) {
                System.out.println(answer);
            }
            return;
        }

        dfs(N, idx + 1, answer + " " + idx);
        dfs(N, idx + 1, answer + "+" + idx);
        dfs(N, idx + 1, answer + "-" + idx);
    }

    private static int evaluate(String answer) {
        String expr = answer.replace(" ", "");
        String[] tokens = expr.split("(?=[+-])");
        int total = 0;
        for (String token : tokens) {
            total += Integer.parseInt(token);
        }
        return total;
    }
}

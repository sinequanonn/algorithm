package baekjoon;

import java.util.Scanner;

// 줄 세우기
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        int[] koi = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            koi[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (koi[j] < koi[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];
        int answer = 0;

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(line[i]);
        }

        for (int n = 0; n < N; n++) {
            int result = 0;
            if (n > 0) {
                double left = Double.MAX_VALUE;
                for (int prev = n - 1; prev >= 0; prev--) {
                    double tmp = (double) (buildings[n] - buildings[prev]) / (n - prev);

                    if (tmp < left) {
                        left = tmp;
                        result++;
                    }
                }
            }

            if (n < N - 1) {
                double right = -Double.MAX_VALUE;
                for (int next = n + 1; next < N; next++) {
                    double tmp = (double) (buildings[next] - buildings[n]) / (next - n);
                    if (tmp > right) {
                        right = tmp;
                        result++;
                    }
                }
            }

            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}

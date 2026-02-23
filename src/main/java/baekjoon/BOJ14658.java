package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 하늘에서 별똥별이 빗발친다
/*
K는 최대 100개임.
100개를 트램펄린 크기로 군집해서 제일 큰 군집 크기를 구하면 될듯
정답 : (100 - 제일 큰 군집 크기)

어떻게 군집화를 할 수 있을까

모든 좌표를 기준으로 다른 좌표가 나의 범위에 포함하는지?
- 개당 1억번 -> 100억번 -> 시간 초과

모든 좌표를 고려하는 게 아니라 K=100임.
K 좌표만 사용해서 완탐
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] stars = new int[K][2];
        int answer = 0;

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            stars[k][0] = Integer.parseInt(st.nextToken());
            stars[k][1] = Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < K; x++) {
            for (int y = 0; y < K; y++) {
                int x1 = stars[x][0];
                int y1 = stars[y][1];
                int x2 = x1 + L;
                int y2 = y1 + L;

                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k][0] >= x1 && stars[k][0] <= x2 && stars[k][1] >= y1 && stars[k][1] <= y2) {
                        count++;
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        System.out.println(K - answer);
    }
}

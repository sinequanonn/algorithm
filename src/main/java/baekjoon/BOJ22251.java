package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] bits = {
            0b1110111, //0
            0b0010010, //1
            0b1011101, //2
            0b1011011, //3
            0b0111010, //4
            0b1101011, //5
            0b1101111, //6
            0b1010010, //7
            0b1111111, //8
            0b1111011, //9
    };

    static int[][] costs = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                costs[i][j] = Integer.bitCount(bits[i] ^ bits[j]);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }

            int totalCost = calcCost(X, i, K);

            if (totalCost >= 1 && totalCost <= P) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static int calcCost(int start, int end, int k) {
        int total = 0;

        for (int i = 0; i < k; i++) {
            int digitFrom = start % 10;
            int digitTo = end % 10;

            total += costs[digitFrom][digitTo];

            start /= 10;
            end /= 10;
        }

        return total;
    }
}

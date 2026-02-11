package baekjoon;

import java.util.*;

// 가장 긴 증가하는 부분 수열 2
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        List<Integer> tails = new ArrayList<>();
        for (int a : A) {
            int pos = Collections.binarySearch(tails, a);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == tails.size()) {
                tails.add(a);
            } else {
                tails.set(pos, a);
            }
        }
        System.out.println(tails.size());
    }
}

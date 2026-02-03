package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//전구와 스위치
/*
시작 -> 끝
1100  0010이 될 수 있냐?
완전 탐색을 했을 때 왼쪽 -> 오른쪽으로 간다
i를 기준으로 i-1이 바꾸고, i+1로 가면 더 이상 수정할 수 없다
그렇기 때문에 i-1이 결과와 같도록 해야함.
0010
----
1100
0010 1번 만에 가능함.
가능한 경우가 두 가지가 있음 1번째 값을 0으로 바꿔서 시작하는가
두 개 경우의 수 중 최소값을 결정하면 된다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String source = br.readLine();
        String target = br.readLine();

        int answer = Math.min(greedy(source.toCharArray(), target.toCharArray(), true), greedy(source.toCharArray(), target.toCharArray(), false));
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int greedy(char[] source, char[] target, boolean makeNumberZero) {
        int count = 0;

        if (makeNumberZero) {
            changeNumber(source, 0);
            changeNumber(source, 1);
            count++;
        }

        int N = source.length;
        for (int i = 1; i < N - 1; i++) {
            if (source[i-1] != target[i-1]) {
                changeNumber(source, i-1);
                changeNumber(source, i);
                changeNumber(source, i+1);
                count++;
            }
        }

        if (source[N - 2] != target[target.length - 2]) {
            changeNumber(source, N - 2);
            changeNumber(source, N - 1);
            count++;
        }

        if (source[N - 1] != target[N - 1]) {
            return Integer.MAX_VALUE;
        }

        return count;
    }

    private static void changeNumber(char[] source, int idx) {
        source[idx] = source[idx] == '0' ? '1' : '0';
    }
}

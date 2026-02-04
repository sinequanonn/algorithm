package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//스카이라인 쉬운거
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        /*
        answer=1+1+1+1+1+1

         */
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int y = Integer.parseInt(split[1]);

            if (stack.isEmpty()) {
                if (y != 0) {
                    stack.addLast(y);
                }
                continue;
            }

            while (true) {
                if (stack.isEmpty()) {
                    if (y != 0) {
                        stack.addLast(y);
                    }
                    break;
                }
                Integer top = stack.peekLast();
                if (y > top) {
                    stack.addLast(y);
                    break;
                }
                if (y == top) {
                    break;
                }

                stack.pollLast();
                answer++;
            }
        }
        System.out.println(answer + stack.size());
    }
}

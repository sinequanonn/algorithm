package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 가희의 탑
/*
조건 : a + b <= N + 1

N = 1
a = 1, b = 1 -> 1

N = 2
a = 1, b = 1 -> 1 1
a = 1, b = 2 -> 2 1
a = 2, b = 1 -> 1 2
a = 2, b = 2 -> x

N = 3
a = 1, b = 1 -> 1 1 1
a = 1, b = 2 -> 1 2 1
a = 1, b = 3 -> 3 2 1
a = 2, b = 1 -> 1 1 2
a = 2, b = 2 -> 1 2 1
a = 2, b = 3 -> x
a = 3, b = 1 -> 1 2 3
a = 3, b = 2 -> x
a = 3, b = 3 -> x

ex) N = 5
a = 4, b = 2 -> a + b = 6 이니깐 가능
-> 1 2 3 4 1

a = 3, b = 2야 그러면 여기서
a는 1 2 3이 있어야 하고,
b는 2 1이 있으면 돼

1 2 3 2 1 -> a + b - 1이고, N - (a + b - 1)만큼 1을 앞에 붙이면 되겠네
3 2 비교해서 3 > 2이므로
1 2 3 1 이고 5 - (3 + 2 - 1) = 1만큼 1을 앞에 붙이면 되겠네
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        int more = N - (a + b - 1);

        if (a + b > N + 1) {
            System.out.println(-1);
        } else if (a == 1) {
            deque.add(b);
            for (int i = 0; i < more; i++) {
                deque.add(1);
            }
            for (int i = b - 1; i >= 1; i--) {
                deque.add(i);
            }
            for (Integer i : deque) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = 1; i < a; i++) {
                deque.add(i);
            }
            if (a >= b) {
                deque.add(a);
                for (int i = b - 1; i >= 1; i--) {
                    deque.add(i);
                }
            } else {
                for (int i = b; i >= 1; i--) {
                    deque.add(i);
                }
            }

            for (int i = 0; i < more; i++) {
                deque.addFirst(1);
            }

            for (Integer i : deque) {
                System.out.print(i + " ");
            }
        }
    }
}

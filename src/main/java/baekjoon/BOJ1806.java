package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int answer = Integer.MAX_VALUE;
        int N = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int accumSum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (accumSum >= S) {
                answer = Math.min(answer, end - start);
                accumSum -= numbers.get(start);
                start++;
                continue;
            }

            if (end == N) {
                break;
            }

            accumSum += numbers.get(end);
            end++;
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] original = new String[N];
        String[][] words = new String[N][2];

        for (int i = 0; i < N; i++) {
            original[i] = br.readLine();
            words[i][0] = original[i];
            words[i][1] = String.valueOf(i);
        }

        Arrays.sort(words, (a, b) -> a[0].compareTo(b[0]));

        int maxLen = 0;
        for (int i = 0; i < N - 1; i++) {
            if (words[i][0].equals(words[i + 1][0])) {
                continue;
            }
            int len = getCommonPrefixLength(words[i][0], words[i + 1][0]);
            maxLen = Math.max(maxLen, len);
        }

        String first = null;
        String second = null;
        boolean found = false;

        for (int i = 0; i < N && !found; i++) {
            for (int j = i + 1; j < N && !found; j++) {
                if (original[i].equals(original[j])) {
                    continue;
                }
                int len = getCommonPrefixLength(original[i], original[j]);
                if (len == maxLen) {
                    first = original[i];
                    second = original[j];
                    found = true;
                }
            }
        }

        System.out.println(first);
        System.out.println(second);
    }

    static int getCommonPrefixLength(String a, String b) {
        int minLen = Math.min(a.length(), b.length());
        int count = 0;
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            count++;
        }
        return count;
    }
}

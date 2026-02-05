package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chs = br.readLine();
        String bomb = br.readLine();
        int bombSize = bomb.length();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < chs.length(); i++) {
            sb.append(chs.charAt(i));

            if (sb.length() >= bombSize) {
                boolean match = true;

                for (int j = 0; j < bombSize; j++) {
                    if (sb.charAt(sb.length() - bombSize + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    sb.setLength(sb.length() - bombSize);
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}

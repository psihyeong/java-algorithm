import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        // 1. 스택 시뮬레이션
        while (K-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        // 2. 스택 합 출력
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        bw.write(res + "");

        bw.flush();
        bw.close();
    }
}
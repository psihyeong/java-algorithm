import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split("");
        int M = Integer.parseInt(br.readLine());

        Stack<String> lS = new Stack<>();
        Stack<String> rS = new Stack<>();

        for (String alpha:str) {
            lS.add(alpha);
        }

        // 1. 커맨드 수행
        while (M-- > 0) {
            String tmp[] = br.readLine().split(" ");
            String com = tmp[0];

            switch (com) {
                case "L":
                    if (lS.isEmpty()) continue;     // 커서가 맨 앞일 경우
                    rS.push(lS.pop());
                    break;
                case "D":
                    if (rS.isEmpty()) continue;     // 커서가 맨 뒤일 경우
                    lS.push(rS.pop());
                    break;
                case "B":
                    if (lS.isEmpty()) continue;     // 커서가 맨 앞일 경우
                    lS.pop();
                    break;
                case "P":
                    lS.push(tmp[1]);
                    break;
                default:
            }
        }

        // 2. 출력
        while (!lS.isEmpty()) {     // 맨 앞부터 출력하기 위해 rightStack으로 옮김
            rS.push(lS.pop());
        }

        while (!rS.isEmpty()) {
            bw.write(rS.pop());
        }
        bw.flush();
        bw.close();
    }
}
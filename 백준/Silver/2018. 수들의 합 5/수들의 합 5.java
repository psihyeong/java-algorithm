import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int count = 1;      // 가지수
        int start_idx = 1;  // 시작점
        int end_idx = 1;    // 끝점
        int sum = 1;        // 현재 연속된 자연수의 합
        
        // 시작점 1, 끝점 1, 현재 연속된 자연수의 합 1에서 출발
        while (end_idx != N) {
            if (sum == N) {     // N이면 가지수 추가해주고
                count++;
                end_idx++;      
                sum = sum + end_idx;    
            }
            else if (sum > N) { // N보다 크면 시작점 줄이기
                sum = sum - start_idx;
                start_idx++;
            }
            else {              // N보다 작으면 끝점 늘리기
                end_idx++;
                sum = sum + end_idx;
            }
        }
        // 연속된 자연수의 합이기 때문에 가능한 투포인터 로직
        System.out.println(count);
    }
}
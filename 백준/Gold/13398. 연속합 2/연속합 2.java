import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int []A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int []L = new int[N];       // 오른쪽부터 N번째 인덱스 값을 포함한 수열 중 최대 연속 합을 저장하는 배열
        L[0] = A[0];                // 최초 값 초기화
        int result = L[0];

        for (int i=1; i<N; i++) {
            L[i] = Math.max(A[i], L[i-1]+A[i]);
            result = Math.max(result, L[i]);
        }

        int []R = new int[N];       // 왼쪽부터 N번째 인덱스 값을 포함한 수열 중 최대 연속 합을 저장하는 배열
        R[N-1] = A[N-1];            // 최초 값 초기화
        for (int i=N-2; i>=0; i--) {
            R[i] = Math.max(A[i], R[i+1]+A[i]);
            result = Math.max(result, R[i]);
        }

        for (int i=1; i<N-1; i++) {
            int tmp = L[i-1] + R[i+1];      // i번째 수를 빼고 만들 수 있는 값
            result = Math.max(result, tmp);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
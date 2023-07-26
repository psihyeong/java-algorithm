import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String strArrN[] = br.readLine().split(" ");
        int arrN[] = new int[n];
        for (int i=0;i<n;i++) {
            arrN[i] = Integer.parseInt(strArrN[i]);
        }
        // Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arrN);

        int L = 0;
        int R = n-1;
        int res = 0;
        
        // 1. 투포인터 로직
        while (R > L) {
            int tmpS = arrN[L] + arrN[R];
            if (tmpS == x) {
                res ++;
                L++;
            }
            else if (tmpS > x) {
                R--;
            }
            else if (tmpS < x) {
                L++;
            }
         }
        
        // 2. 출력
        bw.write(res+"");

        bw.flush();
        bw.close();
    }
}
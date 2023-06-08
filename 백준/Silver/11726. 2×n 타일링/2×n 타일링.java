import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long DP[] = new long[1001];
        DP[1] = 1;
        DP[2] = 2;

        for (int i=3; i<=N; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 10007;
        }
        
        System.out.println(DP[N]);
    }
}
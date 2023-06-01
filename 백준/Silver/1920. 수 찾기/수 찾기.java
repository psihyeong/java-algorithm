import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        
        Arrays.sort(A);     // 이진탐색을 위한 오름차순 정렬
        // 이진 탐색
        for (int i=0; i<M; i++) {
            boolean isFind = false;
            int target = sc.nextInt();
            int start = 0;
            int end = N-1;
            while (start <= end) {
                int mid = (start+end)/2;
                int midValue = A[mid];
                if (midValue > target) {
                    end = mid-1;
                } else if (midValue < target) {
                    start = mid+1;
                } else {
                    isFind = true;
                    break;
                }
            }

            if (isFind) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
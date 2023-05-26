import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열받기
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        // 정렬 후 투포인터
        int count = 0;
        int i = 0;
        int j = N-1;
        while(i<j) {
            if (nums[i] + nums[j] < M) {
                i++;
            }
            else if (nums[i] + nums[j] > M) {
                j--;
            }
            else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);

    }
}
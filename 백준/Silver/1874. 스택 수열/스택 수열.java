import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Array[] = new int[N];
        // 수열 받기
        for (int i=0; i<N; i++) {
            Array[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();   // 스택 선언
        int num = 1;                            // 1부터 오름차순
        boolean isAble = true;                  // 가능, 불가능 경우
        StringBuffer result = new StringBuffer();

        for (int i=0; i<N; i++) {
            int checkNum = Array[i];        // 수열 값
            if (checkNum >= num) {
                while (checkNum >= num) {   // pop 하기 전까지 1씩 더해가며 push
                    stack.push(num);
                    num++;
                    result.append("+\n");
                }
                stack.pop();                // 수열 값을 pop
                result.append("-\n");
            } else {
                int n = stack.pop();
                if (n > checkNum) {         // 불가능한 경우
                    System.out.println("NO");
                    isAble = false;
                    break;
                } else {
                    result.append("-\n");
                }
            }
        }

        if (isAble == true) {
            System.out.println(result.toString());
        }

    }
}
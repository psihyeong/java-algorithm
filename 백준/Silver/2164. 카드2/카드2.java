import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int N = sc.nextInt();       // 카드 쌓기
        for (int i=1; i<=N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();               // 1. 맨 위 카드 버리기
            q.add(q.poll());        // 2. 다음 맨 위 카드를 가장 밑으로 이동 

        }
        
        System.out.println(q.poll());
    }
}
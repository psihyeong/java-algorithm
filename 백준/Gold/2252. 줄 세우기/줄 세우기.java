import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // 초기화
        for (int i = 0; i<=N; i++) {
            A.add(new ArrayList<>());
        }

        int indegree[] = new int[N+1];

        for (int i=0; i<M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;          // 진입차수 배열 데이터 저장 부분
        }

        // 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        
        // 최초 진입차수가 0이 되는 노드를 큐에 삽입
        for (int i=1; i<=N; i++) {
            if (indegree[i]==0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();         // 큐에서 노드를 꺼내고
            System.out.print(now + " ");
            for (int next : A.get(now)) {   // 꺼낸 노드와 연결되어 있는 간선들을
                indegree[next]--;           // 제거하고 진입차수 최신화
                if (indegree[next]==0) {    // 진입차수가 0이 되는 노드를 큐에 삽입
                    queue.offer(next);
                }
            }
        }
    }
}
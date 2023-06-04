import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsBG;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsBG = true;

            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            // 엣지 데이터 저장
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int i=1; i<=V; i++) {
                if (IsBG) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if (IsBG) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node]==check[i]) {
                IsBG = false;
            }
        }
    }
}
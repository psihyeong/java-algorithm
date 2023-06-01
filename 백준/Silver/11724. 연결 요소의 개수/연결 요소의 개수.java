import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];     // 1번 인덱스부터 사용하기 위해 n+1
        arr = new ArrayList[n+1];

        for (int i=1; i<n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        int cnt = 0;

        for (int i=1; i<n+1; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
    }
    
    // 인접 노드를 방문처리하는 DFS
    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : arr[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
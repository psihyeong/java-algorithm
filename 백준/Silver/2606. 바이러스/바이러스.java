import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static Integer result;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int comNum = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        arr = new ArrayList[comNum+1];

        for (int i=0; i<=comNum; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        result = 0;
        visited = new boolean[comNum+1];
        bfs(1);

        bw.write(result.toString());

        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int neighbor : arr[now]) {
                if (!visited[neighbor]) {
                    result++;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
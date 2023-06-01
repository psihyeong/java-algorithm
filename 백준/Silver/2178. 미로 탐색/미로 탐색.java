import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        // 2차원배열로 미로 입력 받기
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }
    
    // 최단거리를 찾는 BFS
    private static void BFS(int sy, int sx) {
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[] {sy,sx});
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int y = now[0];
            int x = now[1];
            visited[y][x] = true;
            
            for (int k=0; k<4; k++) {       // 상하좌우 4방향 탐색
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (A[ny][nx]!=0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        A[ny][nx] = A[y][x] + 1;
                        queue.add(new int[] {ny,nx});
                    }
                }
            }
        }
    }
}
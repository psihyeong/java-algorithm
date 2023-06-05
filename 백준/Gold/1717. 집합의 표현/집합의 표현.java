import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        parent = new int[N+1];

        for (int i=0; i<N+1; i++) {
            parent[i] = i;
        }

        for (int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int question = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            if (question == 0) {
                union(a,b);
            } else {
                if (checkSame(a,b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        // 대표노드 찾아서 연결하기
        a = find(a);
        b = find(b);
        if (a!=b) {
            parent[b] = a;          // 연결
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {       // 대표노드일 경우
            return a;
        } else {
            return parent[a] = find(parent[a]); // 대표노드 찾기
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) {
            return true;
        }
        return false;
    }
}
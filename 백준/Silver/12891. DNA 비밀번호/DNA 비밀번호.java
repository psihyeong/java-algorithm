import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int myArr[];
    static int checkArr[];
    static int checkCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        
        checkArr = new int[4];      // 'A', 'C', 'G', 'T' 최소 개수
        myArr = new int[4];         // 현재 부분문자열의 'A', 'C', 'G', 'T'의 개수를 담는 리스트
        checkCnt = 0;               // 조건을 만족하는 Cnt, Cnt가 4면 모든 조건을 만족

        char DNA[] = new char[S];
        DNA = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkCnt++;
            }
        }

        // 첫 비밀번호 담기
        for (int i=0; i<P; i++) {
            Add(DNA[i]);
        }
        
        // 첫 비밀번호 확인
        if (checkCnt == 4) {
            result++;
        }

        // 슬라이딩 윈도우
        for (int right=P; right<S; right++) {
            int left = right-P;
            Add(DNA[right]);
            Remove(DNA[left]);

            if (checkCnt == 4) {
                result++;
            }
        }

        System.out.println(result);

    }

    // 문자 c를 더할때
    private static void Add(char c) {
        switch (c) {
        case'A':
            myArr[0]++;
            if (myArr[0] == checkArr[0]) {
                checkCnt++;
            }
            break;
        case'C':
            myArr[1]++;
            if (myArr[1] == checkArr[1]) {
                checkCnt++;
            }
            break;
        case'G':
            myArr[2]++;
            if (myArr[2] == checkArr[2]) {
                checkCnt++;
            }
            break;
        case'T':
            myArr[3]++;
            if (myArr[3] == checkArr[3]) {
                checkCnt++;
            }
            break;
        }
    }

    // 문자 c를 뺄때
    private static void Remove(char c) {
        switch (c) {
            case'A':
                if (myArr[0] == checkArr[0]) {
                    checkCnt--;
                }
                myArr[0]--;
                break;
            case'C':
                if (myArr[1] == checkArr[1]) {
                    checkCnt--;
                }
                myArr[1]--;
                break;
            case'G':
                if (myArr[2] == checkArr[2]) {
                    checkCnt--;
                }
                myArr[2]--;
                break;
            case'T':
                if (myArr[3] == checkArr[3]) {
                    checkCnt--;
                }
                myArr[3]--;
                break;
        }
    }
}
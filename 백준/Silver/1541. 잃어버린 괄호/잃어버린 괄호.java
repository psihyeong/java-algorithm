import java.util.Scanner;

public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("-");    // - 기준 스플릿

        for (int i=0; i<str.length; i++) {
            int tmp = Sum(str[i]);         // 나눠진 부분 연산
            if (i==0) {                    // 첫번째 값은 무조건 더하고
                answer += tmp;
            } else {                       // 두번째 부터는 모두 빼기
                answer -= tmp;
            }
        }
        
        System.out.println(answer);
    }

    // + 기호 들어있는 문자열 연산 처리 함수
    private static int Sum(String s) {
        int sum = 0;
        String[] tmp = s.split("[+]");
        for (int i=0; i<tmp.length; i++) {
            sum += Integer.parseInt(tmp[i]);
        }

        return sum;
    }
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		// 문자열을 정수형 배열로 받기
		int Array[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			Array[i] = Integer.parseInt(str.substring(i, i + 1));
		}

		// 선택정렬
		for (int i = 0; i < Array.length; i++) {
			int max = i;        // 가장 높은 값의 인덱스 정보
			for (int j = i + 1; j < Array.length; j++) {
				if (Array[j] > Array[max]) {
					max = j;
				}
			}

			if (Array[i] < Array[max]) {
				int tmp = Array[i];
				Array[i] = Array[max];
				Array[max] = tmp;
			}
		}

		for (int i = 0; i < Array.length; i++) {
			System.out.print(Array[i]);
		}
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Array[] = new int[N];
		
		for (int i=0; i<N; i++) {
			Array[i] = sc.nextInt();
		}
		
		// 버블 정렬을 구현하는 영역
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<N-1-i; j++) {
				if (Array[j] > Array[j+1]) {	// 왼쪽 값이 오른쪽 값보다 큰 경우
					int tmp = Array[j];			// 스왑
					Array[j] = Array[j+1];
					Array[j+1] = tmp;
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.println(Array[i]);
		}
	}
}
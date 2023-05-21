import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int previousVal = -1;       // 이전 원소
        
        for(int i=0; i<arr.length; i++) {
            // 현재 배열의 원소가 이전 원소와 같지 않다면 == 연속된 숫자가 아니라면
            if (arr[i] != previousVal) {
                answer.add(arr[i]);     // 삽입
                previousVal = arr[i];
            }
        }
        
        return answer;
    }
}        
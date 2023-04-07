import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] check = new boolean[10];
        for(int j=0;j<numbers.length;j++){
                check[numbers[j]] = true;
        }
                
        for(int i=0;i<=9;i++){
            if(!check[i]) answer += i;
        }
        return answer;
    }
}
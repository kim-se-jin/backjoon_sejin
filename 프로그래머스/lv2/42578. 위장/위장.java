import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            String cate = clothes[i][1];
            String str = clothes[i][0];
            if(hm.containsKey(clothes[i][1])){
                hm.put(clothes[i][1], hm.get(clothes[i][1])+1);
            }else{
                hm.put(clothes[i][1],1);
            }
        }
        
        for(int nxt : hm.values()){
            answer *= nxt+1;
        }
        
        return answer-1;
    }
}
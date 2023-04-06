import java.util.*;
import java.io.*;

class Solution {
    static int len;
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String, Integer> hm = new HashMap<>();
        len = name.length;
        for(int i=0;i<len;i++){
            hm.put(name[i],yearning[i]);
        }
                
        int ans ;
        answer = new int[photo.length];
        for(int i=0;i<photo.length;i++){
            ans = 0 ;

            for(int j=0;j<photo[i].length;j++){
                if(hm.containsKey(photo[i][j])){
                    ans += hm.get(photo[i][j]);
                }
            }
            answer[i] = ans ;
        }
        return answer;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited ;
    static int answer ;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        DFS(begin, target, words,0);
        
        if(answer == Integer.MAX_VALUE) answer = 0 ;
        return answer;
    }
    
    public static void DFS(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)){
            answer = Math.min(answer, cnt) ;
            return ;
        }
        
        for(int i=0;i<words.length;i++){
            if(visited[i]) continue ;
            
            int k=0;
            for(int j=0;j<words[i].length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k ++;
            }
            
            if(k == words[i].length()-1){
                visited[i] = true ;
                DFS(words[i], target, words, cnt+1);
                visited[i] = false ;
            }
        }
        
    }
}
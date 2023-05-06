
import java.io.*;
import java.util.*;

class Solution {
    static boolean visited[] ;
    static int N;
    static ArrayList<String> str ;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        N = tickets.length;

        str = new ArrayList<>();
        visited = new boolean[N];
        
        DFS("ICN","ICN", tickets,0);
        Collections.sort(str);
        answer = str.get(0).split(" ");
        // System.out.println(A)
        return answer;
    }
    
    public static void DFS(String start, String ans, String[][] tickets, int cnt){
        if(cnt == N){
            str.add(ans);
            return ;
        }
        
        for(int i=0;i<N;i++){
            if(tickets[i][0].equalsIgnoreCase(start) && !visited[i]){
                visited[i] = true ;
                DFS(tickets[i][1], ans+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false ;
            }
        }
    }
    
    public static boolean check(){
        for(int i=0;i<N;i++){
            if(!visited[i]) return false ;
        }
        return true ;
    }
}
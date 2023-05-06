import java.io.*;
import java.util.*;

class Solution {
    static int parent[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue ;
                if(computers[i][j] == 1 ) union(i,j);
            }
        }
        // System.out.println(Arrays.toString(parent));
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) set.add(find(i));
        
        return set.size();
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)return;
        if(b<a) parent[a] = b;
        else parent[b] = a ;
    }
    
    public static int find(int idx){
        if(idx == parent[idx]) return idx;
        else return find(parent[idx]);
    }
}
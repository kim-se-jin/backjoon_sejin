import java.util.*;
import java.io.*;

class Solution {
    static int[][] arr ;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        arr = new int[n+1][n+1];
        
        int x,y;
        for(int i=0;i<results.length;i++){
            x = results[i][0];
            y = results[i][1];
            arr[x][y] = 1;
            arr[y][x] = -1;
        }
        
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j || k==i) continue ;
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1 ;
                        arr[j][i] = -1 ;
                    }
                    if(arr[i][k]==-1 && arr[k][j]== -1){
                        arr[i][j] = -1;
                        arr[j][i] = 1 ;
                    }
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            boolean check = true;
            for(int j=1;j<n+1;j++){
                if(i==j)continue;
                if(arr[i][j] == 0){
                    check = false;
                    break;
                }
            }
            if(check) answer ++ ;
        }
        
        return answer;
    }
}
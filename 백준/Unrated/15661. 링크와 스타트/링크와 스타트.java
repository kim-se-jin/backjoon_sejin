import java.util.*;
import java.io.*;

public class Main {

    static int N,arr[][],answer;
    static boolean visited[];

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        StringTokenizer st ;
        
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        DFS(0,0);
        System.out.print(answer);
    }
    static int a,b;
    public static void DFS(int idx, int depth){
        
        if(depth >= 1 && depth<N){
            a=0; b=0;
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    if(visited[i] && visited[j]){
                        a += arr[i][j] + arr[j][i];
                    }else if(!visited[i] && !visited[j]){
                        b += arr[i][j] + arr[j][i];
                    }
                }
            }
            answer = Math.min(Math.abs(a-b),answer);
        }
        //<-- 값 계산

        for(int i=idx;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(i,depth+1);
                visited[i] = false;
            }
        }

    }

}

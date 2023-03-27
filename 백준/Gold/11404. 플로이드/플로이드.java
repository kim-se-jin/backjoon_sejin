import java.util.*;
import java.io.*;

class Node{
    int y,cost;
    Node(int y, int cost){
        this.y = y;
        this.cost = cost;
    }
}
 
public class Main {
 
    static int N,M, dists[][];
    static ArrayList<Node>[] arr;
    static StringBuilder sb ;
    static int INF = 10000001;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine()); // 도시 개수
        M = stoi(br.readLine()); // 버스 개수
        dists = new int[N][N];

        for(int i=0;i<N;i++) Arrays.fill(dists[i],INF);
        
        StringTokenizer st ;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken())-1;
            int y = stoi(st.nextToken())-1;
            int cost = stoi(st.nextToken());
            dists[x][y] = Math.min(cost, dists[x][y]);
        }
        
        floyd();
        sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(dists[i][j]==INF?"0 ":dists[i][j]+" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    public static void floyd(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) dists[i][j] = 0 ;
                    dists[i][j] = Math.min(dists[i][k]+dists[k][j], dists[i][j]);
                }
            }
        }
    }
}
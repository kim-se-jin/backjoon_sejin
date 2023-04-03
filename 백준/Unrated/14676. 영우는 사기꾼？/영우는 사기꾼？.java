import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
 
public class Main {
    static ArrayList<Integer>[] arr;
    static int[] indegree,maked;
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 건물 종류의 수
        M = Integer.parseInt(st.nextToken()); // 건물 사이 관계의 수
        K = Integer.parseInt(st.nextToken()); // 영우의 게임 정보 수
        
        arr = new ArrayList[N];
        indegree = new int[N];
        maked = new int[N];

        for(int i=0;i<N;i++)arr[i] = new ArrayList<>();
        int x,y;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            arr[x].add(y);
            indegree[y]++;
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken())-1;
            if(x==1){ // 건설
                // System.out.println("make " + indegree[y]);
                if(indegree[y] <= 0 ) make(y);
                else outOfGame();
            }else{ // 파괴
                // System.out.println("destroy");
                if(maked[y]>0) destroy(y);
                else outOfGame();
            }
        }
        System.out.print("King-God-Emperor");

    }

    public static void make(int idx){
        for(int nxt : arr[idx]){
            if(maked[idx]==0) indegree[nxt]--;
        }
        maked[idx] += 1 ;
    }

    public static void destroy(int idx){
        maked[idx] -= 1;
        for(int nxt:arr[idx]){
            if(maked[idx]==0) indegree[nxt]++;
        }
    }

    public static void outOfGame(){
        System.out.print("Lier!");
        System.exit(0);
    }

 
}

import java.util.*;
import java.io.*;
 
 
class node{
    int start, end, cost;
 
    public node(int start,int end, int cost) {
        this.end = end;
        this.start=start;
        this.cost = cost;
    }
}
 
 
public class Main {
 
    static int N,M;
    static ArrayList<node> list;
    static long[] dists;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        list = new ArrayList<>();
        dists = new long[N];
        Arrays.fill(dists,Integer.MAX_VALUE);

        int a, b, c ;
        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
        	a = stoi(st.nextToken())-1;
            b = stoi(st.nextToken())-1;
            c = stoi(st.nextToken());
            list.add(new node(a,b,c));
        }
 
 
        StringBuilder sb = new StringBuilder();
 
        if(bell()){
            for (int i = 1; i < N; i++) {
                sb.append(dists[i] == Integer.MAX_VALUE?"-1":dists[i]);
                sb.append("\n");
            }
        }else{
            sb.append(-1);
        }
 
        System.out.print(sb.toString());
    }
 
 
    public static boolean bell() {
        dists[0] = 0; // 시작노드 초기화

        // 전체 N번 반복
        for(int i=0; i<N; i++){
            // 매 반복마다 "모든 간선" 확인
            for(node a: list){
                if(dists[a.start]==Integer.MAX_VALUE) continue;

                if(dists[a.end]>dists[a.start]+a.cost){
                    dists[a.end]=dists[a.start]+a.cost;

                }
            }
        }

        for(int i=0; i<N; i++){
            for(node a: list){
                if(dists[a.start]==Integer.MAX_VALUE) continue;

                if(dists[a.end]>dists[a.start]+a.cost){
                    return false; // 갱신된다 = 음수 싸이클
                }
            }
        }
        return true;

    }
}
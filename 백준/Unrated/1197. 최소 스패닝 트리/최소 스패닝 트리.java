import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x,y,cost;
    Node(int x, int y, int cost){
        this.x = x ;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost ;
    }
}
 
public class Main {
 
    static int V,E,parent[];

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        parent = new int[V];

        for(int i=0;i<V;i++) parent[i] = i ;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken())-1;
            int y = stoi(st.nextToken())-1;
            int cost = stoi(st.nextToken()); 
            pq.add(new Node(x,y, cost));
        }
        //<--

        int total = 0 ;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int x = find(nowNode.x);
            int y = find(nowNode.y);
            if(x != y){
                total += nowNode.cost ;
                union(nowNode.x, nowNode.y);
            }
        }
        System.out.print(total);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        parent[y] = x ;
    }

    public static int find(int idx){
        if(parent[idx] == idx ) return idx;
        else return find(parent[idx]);
    }

}
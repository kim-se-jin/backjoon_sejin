import java.io.*;
import java.util.*;

class Node{
	int x,y,cost;
	Node(int x, int y, int cost){
		this.x=x;
		this.y=y;
		this.cost=cost;
	}
}

public class Main {
	static int N,M,K,X,dist[];
	static ArrayList<Integer>[] graph ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N개의 도시
		M = Integer.parseInt(st.nextToken()); // M개의 도로
		K = Integer.parseInt(st.nextToken()); // 거리정보
		X = Integer.parseInt(st.nextToken()); // 출발도시

		dist = new int[N];
		Arrays.fill(dist, 10000001);
		graph = new ArrayList[N];
		for(int i=0;i<N;i++)graph[i] = new ArrayList<>();

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			graph[x].add(y);
		}
		
		dijkstra(X-1);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			if(dist[i] == K) sb.append((i+1)+"\n");
		}
		if(sb.length()==0) System.out.print(-1);
		else System.out.print(sb);
    }

	public static void dijkstra(int idx){
		dist[idx] = 0 ;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(idx);

		while(!pq.isEmpty()){
			int now = pq.poll();
			for(int nxt : graph[now]){
				if(dist[nxt] > dist[now]+1){
					dist[nxt] = dist[now]+1;
					pq.add(nxt);
				}
			}
		}

	}
}
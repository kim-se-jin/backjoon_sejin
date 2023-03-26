import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int idx, dist;
	Node(int idx, int dist){
		this.idx = idx ;
		this.dist = dist ;
	}

	@Override
	public int compareTo(Node o){
		return this.dist-o.dist ;
	}
}

public class Main{

	static int N,M,K,start;
	static ArrayList<Integer>[] map;
	static int[] dists ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // 도시의 개수
		M = stoi(st.nextToken()); // 도로의 개수
		K = stoi(st.nextToken()); // 거리 정보
		start = stoi(st.nextToken())-1; // 출발 도시

		map = new ArrayList[N];
		for(int i=0;i<N;i++)map[i] = new ArrayList<>();
		dists = new int[N];
		Arrays.fill(dists, Integer.MAX_VALUE);

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken())-1;
			int y = stoi(st.nextToken())-1;
			map[x].add(y);
		}

		// X에서 출발해서 최단거리 구하기
		dijkstra();

		// 답 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			if(dists[i] == K) sb.append(i+1+"\n");
		}

		if(sb.length() == 0) System.out.print(-1);
		else System.out.print(sb);
	}

	public static void dijkstra(){

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);
		dists[start] = 0 ;

		while(!pq.isEmpty()){
			int idx = pq.poll();
			for(int nxt : map[idx]){
				if(dists[nxt] > dists[idx]+1){
					dists[nxt] = dists[idx]+1;
					pq.offer(nxt);
				}
				}
		}

	}

}


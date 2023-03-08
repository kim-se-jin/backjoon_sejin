import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int x,y,cost;
	Node(int x, int y, int cost){
		this.x = x ;
		this.y = y ;
		this.cost = cost ;
	}

	@Override
	public int compareTo(Node o){
		return this.cost - o.cost;

	}
}

public class Main{

	static int N,M;
	static ArrayList<Node> graph ;
	static int[] parent; 

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine()); // 컴퓨터의 수
        M = stoi(br.readLine()); // 연결할 수 있는 선의 수
        graph = new ArrayList<>();
		parent = new int[N];
		for(int i=0;i<N;i++) parent[i] = i ;

        
		StringTokenizer st ;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()) - 1;
			int b = stoi(st.nextToken()) - 1 ;
			int cost = stoi(st.nextToken());
			graph.add(new Node(a,b,cost));
		}

		Collections.sort(graph);

		int result = 0 ;

		for(int i=0;i<M;i++){
			Node nowNode = graph.get(i);

			if(find(nowNode.x) != find(nowNode.y)){
				result += nowNode.cost;
				union(nowNode.x, nowNode.y);
			}

		}

		System.out.println(result);

	}

	// 모든 컴퓨터가 연결되어 있을 때, 최소 비용
		// 모든 컴퓨터 연결 => 싸이클 확인 => 유니온파인드


	public static void union(int a, int b){
		a = find(a);
		b = find(b);

		if(a != b ) parent[b] = a ;
	}

	public static int find(int idx){
		if(parent[idx] == idx) return idx ;
		else return find(parent[idx]);

	}

}
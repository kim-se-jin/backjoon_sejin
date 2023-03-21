import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{

	static int N,M,V;
	static ArrayList<Integer>[] arr ;
	static boolean[] visited; 
	static StringBuilder sb ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); //정점 개수
		M = stoi(st.nextToken()); //간선 개수
		V = stoi(st.nextToken()); //탐색 시작 번호

		arr = new ArrayList[N+1];
		for(int i=0;i<=N;i++)arr[i] = new ArrayList<>();

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		//<--

		for(int i=0;i<=N;i++) Collections.sort(arr[i]);

		sb = new StringBuilder();
		visited = new boolean[N+1];
		visited[V] = true ;
		DFS(V);
		sb.append("\n");

		visited = new boolean[N+1];
		visited[V] = true ;
		BFS(V);
		System.out.println(sb);
	}

	public static void DFS(int idx){
		sb.append(idx+" ");
		for(int nxt : arr[idx]){
			if(!visited[nxt]){
				visited[nxt] = true;
				DFS(nxt);
			}
		}
	}

	public static void BFS(int start){
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while(!q.isEmpty()){
			int now = q.poll();
			sb.append(now+" ");
			for(int nxt : arr[now]){
				if(!visited[nxt]){
					visited[nxt] = true ;
					q.add(nxt);
				}
			}
		}

	}

}
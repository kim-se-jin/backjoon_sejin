import java.io.*;
import java.util.*;

public class Main{

	static int N , M ;
	static ArrayList<Integer>[] arr ;
	static boolean[] visited ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new ArrayList[N];
		visited = new boolean[N];

		for(int i=0;i<N;i++) arr[i] = new ArrayList<>();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int u = stoi(st.nextToken())-1;
			int v = stoi(st.nextToken())-1;
			arr[v].add(u);
			arr[u].add(v);
		}

		int count = 0 ;

		for(int i=0;i<N;i++){
			if(!visited[i]){
				DFS(i);
				count ++;
			}

		}

		System.out.println(count);
    }

	public static void DFS(int idx){
		for(int nxtIdx : arr[idx]){
			if(!visited[nxtIdx]){
				visited[nxtIdx] = true ;
				DFS(nxtIdx);
			}
		}
	}
}
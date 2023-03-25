import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

	static int N,M, parent[];
	static ArrayList<Integer>[] arr;
	static int MAX = 501;
    static int[][] crossed;   // 간선
	static String result = "NO";

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // 지점개수
		M = stoi(st.nextToken()); // 연결구간개수

		crossed = new int[N][N];
		arr = new ArrayList[N];
		for(int i=0;i<N;i++) arr[i] = new ArrayList<>();

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken())-1;
			int y = stoi(st.nextToken())-1;
			arr[x].add(y);
			arr[y].add(x);
		}
	
        for (int i = 0; i < N ; i++) {
            // 모든 정점을 훑어봄
            DFS(i,i,0);
        }
		System.out.print(result);
	}

	public static void DFS(int now, int num, int count){
		if(count == M){
			result = "YES";
			return ;
		}
		
		for(int nxt : arr[now]){
			if(crossed[now][nxt] == num || crossed[nxt][now] == num) continue ;
			crossed[now][nxt] = crossed[nxt][now] = num ;
			DFS(nxt,num,count+1);
		}

	}

}
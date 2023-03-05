import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[] parent ;
	static int[][] map;
	static int CheckParent = -1; 
	static StringTokenizer st ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N+1];

		for(int i=0;i<N+1;i++) parent[i] = i;

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				int now = Integer.parseInt(st.nextToken());
				if(now == 1) union(i,j);
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
			int a = Integer.parseInt(st.nextToken())-1;
			if(CheckParent == -1 ) CheckParent = find(a);
			else{
				if(CheckParent != find(a)) {
				    System.out.println("NO");
                    return;
				}
			}
		}

		System.out.println("YES");

	}

	public static void union(int x, int y){
		x = find(x);
		y= find(y);
		if(x==y) return;
		parent[y] = x;
	}

	public static int find(int idx){
		if(parent[idx] == idx) return idx;
		parent[idx] = find(parent[idx]);
		return parent[idx];
	}
}
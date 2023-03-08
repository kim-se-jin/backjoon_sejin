import java.io.*;
import java.util.*;
import java.awt.Point ;

public class Main{

	static int N,M;
	static ArrayList<Integer>[] graph ;
	static int[][] dists ;
	static boolean[] visited; 

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	// 크루스칼 접근 -> DP
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		graph = new ArrayList[N];
		dists = new int[N][N];
		visited = new boolean[N];

		for(int i=0;i<N;i++){
			graph[i] = new ArrayList<>();
			Arrays.fill(dists[i] , 10001 );
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken()) -1 ;
			int y = stoi(st.nextToken()) -1 ;
			graph[x].add(y);
			graph[y].add(x);
			dists[x][y] = 1 ;
			dists[y][x] = 1 ;
		}

		// 크루스칼로 왕복 거리를 구함
		for(int i=0;i<N;i++){
			for(int x=0;x<N;x++){
				for(int y=0;y<N;y++){
					if(x == y) dists[x][y] = 0 ;
					else dists[x][y] = Math.min(dists[x][i]+dists[i][y], dists[x][y]);
				}
			}
		}
		comb();
		System.out.println((A_Building+1) + " " + (B_Building+1) + " " + (minResult*2));
	}

	static int A_Building = 0 ;
	static int B_Building = 0 ;
	static int minResult = Integer.MAX_VALUE;

	public static void comb(){
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				int dist = 0 ;
				for(int idx=0;idx<N;idx++){
					dist += Math.min(dists[i][idx], dists[j][idx]);
				}
				if(dist<minResult){
					A_Building = i ;
					B_Building = j ;
					minResult = dist  ;
				}
			}
		}
	}

}
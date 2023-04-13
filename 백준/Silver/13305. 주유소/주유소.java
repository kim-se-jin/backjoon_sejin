import java.io.*;
import java.util.*;
 
public class Main {
	static int N,X,road[],cost[];
	static long dp[][];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		
		road = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++){
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		cost = new int[N];
		for(int i=0;i<N;i++){
			cost[i] = Integer.parseInt(st.nextToken());
		}

		dp = new long[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(j==0) dp[i][j] = 0 ;
				else dp[i][j] = Long.MAX_VALUE;
			}
		}
		for(int i=1;i<N;i++){
			for(int j=i;j<N;j++){
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j-1])+ (long)cost[i-1]*road[j-1];
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
			}
		}

		System.out.println(dp[N-1][N-1]);
    }

 
}
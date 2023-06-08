import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,dp[];
	static int MAX = 100_001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[MAX];
		dp[N] = 0 ;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while(!q.isEmpty()){
			int now = q.poll();

			if(now == M){
				System.out.println(dp[M]);
				return ;
			}

			if(range(now-1) && dp[now-1] == 0){
				dp[now-1] = dp[now]+1;
				q.add(now-1);
			}
			if(range(now+1)&& dp[now+1] == 0){
				dp[now+1] = dp[now]+1;
				q.add(now+1);
			}
			if(range(now*2)&& dp[now*2] == 0){
				dp[now*2] = dp[now]+1;
				q.add(now*2);
			}
		}
	}

	public static boolean range(int idx){
		if(idx>=0 && idx<MAX) return true ;
		else return false ;
	}
}
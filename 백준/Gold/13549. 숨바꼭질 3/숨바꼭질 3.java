import java.io.*;
import java.util.*;


public class Main {
	static int N, M, INF;
	static int[] dp = new int[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		INF = 1000001 ;
		
		Arrays.fill(dp,INF);
		dp[N] = 0 ;
		DFS(N);
    }

	public static void DFS(int idx){
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while(!q.isEmpty()){	
			int now = q.poll();
			if(now == M){
				System.out.println(dp[M]);
				break;
			}
			if(now>0 && dp[now-1] > (dp[now]+1)){
				dp[now-1] = dp[now] + 1 ;
				q.add(now-1);
			}

			if(now+1<INF && dp[now+1] > dp[now]+1){
				dp[now+1] = dp[now]+1;
				q.add(now+1);
			}

			if(now*2<INF && dp[now*2] > dp[now]){
				dp[now*2] = dp[now];
				q.add(now*2);
			}
		}
	}


}
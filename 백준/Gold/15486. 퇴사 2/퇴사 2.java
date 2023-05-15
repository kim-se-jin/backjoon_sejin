import java.io.*;
import java.util.*;
 
public class Main {
	static int dp[] ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// dp = new int[2_000_001];
		dp = new int[N+2];
		StringTokenizer st ;
		for(int i=1;i<N+1;i++){
			// System.out.println("now i : " + i );
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(i+day > N+1){
				// System.out.println(Arrays.toString(dp));
				continue ;
			} 
			dp[i+day] = Math.max(dp[i+day], dp[i]+pay);
			// System.out.println(Arrays.toString(dp));
		}
		dp[N+1] = Math.max(dp[N], dp[N+1]);
		System.out.print(dp[N+1]);
	}
}
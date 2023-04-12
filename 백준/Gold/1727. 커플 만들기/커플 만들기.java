import java.io.*;
import java.util.*;
 
public class Main {
	static int N,M,man[], woman[],dp[][];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken()); // 남자수
        M = Integer.parseInt(st.nextToken()); // 여자수
		man = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			man[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(man);

		woman = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++){
			woman[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(woman);
		dp = new int[N+1][M+1];
		//dp[i][j] : (1~i)까지의 남자와 (1~j)까지의 여자를 커플 매칭했을때 성격 차이 최소값
		for(int i=1;i<=N;i++){
			for(int j=1;j<=M;j++){
				//i번 남자와 j번 여자 커플 매칭
				dp[i][j] = dp[i-1][j-1] + Math.abs(man[i] - woman[j]);
				//남자가 더 많으면 추가된 i번 남자 솔로
				if (i > j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				//여자가 더 많으면 추가된 j번 여자 솔로
				else if (i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
			}
		}

		System.out.println(dp[N][M]);


        
    }

	

 
}
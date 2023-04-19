import java.io.*;
import java.util.*;


public class Main {
	static int N, M;
	static boolean[][] arr ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][N];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			arr[x][y] = true ;
		}

		// 모든 노드에서 -> 자신 길 알고 있다면? ==> 정답
		// => 플로이드 워셜로, 모든 경로를 구함
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!arr[i][j]){
						if(arr[i][k] && arr[k][j]) arr[i][j] = true ;
					}
				}
			}
		}
		int[] cnt = new int[N];
		// 모든 경로가 연결되어있는 지 확인
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j] || arr[j][i]) cnt[i] ++ ;
			}
		}

		int ans = 0 ;
		for(int num : cnt){
			if(num == N-1) ans ++;
		}
		System.out.print(ans);
    }


}
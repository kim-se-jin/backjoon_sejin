import java.io.*;
import java.util.*;

public class Main {
	static int N,arr[];
	static boolean[] visited ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 1. DFS -> 시간초과 날 것 같은데
		// 2. DP -> 4개를 확인할 방도가 없지 않을까
		// 3. 정렬 후 이분탐색
		Arrays.sort(arr);
		twoPointer();
		System.out.println(ans);
    }

	static int ans = Integer.MAX_VALUE;
	public static void twoPointer(){

		for(int i=0;i<N-3;i++){
			for(int j=i+3;j<N;j++){
				// System.out.println(i+ " , " + j);
				int left=i+1;
				int	right=j-1;
				while(left<right){
					int res = arr[left]+arr[right]-arr[i]-arr[j];
					if(ans>Math.abs(res)) ans = Math.abs(res);
					
					if(res>0)right --;
					else left ++ ;

				}
			}
		}
		
		
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int N,M,arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		twoPointer();

	}

	public static void twoPointer(){
		int start = 0 ;
		int end = arr[N-1]-arr[0];
		int ans = -1 ;
		while(start<=end){
			
			int mid = (start+end)/2;
			int cnt = calDist(mid);

			if(cnt<M){
				end = mid -1;
			}else{				
				start = mid+1;
				ans = Math.max(mid, ans);
			}
		}
		System.out.println(ans);
	}

	public static int calDist(int idx){
		int count = 1 ;
		int befNum = arr[0];

		for(int i=1;i<N;i++){

			if(arr[i]-befNum>=idx){
				count++;
				befNum=arr[i];
			}
			
		}
		return count;
	}
}
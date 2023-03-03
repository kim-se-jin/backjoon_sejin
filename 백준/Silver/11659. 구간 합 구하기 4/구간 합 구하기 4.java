import java.io.*;
import java.util.*;

// 시간복잡도 : O(N)

public class Main {

	static int N,M; 
	static int[] sumArr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // N개의 수
		M = stoi(st.nextToken()); // M번 누적합 구하기
		sumArr = new int[N+1]; // 누적합

		st = new StringTokenizer(br.readLine());
		// 값 입력받으며 누적합 구함
		for(int i=1;i<N+1;i++) sumArr[i] += sumArr[i-1] + stoi(st.nextToken()); 
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){ 
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken());
			int end = stoi(st.nextToken());
			sb.append(sumArr[end]-sumArr[start-1]+" ");
		}
		System.out.println(sb.toString());
	} 
}
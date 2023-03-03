import java.io.*;
import java.util.*;

// 시간복잡도 : O(N)

public class Main {

	static int N,K; 
	static int[] sumArr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // N개의 수
		K = stoi(st.nextToken())-1; // 연속적인 날짜의 수
		sumArr = new int[N+1]; // 누적합

		st = new StringTokenizer(br.readLine());
		// 값 입력받으며 누적합 구함
		for(int i=1;i<N+1;i++) sumArr[i] += sumArr[i-1] + stoi(st.nextToken()); 
		
		int MaxAns = Integer.MIN_VALUE;
		for(int i=1;i<N+1-K;i++){ // 누적합에서 i~i+K개씩 값 계산하여 최댓값 구하기 
			MaxAns= Math.max(MaxAns, sumArr[i+K]-sumArr[i-1]);
		}
		System.out.println(MaxAns);
	} 
}
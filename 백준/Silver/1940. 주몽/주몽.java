import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[] arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		M = stoi(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());

		// 반복문을 통한 누적합 확인은 시간초과가 나므로 
			// 투포인터

		
		Arrays.sort(arr);
		System.out.println(twoPointer());

	} 

	public static int twoPointer(){
		int start = 0 ; // 시작 인덱스값
		int end = N-1 ; // 끝 인덱스값
		int count = 0 ; // 합이 M이 되는 개수

		while(start < end){
			int sum = arr[start] + arr[end];
			if(sum == M){
				count ++ ;
				end --;
				start ++;
			}else if(sum > M) end -- ;
			else start ++ ;
			
		}

		return count ;
	}

}

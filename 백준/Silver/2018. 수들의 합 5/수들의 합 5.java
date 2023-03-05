import java.io.*;
import java.util.*;

public class Main {

	static int N ;
	static int[] sumArr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		sumArr = new int[N+1];

		// 누적합 계산
		for(int i=1;i<N+1;i++){
			sumArr[i] = sumArr[i-1] + i ;
		}

		// 누적합 구하기
		System.out.println(twoPointer());
	} 

	public static int twoPointer(){

		int count = 0 ;
		int start = 1 ;
		int end = 1 ;

		while(start<=N && end<=N){
			int result = sumArr[end] - sumArr[start-1];
			if(result == N ) count ++ ;
			if(result > N) start ++ ;
			else end ++ ;
		}

		return count ;
	}
}
import java.io.*;
import java.util.*;

public class Main {

	static int N ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		// 누적합 구하기
		System.out.println(twoPointer());
	} 

	public static int twoPointer(){

		int count = 0 ;
		int start = 1 ;
		int end = 1 ;
		int result = 1 ;

		while(start<=N && end<=N){
			if(result == N ) count ++ ;
			if(result > N){
				result -= start ;
				start ++ ;
			}else{
				end ++ ;
				result += end ;
			}
		}

		return count ;
	}
}
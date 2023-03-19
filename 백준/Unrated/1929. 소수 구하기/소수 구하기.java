import java.io.*;
import java.util.*;

public class Main{

	static int M,N  ;
	static boolean[] arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = stoi(st.nextToken());
		N = stoi(st.nextToken());
		arr = new boolean[N+1];
        
		// N까지 값을 비교하며 sb에 추가
		for(int idx=2;idx<N+1;idx++){
			if(arr[idx]) continue ;

			if(idx>=M) sb.append(idx+"\n");

			for(int i=idx*2; i<N+1; i+=idx){
				arr[i] = true ;
			}
		}
		

		// 정답 출력
		System.out.print(sb);
		
	}
}
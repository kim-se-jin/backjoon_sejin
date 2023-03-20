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
		StringBuilder sb = new StringBuilder();

		while(true){
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int count = 0 ;

			arr = new boolean[2*N+1];

			for(int i=2;i<=2*N;i++){
				if(arr[i]) continue ;

				arr[i] = true ;
				if(i>N) count ++ ;

				for(int idx=i*2;idx<=2*N;idx+=i){
					arr[idx] = true ;
				}
			}
			sb.append(count+"\n");
		}

		System.out.print(sb);
	}
}
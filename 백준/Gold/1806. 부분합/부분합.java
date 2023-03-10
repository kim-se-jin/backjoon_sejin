import java.io.*;
import java.util.*;

public class Main{

	static int N,S;
	static int[] arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}


    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		S = stoi(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = stoi(st.nextToken());
		}

		int minLength = Integer.MAX_VALUE;

		int start = 0 ;
		int end = 0 ;
		long allSum = 0 ;
		while(start<=N && end<=N){
			if(allSum >= S ){
				minLength = Math.min(minLength, end-start);
				allSum -= arr[start++];
			}else {
				if(end == N ) break ;
				allSum += arr[end++];
			}


		}
		if(minLength == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minLength);

	}
}
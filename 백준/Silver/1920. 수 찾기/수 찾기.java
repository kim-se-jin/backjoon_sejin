import java.io.*;
import java.util.*;

public class Main{

	static int N , M ;
	static int[] arr ;
	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken()); 
		Arrays.sort(arr);

		M = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			if(findNum(stoi(st.nextToken()))) sb.append("1"+"\n"); 
			else sb.append("0"+"\n"); 
		}
		System.out.println(sb);
	}

	public static boolean findNum(int num){
		int start = 0 ;
		int end = N-1 ;
		boolean flag = false;
		while(start<=end){
			int mid = (start+end)/2;
			if(arr[mid] == num){
				flag = true;
				break;
			}

			if(arr[mid]<num) start = mid+1;
			else end = mid-1 ;

		}
		return flag ;
	}
}
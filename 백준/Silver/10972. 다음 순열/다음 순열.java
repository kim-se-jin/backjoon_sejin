import java.io.*;
import java.util.*;


public class Main {
	static int N,arr[];
	static boolean ans = false ;
	static StringBuilder sb ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		if(findNxt()){
			for(int now : arr) sb.append(now + " ");
			System.out.print(sb);
		}else{
			System.out.print(-1);
		}
    }

	public static boolean findNxt(){
		int i = N-1 ;
		// 내림차순 정렬이므로, 뒤에서부터 arr[i-1] < arr[i] 인 값을 찾는다. 
		while(i>0){
			if(arr[i-1] < arr[i]) break;
			i--;
		}

		if(i==0) return false ;
		// i 뒤 가장 작은 수 찾기
		int j = N-1;
		while(arr[i-1] >= arr[j]){
			j -- ;
		}

		// i-1 이랑 j swap 
		int temp = arr[j];
		arr[j] = arr[i-1];
		arr[i-1] = temp ;
		j = N-1 ;

		// arr[i] 부터 뒤집기
		while(i<j){
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp ;
			i ++ ;
			j -- ;
		}
		return true ;
	}

}
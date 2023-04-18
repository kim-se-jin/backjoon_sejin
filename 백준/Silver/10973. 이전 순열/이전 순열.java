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

		while(i>0 && arr[i-1] <= arr[i]) i-- ;
		if(i==0) return false ;

		int j = N-1 ;
		while(arr[j] >= arr[i-1]) j-- ;

		swap(i-1,j);

		j = N-1 ;
		while(i<j){
			swap(i,j);
			i ++ ;
			j -- ;
		}

		return true ;

	}

	public static void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp ;

	}

}
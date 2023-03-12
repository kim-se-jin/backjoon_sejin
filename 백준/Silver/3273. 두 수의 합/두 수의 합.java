import java.io.*;
import java.util.*;

public class Main{

	static int N , X ;
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

		X = stoi(br.readLine());
		// BubbleSort();
		Arrays.sort(arr);
		System.out.println(TwoPointer());
    }

	public static void BubbleSort(){
		for(int i=0;i<N;i++){
			boolean flag = false;
			for(int idx=0;idx<N-i-1;idx++){
				if(arr[idx]>arr[idx+1]){
					flag = true ;
					int temp = arr[idx+1];
					arr[idx+1] = arr[idx];
					arr[idx] = temp ;

				}
			}
			if(!flag) break;
		}
	}

	public static int TwoPointer(){
		int start = 0 ;
		int end = N-1 ;
		int count = 0 ;
		// System.out.println(Arrays.toString(arr));

		while(start<end){
			if(end<0) break;
			// System.out.println(start+ " , " + end);
			if(arr[start]+arr[end] == X){
				count ++;
				start ++;
				end --;
			}else if(arr[start]+arr[end] > X ){
				end -- ;
			}else{
				start++;
			}
		}

		return count ;
	}
}
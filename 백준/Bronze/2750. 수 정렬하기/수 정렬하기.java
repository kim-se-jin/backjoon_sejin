import java.io.*;
import java.util.*;

public class Main{

	static int N ;
	static int[] arr ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr = new int[N];
		
		for(int i=0;i<N;i++){
			arr[i] = stoi(br.readLine());
		}
		BubbleSort();
		StringBuilder sb = new StringBuilder();
		for(int num : arr) sb.append(num+"\n");
		System.out.println(sb);
    }

	public static void BubbleSort(){
		for(int i=0;i<N;i++){
			boolean flag = false; 
			for(int idx=0;idx<N-i-1;idx++){
				if(arr[idx]>arr[idx+1]){ // i 가 더 클 때 자리변경	
					flag = true ;
					int temp = arr[idx+1];
					arr[idx+1] = arr[idx];
					arr[idx] = temp;
				}
			}
			if(!flag) break; // 변경이 일어나지 않았다 => 정렬된 상태
		}
	}
}
import java.io.*;
import java.util.*;

public class Main{

	static String input ;
	static int N , X ;
	static int[] arr ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		N = input.length();
		arr = new int[N];

		for(int i=0;i<N;i++) arr[i] = input.charAt(i)-'0';

		System.out.println(SelectionSort());
    }

	public static StringBuilder SelectionSort(){
		StringBuilder sb = new StringBuilder();

		int nowIdx = 0 ;
		for(int i=0;i<N;i++){
			boolean flag = false;
			int nowMax = arr[i];
			for(int idx=i;idx<N;idx++){
				if(nowMax<arr[idx]){
					flag = true ;
					nowMax = arr[idx];
					nowIdx = idx ;
				}
			}
			if(flag){ //교체
				int temp = arr[i];
				arr[i] = nowMax ;
				arr[nowIdx] =temp;
			}
			sb.append(arr[i]);
		}
		return sb ;
	}
}
import java.io.*;
import java.util.*;

public class Main{

	static int N ;
	static long M ;
	static ArrayList<Integer> arr ;
	static int MaxHeight = Integer.MIN_VALUE ;
	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		arr = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr.add(stoi(st.nextToken())); 
		
		Collections.sort(arr,Collections.reverseOrder()); // 내림차순 정렬
		findMaxHeight();
		System.out.println(MaxHeight);
	}

	public static void findMaxHeight(){
		int start = 0 ;
		int end = arr.get(0); // 최대 높이

		while(start<=end){
			int mid = (start+end)/2;
			long cutResult = cutTree(mid);
			if(cutResult >= M){ // ==로 해서 계속 틀리나
				MaxHeight = Math.max(MaxHeight, mid) ;
			}

			if(cutResult > M){
				start = mid+1;
			}else{
				end = mid-1 ;

			}
		}
	}

	// 이진탐색 결과 높이로, 잘린 나무의 총 길이를 구함
	public static long cutTree(int nowH){
		long ans = 0 ;
		for(int nowTree : arr){
			if(nowTree > nowH) ans += (nowTree-nowH);
			else break; // 내림차순 정렬이므로, 한 번이라도 낮으면 멈춤
		}
		return ans ;
	}
}
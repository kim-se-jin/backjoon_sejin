import java.io.*;
import java.util.*;

public class Main {
	static int N,arr[];
	static boolean[] visited ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(twoPointer());
    }

	public static int twoPointer(){
		int height_1, height_2, min, left, right;
		int ans = Integer.MAX_VALUE;
		Arrays.sort(arr); // 1. 정렬

		for(int i=0;i<N;i++){ // i,j 눈사람1
			for(int j=i+3;j<N;j++){ // i+3 으로 사이에 최소 2개의 눈사람 생성
				height_1 = arr[i]+arr[j];

				left = i+1; // left,right 눈사람2
				right = j-1;
				while(left<right){
					height_2 = arr[left]+arr[right];
					if(height_1 == height_2) return 0;
					else if (height_1 > height_2) left ++ ;
					else if ( height_1 < height_2 ) right -- ;

					ans = Math.min(ans,Math.abs(height_1 - height_2));
				}

			}
		}
		return ans ;
	}

}
import java.io.*;
import java.util.*;

public class Main {
	static int N,M,nums[];
	static String names[];
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken()); // 칭호 개수
		M = stoi(st.nextToken()); // 캐릭터 수

		nums = new int[N];
		names = new String[N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			names[i] = st.nextToken();
			nums[i] = stoi(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0;i<M;i++){
			int power = stoi(br.readLine());
			sb.append(names[findLevel(power)]+"\n");
		}
		System.out.print(sb);
    }

	public static int findLevel(int power){
		int idx = 0;
		int left = 0 ;
		int right = N ;

		while(left<right){
			int midIdx = (left+right)/2;
			int mid = nums[midIdx];

			if(mid >= power){
				right = midIdx ;

			}else{
				left = midIdx + 1 ;

			}
		}

		return left ;
	}

}
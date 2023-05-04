import java.io.*;
import java.util.*;

public class Main {

	static int N, ans,power[], w[];

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringTokenizer st ;
		ans = Integer.MIN_VALUE;

		power = new int[N];
		w = new int[N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			power[i] = stoi(st.nextToken());
			w[i] = stoi(st.nextToken());
		}
		conflict(0, 0);
		System.out.print(ans);
    }

	public static void conflict(int idx, int count){
		if(idx == N){
			ans = Math.max(ans, count);
			return ;
		}

		if(power[idx] <= 0 || count == N-1){ // 이미 깨진 계란이라면 
			conflict(idx+1, count); // 다음꺼
			return;
		}

		int nowCnt = count ;
		for(int i=0;i<N;i++){
			if(idx == i ) continue ;
			if(power[i] <= 0 ) continue ; // 이미 깨진 계란인 경우 

			// 각 계란의 내구도는 상대 계란의 무게만큼 깎임
			hitEgg(idx, i);
			if(power[idx] <= 0 ) count ++ ;
			if(power[i] <= 0 ) count ++ ;
			conflict(idx+1, count);
			returnEgg(idx, i);
			count = nowCnt;
		}
	}

	public static void hitEgg(int x, int y){
		power[x] -= w[y] ;
		power[y] -= w[x] ;
	}

	public static void returnEgg(int x, int y){
		power[x] += w[y] ;
		power[y] += w[x] ;
	}
}
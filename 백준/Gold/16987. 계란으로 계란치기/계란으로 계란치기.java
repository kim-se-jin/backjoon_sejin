import java.io.*;
import java.util.*;

class egg{
	int power, w;
	boolean gone ;
	egg(int power, int w, boolean gone){
		this.power = power;
		this.w = w ;
		this.gone = gone;
	}
}

public class Main {

	static int N, ans;
	static egg[] arr;
	static boolean[] live;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringTokenizer st ;

		arr = new egg[N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new egg(stoi(st.nextToken()), stoi(st.nextToken()),false);
		}
		conflict(0, arr, 0);
		System.out.print(ans);
    }

	public static void conflict(int idx, egg[] arr, int count){
		if(idx == N) return ;
		if(arr[idx].gone){
			conflict(idx+1, arr, count);
			return;
		}

		for(int i=0;i<arr.length;i++){ // 가장 왼쪽꺼 드니까 1 부터 하나씩 깨보기
			if(idx == i ) continue ;

			// System.out.println("for start : " + i );
			// 깊은 복사
			egg[] newArr = copy(arr);
			int cnt = 0 ;

			egg nowEgg = newArr[idx];
			egg nxtEgg = newArr[i];

			if(newArr[i].gone) continue ; // 이미 깨진 계란인 경우 

			// 각 계란의 내구도는 상대 계란의 무게만큼 깎임
			newArr[idx].power -= nxtEgg.w ;
			newArr[i].power -= nowEgg.w ;
			if(newArr[idx].power <= 0 ){
				cnt ++ ;
				newArr[idx].gone = true ;
			}
			if(newArr[i].power <= 0 ){
				cnt ++ ;
				newArr[i].gone = true ;
			}
			// printegg(newArr);
			
			ans = Math.max(ans, count + cnt);
			conflict(idx+1, newArr, count + cnt );
		}
	}

	public static egg[] copy(egg[] arr){
		egg[] newEgg = new egg[N];
		for(int i=0;i<N;i++){
			newEgg[i] = new egg(arr[i].power, arr[i].w,arr[i].gone);
		}
		return newEgg ;
	}
}

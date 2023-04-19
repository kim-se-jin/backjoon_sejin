import java.io.*;
import java.util.*;


public class Main {
	static int startTime, endTime1, endTime2 ;
	static boolean[][] arr ;
	static HashSet<String> hm ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		startTime = calTime(st.nextToken().split(":"));
		endTime1 = calTime(st.nextToken().split(":"));
		endTime2 = calTime(st.nextToken().split(":"));
		hm = new HashSet<>();
		int cnt = 0 ;

		while(true){
			String now = br.readLine();
			if(now == null) break;
			String[] inputs = now.split(" ");
			int nowTime = calTime(inputs[0].split(":"));
			if(hm.contains(inputs[1])){ // 이름이 있다면
				// 나가기
				if(checkAtrEnd(nowTime)){
					hm.remove(inputs[1]);
					cnt ++ ;
				}

			}else{ //없다면
				// 개총 시간 이전 확인 -> 출석 인정
				if(checkBefStart(nowTime)) hm.add(inputs[1]);

			}
		}
		System.out.print(cnt);

    }

	public static int calTime(String[] time){
		return stoi(time[0])*60 + stoi(time[1]);
	}

	public static boolean checkBefStart(int nowTime){
		if(nowTime <= startTime) return true ;
		else return false ;
	}

	public static boolean checkAtrEnd(int nowTime){
		if(nowTime == endTime1 || nowTime == endTime2) return true ;
		if(nowTime >= endTime1 && nowTime <= endTime2) return true ;  
		else return false ;
	}
}
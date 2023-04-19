import java.io.*;
import java.util.*;


public class Main {
	static boolean[][] arr ;
	static String[] times ;
	static HashSet<String> hm ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		times = br.readLine().split(" ");
		hm = new HashSet<>();
		int cnt = 0 ;

		while(true){
			String now = br.readLine();
			if(now == null) break;
			String[] inputs = now.split(" ");
			if(hm.contains(inputs[1])){ // 이름이 있다면
				// 나가기
				if(inputs[0].compareTo(times[1]) >= 0 && inputs[0].compareTo(times[2]) <= 0){
					hm.remove(inputs[1]);
					cnt ++ ;
				}
			}else{ //없다면
				// 개총 시간 이전 확인 -> 출석 인정
				if(inputs[0].compareTo(times[0]) <= 0) hm.add(inputs[1]);
			}
		}
		System.out.print(cnt);
    }
}
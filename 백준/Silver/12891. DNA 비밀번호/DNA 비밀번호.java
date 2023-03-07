import java.io.*;
import java.util.*;

public class Main{

	static int S, P ;
	static String DNAstr;
	static int[] DNAnums ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = stoi(st.nextToken()); //DNA문자열 길이
		P = stoi(st.nextToken()); //부분문자열 길이
		DNAstr = br.readLine();

		DNAnums = new int[4]; // A C G T
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) DNAnums[i] = stoi(st.nextToken());

		System.out.println(Sliding());
    }

	public static int Sliding(){
		int count = 0 ;
		int start = 0 ; // 시작지점
		int end = P; //끝지점
		HashMap<Integer,Integer> hm = new HashMap<>();

		for(int i=0;i<P;i++){ //P 길이만큼
			int nowStr = DNAstr.charAt(i)-'A'; // 현재 문자
			if(hm.containsKey(nowStr)) hm.put(nowStr, hm.get(nowStr)+1); // 이미 들어있는 문자라면 +1
			else hm.put(nowStr, 1); // 없으면 1
		}

		if(CheckStr(hm)) count ++ ;
		// System.out.println(hm.toString());

		for(int i=P;i<S;i++){
			int befStr = DNAstr.charAt(i-P)-'A'; // 이전 문자
			hm.put(befStr, hm.get(befStr) -1);

			int nowStr = DNAstr.charAt(i)-'A'; // 현재 문자
			if(hm.containsKey(nowStr)) hm.put(nowStr, hm.get(nowStr)+1); // 이미 들어있는 문자라면 +1
			else hm.put(nowStr, 1); // 없으면 1

			if(CheckStr(hm)) count ++ ;
			// System.out.println(hm.toString());

		}

		return count ;
	}

	public static boolean CheckStr(HashMap hm){
		// DNAnums A C G T
		if((int)hm.getOrDefault(0,0) < DNAnums[0]) return false ;
		if((int)hm.getOrDefault(2,0) < DNAnums[1]) return false;
		if((int)hm.getOrDefault(6,0) < DNAnums[2] ) return false;
		if((int)hm.getOrDefault(19,0) < DNAnums[3]) return false;
		return true ;
	}
}
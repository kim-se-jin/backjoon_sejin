import java.io.*;
import java.util.*;

public class Main{

	static int S, P ;
	static char[] DNAstr;
	static int[] DNAnums = new int[20] ; // 0 ="A", 1="C", 6="G", 19="T"
	static int minA, minC, minG , minT ;
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = stoi(st.nextToken()); //DNA문자열 길이
		P = stoi(st.nextToken()); //부분문자열 길이
		DNAstr = br.readLine().toCharArray(); // 문자열 입력

		// 사용가능한 A,C,G,T 개수 입력받기
		st = new StringTokenizer(br.readLine());
		minA = stoi(st.nextToken());
		minC = stoi(st.nextToken());
		minG = stoi(st.nextToken());
		minT = stoi(st.nextToken());


		System.out.println(Sliding());
    }

	public static int Sliding(){
		int count = 0 ;
		int start = 0 ; // 시작지점
		int end = P; //끝지점

		for(int i=0;i<P;i++){ //P 길이만큼
			int nowStr = DNAstr[i]-'A'; // 현재 문자
			DNAnums[nowStr] ++ ;
		}

		if(CheckStr()) count ++ ;
		// System.out.println(hm.toString());

		for(int i=P;i<S;i++){
			int befStr = DNAstr[i-P]-'A'; // 이전 문자
			DNAnums[befStr] -- ;

			int nowStr = DNAstr[i]-'A'; // 현재 문자
			DNAnums[nowStr] ++ ;

			if(CheckStr()) count ++ ;
		}

		return count ;
	}

	public static boolean CheckStr(){
		// DNAnums A C G T
		if(DNAnums[0] >= minA && DNAnums[2] >= minC && DNAnums[6]>=minG && DNAnums[19]>=minT) return true ;
		else return false ;
	}
}
import java.io.*;
import java.util.*;


public class Main {
	static int N,arr[];
	static boolean ans = false ;
	static StringBuilder sb, str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sb = new StringBuilder();
		for(int i=0;i<N;i++){
			str = new StringBuilder(br.readLine());
			if(checkP(0, str.length()-1)){
				sb.append(0 + "\n");
			}else if(checkSimilarP(0,str.length()-1)){
				sb.append(1 + "\n");
			}else{
				sb.append(2 + "\n");
			}
		}
		System.out.print(sb);

    }

	public static boolean checkP(int left, int right){
		while(left<right){
			if(str.charAt(left) != str.charAt(right)) return false ;
			left ++ ;
			right -- ;
		}
		return true ;

	}

	public static boolean checkSimilarP(int left, int right){
		while(left<=right){
			if(str.charAt(left) != str.charAt(right)){
				boolean a = checkP(left+1, right);
				boolean b = checkP(left, right-1);
				if(!a && !b) return false ;
				else return true ;
			}
			left ++ ;
			right -- ;
		}
		return false ;
	}

}
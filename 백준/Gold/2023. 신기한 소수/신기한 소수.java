import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static StringBuilder sb;
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		sb = new StringBuilder();
		
		prime(0,0);
		System.out.print(sb);
    }

	public static void prime(int now, int depth){

		if(depth == N){
			sb.append(now+"\n");
			return ;
		}

		for(int i=1;i<=9;i++){
			int nowNum = now*10 + i;
			if(check(nowNum)) prime(nowNum,depth+1);
		}
	} 

	public static boolean check(int nowNum){
		if(nowNum < 2 ) return false ;
		for(int i=2;i<=Math.sqrt(nowNum);i++){
			if(nowNum%i == 0) return false ;
		}
		return true ;
	}
}
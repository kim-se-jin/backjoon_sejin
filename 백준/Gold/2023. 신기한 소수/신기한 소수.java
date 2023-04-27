import java.io.*;
import java.util.*;
public class Main {
	static int N;
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		
		// 1 일 떄 : 2,3,5,7
		// 2 일 때 : 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61
		prime("2",1);
		prime("3",1);
		prime("5",1);
		prime("7",1);


    }

	public static void prime(String str, int depth){

		if(depth == N){
			System.out.println(str);
			return ;
		}
		for(int i=1;i<=9;i++){
			String nowNum = str + String.valueOf(i);
			// System.out.println(nowNum);

			if(check(Integer.valueOf(nowNum))){
				prime(nowNum,depth+1);
			}
		}
	} 

	public static boolean check(int nowNum){
		for(int i=2;i<nowNum;i++){
			if(nowNum%i == 0) return false ;
		}
		return true ;
	}
}
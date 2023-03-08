import java.io.*;
import java.util.*;

public class Main{

	static int TC;
	static Stack<Integer> stack ;
	

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = stoi(br.readLine()); // TC 수

		StringBuilder sb = new StringBuilder();

		for(int TestCase = 0  ; TestCase<TC; TestCase ++){
			String[] nowPS = br.readLine().split(""); // 문자열 입력받기

			stack = new Stack<>();
			boolean check = true ;

			for(int i=0;i<nowPS.length;i++){
				if(nowPS[i].equalsIgnoreCase("(")){
					stack.push(0);
				}else{
					if(!stack.isEmpty())stack.pop();
					else check = false ;
				}

			}
			if(stack.isEmpty() && check) sb.append("YES"+"\n");
			else sb.append("NO"+"\n");
		}

		System.out.println(sb.toString());


    }


}
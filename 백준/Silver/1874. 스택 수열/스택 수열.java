import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static Stack<Integer> stack ;
	

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine()); // 1부터 까지의 수
		stack = new Stack<>();

		StringBuilder sb = new StringBuilder();

		int start = 1 ;

		for(int i=0;i<N;i++){
			int nowNums = stoi(br.readLine());
			
			while(start<=nowNums){
				stack.add(start);
				start ++ ;
				sb.append("+"+"\n");
			}
			
			if(!stack.isEmpty() && stack.peek() == nowNums){
				stack.pop();
				sb.append("-"+"\n");
			}

		}
		if(stack.isEmpty()){
			System.out.println(sb.toString());
		}else{
			System.out.println("NO");
		}


    }

	public static void CheckArr(int nowNums){
		
	}


}
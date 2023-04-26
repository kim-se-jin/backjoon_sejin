import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static String inputs[];
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int tc = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(tc-->0){
			N = stoi(br.readLine());
			inputs = br.readLine().split(" ");

			Deque<String> dq = new ArrayDeque<>();
			dq.add(inputs[0]);

			for(int i=1;i<N;i++){
				if(inputs[i].compareTo(dq.getFirst())>0){
					dq.offerLast(inputs[i]);
				}else{
					dq.offerFirst(inputs[i]);
				}
			}

			for(int i=0;i<N;i++) sb.append(dq.poll());
			sb.append("\n");
		}
		System.out.print(sb);
    }
}
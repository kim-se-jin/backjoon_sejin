import java.io.*;
import java.util.*;

public class Main{

	static int N;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}


    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> Math.abs(o1)==Math.abs(o2)?o1-o2:Math.abs(o1)-Math.abs(o2)));

		for(int i=0;i<N;i++){
			int nowNum = stoi(br.readLine());
			if(nowNum == 0 ){
				if(pq.isEmpty()){
					sb.append(0+"\n");
				}else{
					sb.append(pq.poll()+"\n");
				}
			}
			else pq.add(nowNum);
		}

		System.out.println(sb.toString());

	}
}
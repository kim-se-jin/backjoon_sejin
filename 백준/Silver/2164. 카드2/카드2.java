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
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) queue.add(i);
		int idx = 1 ;
		while(queue.size()>1){
			queue.poll(); // 제일 위에 있는 카드를 바닥에 버린다
			int moveNum = queue.poll(); // 그 다음 카드를 제일 아래에 넣는다
			queue.add(moveNum);
			// System.out.println(queue.toString());
		}
		System.out.println(queue.peek());
	}
}
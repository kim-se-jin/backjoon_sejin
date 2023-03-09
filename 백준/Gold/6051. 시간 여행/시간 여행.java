import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static ArrayList<Integer> befSolved ;
	static HashMap<Integer, ArrayList<Integer>> history ;
	static Stack<Integer>[] stack;
	static StringTokenizer st ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

//'a' : K인 문제를 풀고 기록

//'s' : 가장 최근에 작성한 문제 목록 삭제

//'t' : K 쿼리  바로 전에 있던 푼 문제 목록으로 되돌아 감

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = stoi(br.readLine()); // 쿼리 개수
		history = new HashMap<>();
		stack = new Stack[N+1];
		stack[0] = new Stack<>();
		
		for(int i=1;i<=N;i++){
			st  = new StringTokenizer(br.readLine());
			stack[i] = new Stack<>();
			String query = st.nextToken();
			switch(query){
				case "s":
					stack[i].addAll(stack[i-1]);
					if(!stack[i].isEmpty()) stack[i].pop();
					break;
				case "a":
					int num = stoi(st.nextToken());
					stack[i].addAll(stack[i-1]);
					stack[i].add(num);
					break;
				case "t":
					int Tnum = stoi(st.nextToken());
					stack[i].addAll(stack[Tnum-1]);
					break;
			}

			if(stack[i].isEmpty()) sb.append(-1+"\n");
			else sb.append(stack[i].peek()+"\n");
		}

		System.out.println(sb.toString());

    }


}
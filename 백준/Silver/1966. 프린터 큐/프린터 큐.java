import java.io.*;
import java.util.*;

class Print{
	int idx, priority;
	Print(int idx, int priority){
		this.idx = idx ;
		this.priority = priority;
	}
}

public class Main{

	static int TC, maxPriority ;
	static Queue<Print> q ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}


    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = stoi(br.readLine());

		for(int TestCase = 0 ; TestCase<TC; TestCase ++){

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken()); // N개의 문서
			int M = stoi(st.nextToken()); // M번째 문서 출력 순서
			// System.out.println(N + " , " + M);

			q = new LinkedList<>();
			int maxPriority = 0 ;
			ArrayList<Integer> Priority = new ArrayList<>();

			String[] now = br.readLine().split(" ");
			for(int i=0;i<N;i++){
				int nowPR = stoi(now[i]);  
				q.add(new Print(i,nowPR));
				maxPriority = Math.max(maxPriority,nowPR);
				Priority.add(nowPR);
			}
			
			int count = 0 ;
			Collections.sort(Priority , Collections.reverseOrder());

			for(int i=0;i<N;i++){ // 중요도 1~9
				int maxPR = Priority.get(i);
					// 탐색 시작
				while(!q.isEmpty()){
					Print nowPrint = q.poll();
					int nowPR = nowPrint.priority;
					if(nowPR < maxPR){ // 큐의 맨 앞의 중요도가 최대값보다 작을 때
						// 빼고 맨 뒤로 넣음
						q.add(new Print(nowPrint.idx, nowPR));
					}else{ // 큐의 맨 앞의 요소가 제일 큰 우선순위와 같을 때
						count ++ ;
						if(nowPrint.idx == M){
							System.out.println(count);
						}
						break; 
					}
				}
				
			}
		}
	}
}
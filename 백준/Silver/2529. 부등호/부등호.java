import java.io.*;
import java.util.*;

public class Main {
	static int N,arr[];
	static StringBuilder sb ;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			String now = st.nextToken();
			if(now.equalsIgnoreCase(">")) arr[i] = 1 ;
			else arr[i] = 0 ;
		}

		sb = new StringBuilder();
		BigNum();
		sb.append("\n");
		SmallNum();
		System.out.print(sb);
	}

	public static void BigNum(){
		int nowNum = 9 ;
		int stopCount = 0 ;
		boolean stop = false;

		for(int i=0;i<N+1;i++){
			if(arr[i]==1 || i==N){
				if(stop){
					int addNum = nowNum;
					while(stopCount>=0){
						sb.append(addNum);
						stopCount--;
						addNum++;
					}
					stop = false ;
					stopCount = 0 ;
				}else sb.append(nowNum);
				
			}else{
				stop = true;
				stopCount ++; // 몇 번 멈췄는 지
			}
			nowNum -- ; // 추가해야 할 번호
		}
	}

	public static void SmallNum(){
		int nowNum = 0 ;
		int stopCount = 0 ;
		boolean stop = false;
		for(int i=0;i<N+1;i++){
			if(arr[i] == 0 || i==N ){
				if(stop){
					int addNum = nowNum;
					while(stopCount>=0){
						sb.append(addNum);
						stopCount--;
						addNum--;
					}
					stop = false ;
					stopCount = 0 ;
				}else sb.append(nowNum);
			}else{
				stop = true ;
				stopCount ++ ;
			}
			nowNum ++ ; // 추가해야할 번호
		}
		
	}
}